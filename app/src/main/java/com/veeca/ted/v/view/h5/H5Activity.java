package com.veeca.ted.v.view.h5;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class H5Activity extends MVPBaseActivity<H5Contract.View, H5Presenter> implements H5Contract.View {

    @BindView(R.id.webView)
    WebView webView;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);
        ButterKnife.bind(this);
        intent = getIntent();
        //激活JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(intent.getStringExtra("url"));
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }
}
