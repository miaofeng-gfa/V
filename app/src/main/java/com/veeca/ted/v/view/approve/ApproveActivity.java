package com.veeca.ted.v.view.approve;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.umeng.socialize.UMShareAPI;
import com.veeca.ted.v.R;
import com.veeca.ted.v.eventbus.ApproveEventbus;
import com.veeca.ted.v.view.approve.account.AccountFragment;
import com.veeca.ted.v.view.approve.card.CardFragment;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ApproveActivity extends MVPBaseActivity<ApproveContract.View, ApprovePresenter> implements ApproveContract.View {

    @BindView(R.id.approve_frame)
    FrameLayout approveFrame;
   /* @BindViews({R.id.approve_tag1, R.id.approve_tag2})*/
    List<ImageView> approveTags;

    private Fragment account_frag, card_frag;
    private List<Fragment> fragments;
    private Context context;
    // 默认的ID(白色的图片)
    private int[] arr_id_default = {
            R.mipmap.tag_1_n,
            R.mipmap.tag_2_n
    };
    // 选中的ID(黄色的图片)
    private int[] arr_id_selected = {
            R.mipmap.tag_1,
            R.mipmap.tag_2
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        context = getContext();
        initFragment();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventNext(ApproveEventbus event) {
        Glide.with(context).load(R.mipmap.tag_1_n).into(approveTags.get(0));
        Glide.with(context).load(R.mipmap.tag_2).into(approveTags.get(1));
    }

    private void initFragment() {
        account_frag = new AccountFragment();
        card_frag = new CardFragment();
        fragments = new ArrayList<>();
        fragments.add(account_frag);
        fragments.add(card_frag);

        change(fragments.get(0));
//        checkHighLight(0);
    }

    /**
     * 切换碎片的方法
     *
     * @author TED
     * created at 2017/11/15 19:09
     */
    private void change(Fragment f) {
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.approve_frame, f)
                .commit();// 提交事务
    }

    /**
     * 选中高亮
     *
     * @author TED
     * created at 2017/11/15 19:09
     */
    private void checkHighLight(int index) {
        // 高亮字体
        // 高亮图标
        // 全部的图标要先统一程默认的图标
        setAllImageDefault();
        Glide.with(context).load(arr_id_selected[index]).into(approveTags.get(index));
    }

    /**
     * 设置默认图片资源
     *
     * @author TED
     * created at 2017/11/15 19:08
     */
    private void setAllImageDefault() {
        for (int i = 0; i < approveTags.size(); i++) {
            Glide.with(context).load(arr_id_selected[i]).into(approveTags.get(i));
        }
    }


    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
