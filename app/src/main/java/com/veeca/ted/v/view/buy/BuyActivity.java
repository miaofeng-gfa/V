package com.veeca.ted.v.view.buy;


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
import com.veeca.ted.v.adapter.BuyAdapter;
import com.veeca.ted.v.adapter.SeeAdapter;
import com.veeca.ted.v.bean.VideoBuy;
import com.veeca.ted.v.bean.VideoSee;
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

public class BuyActivity extends MVPBaseActivity<BuyContract.View, BuyPresenter> implements BuyContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.ll_not)
    LinearLayout llNot;
    private Context context;
    private BuyAdapter buyAdapter;
    private SeeAdapter seeAdapter;
    private LinearLayoutManager layoutManager;
    private List<VideoBuy.DataBean> buyLists = new ArrayList<>();
    private List<VideoSee.DataBean> seeLists = new ArrayList<>();
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
        title.setText("销售分红");
        tabLayout.addTab(tabLayout.newTab().setText("谁买了"));
        tabLayout.addTab(tabLayout.newTab().setText("谁看了"));
        type = page = 0;
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));//设置分割线
        recycler.setLayoutManager(layoutManager);
        seeAdapter = new SeeAdapter(context);
        buyAdapter = new BuyAdapter(context);
        seeAdapter.setSeeLists(seeLists);
        buyAdapter.setBuyLists(buyLists);
        recycler.setAdapter(buyAdapter);
        mPresenter.getVideoBuy(page);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                type = tab.getPosition();
                page = 0;
                if (type == 0) {
                    recycler.setAdapter(buyAdapter);
                    mPresenter.getVideoBuy(page);
                } else {
                    recycler.setAdapter(seeAdapter);
                    mPresenter.getVideoSee(page);
                }
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
                        if (type == 0) mPresenter.getVideoBuy(page);
                        else mPresenter.getVideoSee(page);
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
    public void showVideoSee(VideoSee videoSee) {
        if (page == 0 && videoSee.getData().size() == 0) {
            recycler.setVisibility(View.GONE);
            llNot.setVisibility(View.VISIBLE);
        }
        if (videoSee.isSuccess()) {
            seeLists.addAll(videoSee.getData());
            seeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showVideoBuy(VideoBuy videoBuy) {
        if (page == 0 && videoBuy.getData().size() == 0) {
            recycler.setVisibility(View.GONE);
            llNot.setVisibility(View.VISIBLE);
        }
        if (videoBuy.isSuccess()) {
            buyLists.addAll(videoBuy.getData());
            buyAdapter.notifyDataSetChanged();
        }
    }
}
