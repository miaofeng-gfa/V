package com.veeca.ted.v.view.home;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.AllCircleAdapter;
import com.veeca.ted.v.adapter.MyFragmentAdapater;
import com.veeca.ted.v.bean.mian.AllCircle;
import com.veeca.ted.v.bean.mian.FriendCount;
import com.veeca.ted.v.bean.mian.HomeMoney;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;
import com.veeca.ted.v.view.tasklist.TasklistFragment;
import com.veeca.ted.v.view.video.VideoFragment;
import com.veeca.ted.v.widget.CountNumberView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HomeFragment extends MVPBaseFragment<HomeContract.View, HomePresenter> implements HomeContract.View {

/*
    @BindView(R.id.home_circle_recycler)
    RecyclerView homeCircleRecycler;*/
    @BindView(R.id.home_tabLayout)
    TabLayout homeTabLayout;
    @BindView(R.id.home_viewpager)
    ViewPager homeViewpager;
    Unbinder unbinder;
    @BindView(R.id.home_top_money)
    CountNumberView homeTopMoney;
    @BindView(R.id.friends_share_count)
    TextView tvFriendCount;
    private Context context;
    private CountDownTimer timer;
    private AllCircleAdapter allCircleAdapter;
    private LinearLayoutManager layoutManager;
    private Intent intent;
    private MVPBaseFragment task_list_one, task_list_two;
    private List<MVPBaseFragment> fragments;
    private List<String> stringList;
    private MyFragmentAdapater myFragmentAdapater;

    private int hasGetFriend ;
    private int noGetFriend ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();

        LogUtils.e(Constant.getUserId() + ":" + Constant.getToken());
        initData();
        return view;
    }

    private void initData() {
        tvFriendCount.setText(""+(hasGetFriend+noGetFriend));
        task_list_one = new TasklistFragment();
        task_list_two = new VideoFragment();
        fragments = new ArrayList<>();
        fragments.add(task_list_one);
        fragments.add(task_list_two);
        stringList = new ArrayList<>();
        stringList.add("转发分红");
        stringList.add("销售分红");
        homeTabLayout.setupWithViewPager(homeViewpager);
        homeTabLayout.setTabMode(TabLayout.MODE_FIXED);
        myFragmentAdapater = new MyFragmentAdapater(this.getChildFragmentManager(), stringList);
        myFragmentAdapater.setFragments(fragments);
        homeViewpager.setAdapter(myFragmentAdapater);
        mPresenter.getAllCircle();
        mPresenter.getFriendCounts();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 上部金额跳动
     *
     * @author TED
     * created at 2017/11/16 16:39
     */
    private void autoMoney() {
        timer = new CountDownTimer(1000000, 10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mPresenter.getMoney();
            }

            @Override
            public void onFinish() {
                //计时完成调用
            }
        };
        timer.start();

    }

    @Override
    public void onResume() {
        //这是 Fragment 从创建到显示的最后一个回调的方法
        super.onResume();
        autoMoney();
    }

    @Override
    public void onPause() {
        //当发生界面跳转时，临时暂停，暂停时间是 500ms,0.5s后直接进入下面的 onStop 方法
        super.onPause();
        timer.cancel();
    }

    /*@OnClick(R.id.home_all_circle)
    public void onViewClicked() {
        intent = new Intent(context, AllcircleActivity.class);
        startActivity(intent);
    }*/

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }

    @Override
    public void showAllCircle(AllCircle allCircle) {
      /*  allCircleAdapter = new AllCircleAdapter(context);
        layoutManager = new GridLayoutManager(context, allCircle.getData().size(), LinearLayoutManager.VERTICAL, false);
        homeCircleRecycler.setLayoutManager(layoutManager);
        allCircleAdapter.clear();
        allCircleAdapter.setArrayList(allCircle.getData());
        homeCircleRecycler.setAdapter(allCircleAdapter);
        allCircleAdapter.setOnItemClickListener(new AllCircleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, AllCircle.DataBean dataBean) {
                intent = new Intent(context, CircleDetailsActivity.class);
                intent.putExtra("title", dataBean.getSctitle());
                intent.putExtra("scId", dataBean.getScid());
                startActivity(intent);
            }
        });*/
    }

    public void showFriendCounts(FriendCount friendCount){
         hasGetFriend = friendCount.getCount1();
         noGetFriend = friendCount.getCount2();
        int allGetFriend = friendCount.getCount();

    }

    @Override
    public void showMoney(HomeMoney homeMoney) {
        homeTopMoney.showNumberWithAnimation(homeMoney.getMoney(), CountNumberView.FLOATREGEX, "3000");
    }
}
