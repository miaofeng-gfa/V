package com.veeca.ted.v.view.center;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.approve.ApproveActivity;
import com.veeca.ted.v.view.influence.InfluenceActivity;
import com.veeca.ted.v.view.invite.InviteActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.view.myprofile.MyProfileActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CenterActivity extends MVPBaseActivity<CenterContract.View, CenterPresenter> implements CenterContract.View {

    @BindView(R.id.center_influence)
    TextView centerInfluence;
    private Context context;
    private Intent intent;
    private String qrcode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        ButterKnife.bind(this);
        intent = getIntent();
        qrcode = intent.getStringExtra("qrcode");
        context = getContext();
        mPresenter.getUserInfo();
    }

    @OnClick({R.id.top_return, R.id.center_btn1, R.id.center_btn2, R.id.center_btn3, R.id.center_btn4, R.id.center_btn5, R.id.center_btn6, R.id.center_btn, R.id.top_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.center_btn1:
                finish();
                break;
            case R.id.center_btn2:
                intent = new Intent(context, InviteActivity.class);
                intent.putExtra("qrcode", qrcode);
                startActivity(intent);
                break;
            case R.id.center_btn3:
                ToastUtils.setToast("功能正在完善中...");
                break;
            case R.id.center_btn4:
//                intent = new Intent(context, ApproveActivity.class);
                intent = new Intent(context, MyProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.center_btn5:
                intent = new Intent(context, ApproveActivity.class);
                startActivity(intent);
                break;
            case R.id.center_btn6:
                if (Constant.getUserRep() > 0) {
                    intent = new Intent(context, InfluenceActivity.class);
                    startActivity(intent);
                } else ToastUtils.setToast("请先完成小V认证");
                break;
            case R.id.center_btn:
                finish();
                break;
            case R.id.top_btn:
                intent = new Intent(context, WebActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        centerInfluence.setText(userInfo.getData().getInfluence());
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }

}
