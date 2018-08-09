package com.veeca.ted.v.view.gold;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.mian.Gold;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class GoldActivity extends MVPBaseActivity<GoldContract.View, GoldPresenter> implements GoldContract.View {

    @BindView(R.id.gold_money)
    TextView goldMoney;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold);
        ButterKnife.bind(this);
        context = getContext();
        mPresenter.getGold();
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showGold(Gold gold) {
        goldMoney.setText(gold.getData());
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }
}
