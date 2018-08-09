package com.veeca.ted.v.view.set;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.SharedPrefenencesUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.utils.cache.DataCleanManager;
import com.veeca.ted.v.view.login.LoginActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SetActivity extends MVPBaseActivity<SetContract.View, SetPresenter> implements SetContract.View {

    @BindView(R.id.set_cache)
    TextView setCache;
    private Context context;
    private Intent intent;
    private Bitmap bitmap;
    private String cache;
    private SharedPrefenencesUtils utils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
        utils = SharedPrefenencesUtils.getInstance();
        context = getContext();
        try {
            cache = DataCleanManager.getTotalCacheSize(context);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(e.toString());
        }
        setCache.setText(cache);
    }

    @OnClick({R.id.top_return, R.id.cache_btn, R.id.set_btn2, R.id.set_btn1, R.id.set_btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.cache_btn://清除缓存
                DataCleanManager.clearAllCache(context);
                try {
                    cache = DataCleanManager.getTotalCacheSize(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.e(e.toString());
                }
                ToastUtils.setToast("缓存清理完成");
                setCache.setText(cache);
                break;
            case R.id.set_btn2://关于小V咖
                intent = new Intent(SetActivity.this, Set2Activity.class);
                startActivity(intent);
                break;
            case R.id.set_btn1://下载二维码
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.veeca_card);
                String path = "/sdcard/" + "veeca.jpg";
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(path);
                    if (fos != null) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        fos.close();
                        ToastUtils.setToast("保存成功");
                        SetActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.set_btn3://退出登录
                utils.saveData("userId", "0");
                utils.saveData("token", "token");
                utils.saveData("userState", 0);
                Constant.setUserState((Integer) utils.getData("userState", 0));
                Constant.setToken((String) utils.getData("token", "token"));
                Constant.setUserId((String) utils.getData("userId", "0"));
                setResult(234);
                intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
