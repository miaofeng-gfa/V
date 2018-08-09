package com.veeca.ted.v.view.more;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoreActivity extends MVPBaseActivity<MoreContract.View, MorePresenter> implements MoreContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.ll_not)
    LinearLayout llNot;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);
        title.setText("消息");
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }
}
