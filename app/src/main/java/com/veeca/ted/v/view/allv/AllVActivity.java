package com.veeca.ted.v.view.allv;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.AllVAdapter;
import com.veeca.ted.v.bean.TaskV;
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

public class AllVActivity extends MVPBaseActivity<AllVContract.View, AllVPresenter> implements AllVContract.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private Context context;
    private AllVAdapter vAdapter;
    private List<TaskV.XiaovShareListBean> listBeans = new ArrayList<>();
    private int page = 0, hid;
    private Intent intent;
    private LinearLayoutManager layoutManager;
    private int lastVisibleItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_v);
        ButterKnife.bind(this);
        context = getContext();
        intent = getIntent();
        hid = intent.getIntExtra("hid", 0);
        vAdapter = new AllVAdapter(context);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        flowRecycler.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));//设置分割线
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(layoutManager);
        vAdapter.setListBeans(listBeans);
        recycler.setAdapter(vAdapter);
        mPresenter.getTaskAllV(hid, page);
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 0：当前屏幕停止滚动；1时：屏幕在滚动 且 用户仍在触碰或手指还在屏幕上；2时：随用户的操作，屏幕上产生的惯性滑动；
                // 滑动状态停止并且剩余两个item时自动加载
                if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_DRAGGING)
                    if (lastVisibleItem + 2 >= layoutManager.getItemCount()) {
                        page++;
                        mPresenter.getTaskAllV(hid, page);
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
    public void showAll(TaskV taskV) {
        listBeans.addAll(taskV.getXiaovShareList());
        vAdapter.setListBeans(listBeans);
        vAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }
}
