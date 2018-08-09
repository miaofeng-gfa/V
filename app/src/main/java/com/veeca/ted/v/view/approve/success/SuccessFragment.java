package com.veeca.ted.v.view.approve.success;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.constant.MyApplication;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.utils.cache.DataCleanManager;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.veeca.ted.v.utils.DateUtils.getCurrentTime;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SuccessFragment extends MVPBaseFragment<SuccessContract.View, SuccessPresenter> implements SuccessContract.View {

    Unbinder unbinder;
    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.camera)
    Button camera;
    private Context context;
    private Uri imageUri;
    private Intent takePictureIntent;
    private int TAKE_PHOTO = 109;
    private File outputImage;
    private File upImage;
    private String image_url;
    private String permission = Manifest.permission.CAMERA;
    private int callLogRequestCode = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_success, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private boolean flag = false;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.camera, R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.camera:
                flag = checkPermission(permission);
                if (flag) takePhoto();
                else new AlertDialog.Builder(context)
                        .setTitle("重要提示:")
                        .setMessage("无法获取摄像头权限将不能上传名片或工牌")
                        .setNegativeButton("设置", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                                intent.setData(uri);
                                startActivityForResult(intent, callLogRequestCode);
                            }
                        })
                        .setCancelable(true)
                        .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPerssion(new String[]{permission}, 1);
                            }
                        }).show();
                break;
            case R.id.btn1:
                getActivity().finish();
                break;
            case R.id.btn2:
                //todo 调用上传接口
                if (upImage != null) {
                    LoadUtil.showLoad(getActivity());
                    uploadData(upImage.getPath());
                } else ToastUtils.setToast("请选择照片");
                break;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //已经授权，更新

        } else {
            //点击了不再提示,拒绝权限
            if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permissions[0])) {
                //跳转到设置界面
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                startActivityForResult(intent, callLogRequestCode);

            } else {
                //拒绝权限

            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == callLogRequestCode) {
        }
        if (requestCode == TAKE_PHOTO) {
            if (resultCode == RESULT_OK) {
                upImage = outputImage;
                Glide.with(context).load(upImage).thumbnail(0.1f).into(photo);
                /*  过渡动画+加载图+错误图
                Glide.with(context).load(upImage).placeholder(R.mipmap.photo_bg)
                        .error(R.mipmap.photo_bg)
                        .crossFade().bitmapTransform(new RoundedCornersTransformation(context, 24, 0,
                        RoundedCornersTransformation.CornerType.ALL)).into(photo);*/
            }
            LoadUtil.hideLoad();
        }
    }

    //拍照的代码
    private void takePhoto() {
        LoadUtil.showLoad(getActivity());
        takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
            //创建一个File
            String date = getCurrentTime("yyyyMMddHHmmss");
            outputImage = new File(context.getExternalCacheDir(), date + "image.jpg");
            if (outputImage != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //如果是7.0及以上的系统使用FileProvider的方式创建一个Uri
                    imageUri = FileProvider.getUriForFile(context, "com.example.cameraalbumtest.fileprovider", outputImage);
                    takePictureIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    takePictureIntent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                } else {
                    //7.0以下使用这种方式创建一个Uri
                    imageUri = Uri.fromFile(outputImage);
                }
                //将Uri传递给系统相机
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, TAKE_PHOTO);
            }
        }
    }


    /**
     * 上传图片
     */
    private void uploadData(String uploadFilePath) {

        PutObjectRequest put = new PutObjectRequest(MyApplication.OSS_BUCKET, "android/image/" + getImageObjectKey("veeca"), uploadFilePath);

        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                Log.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
            }
        });

        MyApplication.oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(final PutObjectRequest request, PutObjectResult result) {
                //将上传成功的图片地址传给自己的服务器后台，比如修改用户数据库中，用户头像的url。
                //修改后台url成功后，再利用glide 下载最新的照片，修改本地头像图片。
                //request.getObjectKey() 是图片地址，但是不包含，OSS 图片域名
                image_url = Constant.URL + request.getObjectKey();
                //调用绑定微信或第三方
                mPresenter.getUserCard(image_url);
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // 服务异常
                LoadUtil.hideLoad();
                ToastUtils.setToast("网络异常");
                LogUtils.e("request+" + request);
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    LogUtils.e("clientExcepion+" + clientExcepion.toString());
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常
                }
            }

        });
    }

    //通过UserCode 加上日期组装 OSS路径
    private String getImageObjectKey(String strUserCode) {
        Date date = new Date();
        return strUserCode + new SimpleDateFormat("yyyyMMddssSSS").format(date) + ".jpg";
    }

    @Override
    public void showUserCard(Results results) {
        LoadUtil.hideLoad();
        if (results.isSuccess()) {
            ToastUtils.setToast("上传成功");
            DataCleanManager.clearAllCache(context);
            getActivity().finish();
        } else {
            ToastUtils.setToast("网络异常");
        }
    }
}
