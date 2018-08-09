package com.veeca.ted.v.view.bindaccount;


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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class BindaccountActivity extends MVPBaseActivity<BindaccountContract.View, BindaccountPresenter> implements BindaccountContract.View {

    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.layout1)
    RelativeLayout layout1;
    @BindView(R.id.layout2)
    LinearLayout layout2;
    @BindView(R.id.bind_up)
    ImageView bindUp;
    @BindView(R.id.image)
    ImageView image;
    private Context context;
    private Activity mActivity;
    private Intent intent;
    private String title, image_url, url;
    private int bind_id;
    private final int PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_account);
        ButterKnife.bind(this);
        context = getContext();
        intent = getIntent();
        mActivity = this;
        title = intent.getStringExtra("title");
        bind_id = intent.getIntExtra("id", 99);
        initData();
    }

    private void initData() {
        topTitle.setText(title);
        switch (bind_id) {
            case 3://知乎
                Glide.with(context).load(R.mipmap.zhihu1).into(image);
                break;
            case 4://公众号
                Glide.with(context).load(R.mipmap.gongzhonghao1).into(image);
                break;
            case 5://贴吧
                Glide.with(context).load(R.mipmap.tieba1).into(image);
                break;
            case 6://豆瓣
                Glide.with(context).load(R.mipmap.douban1).into(image);
                break;
            case 7://京东
                Glide.with(context).load(R.mipmap.jingdong1).into(image);
                break;
            case 8://淘宝
                Glide.with(context).load(R.mipmap.taobao1).into(image);
                break;
            case 9://秒拍
                Glide.with(context).load(R.mipmap.miaopai1).into(image);
                break;
            case 10://斗鱼
                Glide.with(context).load(R.mipmap.douyu1).into(image);
                break;
            case 11://映客
                Glide.with(context).load(R.mipmap.yingke1).into(image);
                break;
            case 12://天涯
                Glide.with(context).load(R.mipmap.tianya1).into(image);
                break;
            case 13://美拍
                Glide.with(context).load(R.mipmap.meipai1).into(image);
                break;
            case 14://快手
                Glide.with(context).load(R.mipmap.kuaishou1).into(image);
                break;
            case 15://花椒
                Glide.with(context).load(R.mipmap.huajiao1).into(image);
                break;
            case 16://陌陌
                Glide.with(context).load(R.mipmap.momo1).into(image);
                break;
            case 17://nice
                Glide.with(context).load(R.mipmap.nice1).into(image);
                break;
            case 18://小红书
                Glide.with(context).load(R.mipmap.xiaohongshu1).into(image);
                break;
            case 19://领英
                Glide.with(context).load(R.mipmap.lingying1).into(image);
                break;
        }
    }

    @OnClick({R.id.top_return, R.id.bind_up, R.id.account_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.bind_up:
                initPermissions();
                break;
            case R.id.account_btn:
                if (url != null) {
                    LoadUtil.showLoad(mActivity);
                    uploadData(url);
                } else
                    ToastUtils.setToast("请选择截图");
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
                mPresenter.upUserThird2(bind_id, image_url);
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

    @Override
    public void showError() {
        LoadUtil.hideLoad();
        ToastUtils.setToast("网络异常");
    }

    @Override
    public void showThird(Results results) {
        LoadUtil.hideLoad();
        finish();
    }
}
