package com.veeca.ted.v.view.vshow;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.VInfo;
import com.veeca.ted.v.bean.VLive;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.widget.CircleImageView;
import com.veeca.ted.v.widget.CountDownTimerView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VShowActivity extends MVPBaseActivity<VShowContract.View, VShowPresenter> implements VShowContract.View {

    @BindView(R.id.user_avatar)
    CircleImageView userAvatar;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_content)
    TextView userContent;
    @BindView(R.id.user_number)
    TextView userNumber;
    @BindView(R.id.user_money)
    TextView userMoney;
    @BindView(R.id.bidding_number)
    TextView biddingNumber;
    @BindView(R.id.bidding_recycler)
    RecyclerView biddingRecycler;
    @BindView(R.id.show_bidding)
    LinearLayout showBidding;
    @BindView(R.id.flow_tag)
    TagFlowLayout flowTag;
    @BindView(R.id.image_recycler)
    RecyclerView imageRecycler;
    @BindView(R.id.live_recycler)
    RecyclerView liveRecycler;
    @BindView(R.id.tag_cloud)
    TagCloudView tagCloud;
    @BindView(R.id.show_linear)
    LinearLayout showLinear;
    @BindView(R.id.show_btn)
    LinearLayout showBtn;
    @BindView(R.id.btn_time)
    CountDownTimerView btnTime;
    private Context context;
    private Activity activity;
    private Intent intent;
    private int rid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_show);
        ButterKnife.bind(this);
        context = getContext();
        intent = getIntent();
        rid = intent.getIntExtra("rid", 0);
        LoadUtil.showLoad(activity);
        mPresenter.getVInfo(rid);
    }

    @OnClick({R.id.top_return, R.id.all_bidding, R.id.show_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.all_bidding:
                break;
            case R.id.show_btn:
                break;
        }
    }

    @Override
    public void showVInfo(VInfo vInfo) {
        if (vInfo.isSuccess()) {
            mPresenter.getVTag(rid);
            Glide.with(context).load(vInfo.getXiaovFlockRec().getHeadImgUrl()).into(userAvatar);
            userName.setText(vInfo.getXiaovFlockRec().getName());
            userContent.setText(vInfo.getXiaovFlockRec().getPosition());
            userMoney.setText(vInfo.getXiaovFlockRec().getCpc());
            userNumber.setText("粉丝量:  " + vInfo.getXiaovFlockRec().getFansNum() + "      流量峰值:  " + vInfo.getXiaovFlockRec().getFlowNum());
            if (vInfo.getXiaovFlockRec().getStatus() == 1) {
                mPresenter.getVLive(rid);
                showBidding.setVisibility(View.VISIBLE);


            }
        } else {
            LoadUtil.hideLoad();
            ToastUtils.setToast("网络异常");
            finish();
        }
    }

    @Override
    public void showVTag(List<String> list) {
        LoadUtil.hideLoad();
        flowTag.setAdapter(new TagAdapter<String>(list) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_show_tag,
                        flowTag, false);
                tv.setText(s);
                return tv;
            }
        });
    }

    @Override
    public void showReward(Results results) {

    }

    @Override
    public void showEngagement(Results results) {

    }

    @Override
    public void showVLive(List<VLive> vLives) {

    }
}
