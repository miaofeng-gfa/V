package com.veeca.ted.v.view.allcircle;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.AllCircleAdapter;
import com.veeca.ted.v.bean.mian.AllCircle;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.circledetails.CircleDetailsActivity;
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

public class AllcircleActivity extends MVPBaseActivity<AllcircleContract.View, AllcirclePresenter> implements AllcircleContract.View {

    @BindView(R.id.circle_recycler)
    RecyclerView circleRecycler;
    private Context context;
    private List<AllCircle.DataBean> dataBeans = new ArrayList<>();
    private AllCircleAdapter circleAdapter;
    private LinearLayoutManager layoutManager;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_circle);
        ButterKnife.bind(this);
        context = getContext();
        LoadUtil.showLoad(this);
        initData();
        mPresenter.getAllCircle();
    }

    private void initData() {
        circleAdapter = new AllCircleAdapter(context);
        layoutManager = new GridLayoutManager(context, 4, LinearLayoutManager.VERTICAL, false);
        circleRecycler.setLayoutManager(layoutManager);
        circleRecycler.setHasFixedSize(true);
        circleAdapter.setArrayList(dataBeans);
        circleRecycler.setAdapter(circleAdapter);
        circleAdapter.setOnItemClickListener(new AllCircleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, AllCircle.DataBean dataBean) {
                if (dataBean.getScid() <= 30) {
                    intent = new Intent(context, CircleDetailsActivity.class);
                    intent.putExtra("title", dataBean.getSctitle());
                    intent.putExtra("scId", dataBean.getScid());
                    startActivity(intent);
                } else {
                    ToastUtils.setToast("暂未开通");
                }
            }
        });
    }

    @Override
    public void showAllCircle(AllCircle allCircle) {
        LoadUtil.hideLoad();
        dataBeans.addAll(allCircle.getData());
        circleAdapter.setArrayList(dataBeans);
        circleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        LoadUtil.hideLoad();
        ToastUtils.setToast("网络异常");
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        context = null;
        finish();
    }
}
