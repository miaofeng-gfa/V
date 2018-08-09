package com.veeca.ted.v.view.bindalipay;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.extract.ExtractActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindALiPayActivity extends MVPBaseActivity<BindALiPayContract.View, BindALiPayPresenter> implements BindALiPayContract.View {

    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_idCard)
    EditText edIdCard;
    @BindView(R.id.ed_alipay)
    EditText edAlipay;
    @BindView(R.id.bind_btn)
    Button bindBtn;
    private UserInfo.DataBean dataBean;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_alipay);
        ButterKnife.bind(this);
        mPresenter.getUserInfo();
    }

    @OnClick({R.id.top_return, R.id.bind_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.bind_btn:
                bindBtn.setFocusable(false);
                if (!edAlipay.getText().toString().isEmpty()) {
                    mPresenter.getBindALiPay(dataBean.getIdcardname(), dataBean.getIdcard(), edAlipay.getText().toString());
                } else {
                    ToastUtils.setToast("请输入支付宝账号");
                }
                break;
        }
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        dataBean = userInfo.getData();
        edName.setText(dataBean.getIdcardname());
        edIdCard.setText(dataBean.getIdcard());
        edName.setFocusable(false);
        edName.setEnabled(false);
        edIdCard.setEnabled(false);
        edIdCard.setFocusable(false);
    }

    @Override
    public void showBindALiPay(Results results) {
        ToastUtils.setToast("绑定成功");
        bindBtn.setFocusable(true);
        intent = new Intent(this, ExtractActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showError() {
        bindBtn.setFocusable(true);
        ToastUtils.setToast("网络异常");
    }
}
