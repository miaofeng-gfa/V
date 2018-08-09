package com.veeca.ted.v.view.mymoney;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.MyMoneyAdapter;
import com.veeca.ted.v.bean.Tasking;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyMoneyActivity extends MVPBaseActivity<MyMoneyContract.View, MyMoneyPresenter> implements MyMoneyContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.ll_not)
    LinearLayout llNot;
    private LinearLayoutManager layoutManager;
    private Context context;
    private MyMoneyAdapter moneyAdapter;
    private List<Tasking.DataBean> list = new ArrayList<>();
    private Activity mActivity;
    private int lastVisibleItem;
    private int page, type;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_money);
        ButterKnife.bind(this);
        context = getContext();
        mActivity = this;
        LoadUtil.showLoad(mActivity);
        title.setText("好友赏金");
        tabLayout.addTab(tabLayout.newTab().setText("审核中"));
        tabLayout.addTab(tabLayout.newTab().setText("已完成"));
        page = 0;
        type = 3;
        moneyAdapter = new MyMoneyAdapter(context);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));//设置分割线
        recycler.setLayoutManager(layoutManager);
        moneyAdapter.setDataBeans(list);
        recycler.setAdapter(moneyAdapter);
        mPresenter.getTasking(type, page);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LoadUtil.showLoad(mActivity);
                if (tab.getPosition() == 0) {
                    type = 3;
                    page = 0;
                } else {
                    type = 1;
                    page = 0;
                }
                list.clear();
                moneyAdapter.clear();
                mPresenter.getTasking(type, page);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 0：当前屏幕停止滚动；1时：屏幕在滚动 且 用户仍在触碰或手指还在屏幕上；2时：随用户的操作，屏幕上产生的惯性滑动；
                // 滑动状态停止并且剩余两个item时自动加载
                if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_DRAGGING)
                    if (lastVisibleItem + 2 >= layoutManager.getItemCount()) {
                        page++;
                        mPresenter.getTasking(type, page);
                    }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 获取加载的最后一个可见视图在适配器的位置。
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }

        });
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showError() {
        LoadUtil.hideLoad();
        if (page == 0) llNot.setVisibility(View.VISIBLE);
        else {
            page--;
            ToastUtils.setToast("没有更多数据了");
        }
    }

    @Override
    public void showTasking(Tasking tasking) {
        LoadUtil.hideLoad();
        llNot.setVisibility(View.GONE);
        list.addAll(tasking.getData());
        moneyAdapter.setDataBeans(list);
        moneyAdapter.notifyDataSetChanged();
    }
}
