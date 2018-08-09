package com.veeca.ted.v.view.bindphone;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindPhoneActivity extends MVPBaseActivity<BindPhoneContract.View, BindPhonePresenter> implements BindPhoneContract.View {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.get_code)
    Button getCode;
    @BindView(R.id.phone_btn)
    Button phoneBtn;
    private Activity activity;
    private String userPhone;
    private String userCode;
    private CountDownTimer timer;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_phone);
        ButterKnife.bind(this);
        activity = this;
        phoneBtn.setFocusable(false);
        code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 4) {
                    phoneBtn.setFocusable(true);
                    phoneBtn.setBackgroundResource(R.mipmap.phone_btn_s);
                } else {
                    phoneBtn.setFocusable(false);
                    phoneBtn.setBackgroundResource(R.mipmap.phone_btn_n);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //倒计时
        timer = new CountDownTimer(61000, 1000) {
            int num = 60;

            @Override
            public void onTick(long millisUntilFinished) {
                getCode.setBackgroundResource(R.drawable.phone_kuang_n);
                getCode.setText("重新获取" + num + "秒");
                num--;
            }

            @Override
            public void onFinish() {
                //计时完成调用
                num = 60;
                getCode.setEnabled(true);
                getCode.setText("获取验证码");
                getCode.setBackgroundResource(R.drawable.phone_kuang);
            }
        };
    }

    @OnClick({R.id.get_code, R.id.phone_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_code:
                userPhone = phone.getText().toString();
                if (userPhone == null)
                    ToastUtils.setToast("请输入手机号");
                else {
                    LoadUtil.showLoad(activity);
                    getCode.setEnabled(false);
                    timer.start();
                    mPresenter.getCode(userPhone);
                }
                break;
            case R.id.phone_btn:
                userCode = code.getText().toString();
                userPhone = phone.getText().toString();
                if (userPhone.length() == 11) {
                    LoadUtil.showLoad(activity);
                    mPresenter.getPhone(userPhone, userCode);
                } else ToastUtils.setToast("请输入正确的手机号");
                break;
        }
    }

    @Override
    public void showCode(Results results) {
        LoadUtil.hideLoad();
        LogUtils.e(results.toString());
        if (results.isSuccess()) ToastUtils.setToast("获取成功");
        else ToastUtils.setToast("获取失败");
    }

    @Override
    public void showPhone(Results results) {
        LogUtils.e(results.toString());
        LoadUtil.hideLoad();
        if (results.isSuccess()) {
            intent = getIntent();
            setResult(131);
            finish();
        } else ToastUtils.setToast("网络异常");
    }
}
