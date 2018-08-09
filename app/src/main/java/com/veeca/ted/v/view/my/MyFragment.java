package com.veeca.ted.v.view.my;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.approve.ApproveActivity;
import com.veeca.ted.v.view.buy.BuyActivity;
import com.veeca.ted.v.view.influence.InfluenceActivity;
import com.veeca.ted.v.view.invite.InviteActivity;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;
import com.veeca.ted.v.view.mymoney.MyMoneyActivity;
import com.veeca.ted.v.view.myprofile.MyProfileActivity;
import com.veeca.ted.v.view.myprofit.MyProfitActivity;
import com.veeca.ted.v.view.position.PositionActivity;
import com.veeca.ted.v.widget.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyFragment extends MVPBaseFragment<MyContract.View, MyPresenter> implements MyContract.View {

    @BindView(R.id.user_avatar)
    CircleImageView userAvatar;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.my_state)
    TextView myState;
    @BindView(R.id.my_influence)
    TextView myInfluence;
    Unbinder unbinder;
    @BindView(R.id.ward_cont)
    TextView wardCont;
    private Activity mActivity;
    private Intent intent;
    private String qrcode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        unbinder = ButterKnife.bind(this, view);
        mActivity = getActivity();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.click_my1, R.id.click_my2, R.id.click_my3, R.id.click_my4, R.id.click_my5,  R.id.click_my7, R.id.my_invite, R.id.my_profile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.click_my1:
                intent = new Intent(mActivity, ApproveActivity.class);
                startActivity(intent);
                break;
            case R.id.click_my2:
                intent = new Intent(mActivity, BuyActivity.class);
                startActivity(intent);
                break;
            case R.id.click_my3:
                intent = new Intent(mActivity, InfluenceActivity.class);
                startActivity(intent);
                break;
            case R.id.click_my4:
                intent = new Intent(mActivity, MyMoneyActivity.class);
                startActivity(intent);
                break;
            case R.id.click_my5:
                intent = new Intent(mActivity, MyProfitActivity.class);
                startActivity(intent);
                break;
          /*  case R.id.click_my6:
                intent = new Intent(mActivity, SetActivity.class);
                startActivityForResult(intent, 234);
                break;*/
            case R.id.click_my7:
                intent = new Intent(mActivity, PositionActivity.class);
                startActivity(intent);
                break;
            case R.id.my_invite:
                intent = new Intent(mActivity, InviteActivity.class);
                intent.putExtra("qrcode", qrcode);
                startActivity(intent);
                break;
            case R.id.my_profile:
                intent = new Intent(mActivity, MyProfileActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        LoadUtil.showLoad(mActivity);
        mPresenter.getUserInfo();
        mPresenter.getWardCont();
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        LoadUtil.hideLoad();
        qrcode = userInfo.getData().getQrCode();
        Glide.with(mActivity).load(userInfo.getData().getHeadimgurl()).into(userAvatar);
        userName.setText(userInfo.getData().getNickname());
        myInfluence.setText(userInfo.getData().getInfluence());
        switch (userInfo.getData().getState()) {
            case 0:
                myState.setText("未认证");
                myState.setTextColor(mActivity.getResources().getColor(R.color.yellow));
                break;
            case 1:
                myState.setText("资料审核中");
                myState.setTextColor(mActivity.getResources().getColor(R.color.font_gray_9));
                break;
            case 2:
                myState.setText("已认证");
                myState.setTextColor(mActivity.getResources().getColor(R.color.yellow));
                break;
            default:
                myState.setText("认证不通过");
                myState.setTextColor(mActivity.getResources().getColor(R.color.font_fa));
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 234 && resultCode == 234) {
            getActivity().finish();
        }
    }

    @Override
    public void showError() {
        LoadUtil.hideLoad();
        ToastUtils.setToast("网络异常");
    }

    @Override
    public void showWardCont(Results results) {
        switch (results.getState()) {
            case 0:
                wardCont.setText("未认证");
                wardCont.setTextColor(mActivity.getResources().getColor(R.color.font_gray_9));
                break;
            case 1:
                wardCont.setTextColor(mActivity.getResources().getColor(R.color.font_gray_9));
                wardCont.setText("审核中");
                break;
            case 2:
                wardCont.setTextColor(mActivity.getResources().getColor(R.color.yellow));
                wardCont.setText("已认证");
                break;
        }
    }

}
