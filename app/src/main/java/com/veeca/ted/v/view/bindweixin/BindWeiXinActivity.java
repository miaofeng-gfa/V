package com.veeca.ted.v.view.bindweixin;


import android.Manifest;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.constant.MyApplication;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindWeiXinActivity extends MVPBaseActivity<BindWeiXinContract.View, BindWeiXinPresenter> implements BindWeiXinContract.View {

    @BindView(R.id.bind_up)
    ImageView bindUp;
    private Context context;
    private String url, image_url;
    private Intent intent;
    private final int PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_weixin);
        ButterKnife.bind(this);
        mActivity = this;
        context = getContext();
        url = null;
        intent = getIntent();
    }

    @OnClick({R.id.top_return, R.id.bind_up, R.id.bind_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.bind_up:
                initPermissions();
                break;
            case R.id.bind_btn:
                if (url != null) {
                    LoadUtil.showLoad(mActivity);
                    uploadData(url);
                } else LogUtils.e("url为空");
                break;
        }
    }

    // 授权管理
    private void initPermissions() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            LogUtils.e("需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                LogUtils.e("拒绝过了");
                Toast.makeText(context, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
            } else {
                LogUtils.e("进行授权");
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            LogUtils.e("不需要授权 ");
            openAlbum();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {
            if (Build.VERSION.SDK_INT > 19) {
                handleImageOnKitKat(data);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                LogUtils.e("同意授权");
                openAlbum();
            } else {
                LogUtils.e("拒绝授权");
            }
        }
    }

    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            imagePath = uri.getPath();
        }
        displayImage(imagePath);
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            url = imagePath;
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            bindUp.setImageBitmap(bitmap);
        } else {
            ToastUtils.setToast("请重新选择图片");
        }
    }

    private String getImagePath(Uri externalContentUri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(externalContentUri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
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
                mPresenter.upUserPhoto(0, image_url);
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
    public void showUserPhoto(Results results) {
        LoadUtil.hideLoad();
        if (results.isSuccess()) {
            ToastUtils.setToast("上传成功");
            setResult(232);
            finish();
        } else {
            ToastUtils.setToast("网络异常");
        }
    }
}
