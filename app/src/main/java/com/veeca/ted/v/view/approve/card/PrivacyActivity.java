package com.veeca.ted.v.view.approve.card;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrivacyActivity extends AutoLayoutActivity {

    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        ButterKnife.bind(this);
        topTitle.setText("小V咖隐私政策");
        //激活JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://api.xiaovka.com/staticView/agreement.html");
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }
}
