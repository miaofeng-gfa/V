package com.veeca.ted.v.view.myprofit;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.MyProfitAdapter;
import com.veeca.ted.v.bean.mian.MyProfit;
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

public class MyProfitActivity extends MVPBaseActivity<MyProfitContract.View, MyProfitPresenter> implements MyProfitContract.View {

    @BindView(R.id.my_profit_recycler)
    RecyclerView myProfitRecycler;
    @BindView(R.id.my_profit_swipe)
    SwipeRefreshLayout myProfitSwipe;
    @BindView(R.id.ll_not)
    LinearLayout llNot;
    private Context context;
    private int page = 0;
    private MyProfitAdapter profitAdapter;
    private List<MyProfit.DataBean> list = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private int lastVisibleItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profit);
        ButterKnife.bind(this);
        context = getContext();
        setListener();
        myProfitSwipe.setColorSchemeResources(R.color.yellow);
        myProfitSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
        profitAdapter = new MyProfitAdapter(context);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myProfitRecycler.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));//设置分割线
        myProfitRecycler.setLayoutManager(layoutManager);
        profitAdapter.setDataBeans(list);
        myProfitRecycler.setAdapter(profitAdapter);
        myProfitSwipe.setRefreshing(true);
        mPresenter.getMyProfitList(page);
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showMyProfitList(MyProfit profit) {
        myProfitSwipe.setRefreshing(false);
        if (profit.getData().size() != 0) {
            llNot.setVisibility(View.GONE);
            list.addAll(profit.getData());
            profitAdapter.setDataBeans(list);
            profitAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        myProfitSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                list.clear();
                profitAdapter.clear();
                mPresenter.getMyProfitList(page);
            }
        });

        myProfitRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 0：当前屏幕停止滚动；1时：屏幕在滚动 且 用户仍在触碰或手指还在屏幕上；2时：随用户的操作，屏幕上产生的惯性滑动；
                // 滑动状态停止并且剩余两个item时自动加载
                if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_DRAGGING)
                    if (lastVisibleItem + 2 >= layoutManager.getItemCount()) {
                        page++;
                        myProfitSwipe.setRefreshing(true);
                        mPresenter.getMyProfitList(page);
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

    @Override
    public void showError() {
        myProfitSwipe.setRefreshing(false);
    }
}
