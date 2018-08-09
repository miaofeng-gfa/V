package com.veeca.ted.v.view.hello;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.veeca.ted.v.R;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.SharedPrefenencesUtils;
import com.veeca.ted.v.view.login.LoginActivity;
import com.veeca.ted.v.view.main.MainActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HelloActivity extends MVPBaseActivity<HelloContract.View, HelloPresenter> implements HelloContract.View {

    private Handler handler;
    private SharedPrefenencesUtils utils;
    private int onFirst, userState;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        utils = SharedPrefenencesUtils.getInstance();
        onFirst = (int) utils.getData("onFirst", 0);
        //todo 测试
//        utils.saveData("userId", "30512");
//        utils.saveData("token", "2a21aa44-3195-4591-a807-303052cd81c0");
//        utils.saveData("userState", 1);

        Constant.setUserId((String) utils.getData("userId", "0"));
        Constant.setToken((String) utils.getData("token", "token"));
        Constant.setUserState((Integer) utils.getData("userState", 0));
        userState = Constant.getUserState();
        if (onFirst != 0) mPresenter.getProperties();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goNext();
            }
        }, 3000);
    }

    private void goNext() {
        if (onFirst == 0) {
            utils.saveData("onFirst", 1);
            intent = new Intent(this, Hello2Activity.class);
            startActivity(intent);
            finish();
        } else {
            if (userState == 1) {
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
