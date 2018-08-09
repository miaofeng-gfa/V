package com.veeca.ted.v.view.login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Login;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.SharedPrefenencesUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.bindphone.BindPhoneActivity;
import com.veeca.ted.v.view.main.MainActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {


    @BindView(R.id.login_bg)
    ImageView loginBg;
    @BindView(R.id.tv_mobile_login)
    TextView tvMobileLogin;
    private SharedPrefenencesUtils utils;
    private Intent intent;
    private Context context;
    private int resultCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        context = getContext();
        utils = SharedPrefenencesUtils.getInstance();
        intent = getIntent();
        resultCode = intent.getIntExtra("resultCode", 0);
        Glide.with(context).load(R.drawable.login_gif).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(loginBg);
        System.out.println("kkkkkkkkkkk=========="+utils.getData("firstlogin", 0));
        if( (Integer)utils.getData("firstlogin", 0)!=1){
            tvMobileLogin.setVisibility(View.INVISIBLE);
        }else {
            tvMobileLogin.setVisibility(View.VISIBLE);
        }


    }


    @OnClick(R.id.login_btn)
    public void onViewClicked() {
        LoadUtil.showLoad(this);
        UMShareAPI.get(this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
        utils.saveData("firstlogin", 1);
    }

    @OnClick(R.id.tv_mobile_login)
    public void onMoblieClicked() {

        intent = new Intent(context, BindPhoneActivity.class);
        intent.putExtra("resultCode", resultCode);
        startActivityForResult(intent, 131);

    }

    @Override
    public void showLogin(Login login) {
        LoadUtil.hideLoad();
        LogUtils.e(login.toString());
        if (login.isSuccess()) {
            utils.saveData("userId", login.getData().getUserid());
            utils.saveData("token", login.getData().getToken());
            Constant.setUserId((String) utils.getData("userId", "0"));
            Constant.setToken((String) utils.getData("token", "token"));

            mPresenter.getProperties();
            if (login.isStatus()) {
                //todo 需要绑手机
               /* intent = new Intent(context, BindPhoneActivity.class);
                intent.putExtra("resultCode", resultCode);
                startActivityForResult(intent, 131);*/
            } else {
                //todo 不需要绑手机
                utils.saveData("userState", 1);
                Constant.setUserState((Integer) utils.getData("userState", 0));
                intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        } else ToastUtils.setToast("登录失败");
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            mPresenter.getLogin(data.get("iconurl"), data.get("name"), "男".equals(data.get("gender")) ? 1 : 0,
                    data.get("country"), data.get("prvinice"), data.get("city"), data.get("openid"), data.get("unionid"));
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            LogUtils.e("onError:" + t.toString());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        if (requestCode == 131 && resultCode == 131) {
            utils.saveData("userState", 1);
            Constant.setUserState((Integer) utils.getData("userState", 0));
            intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //UMShareAPI内存泄漏
        UMShareAPI.get(this).release();
    }
}
