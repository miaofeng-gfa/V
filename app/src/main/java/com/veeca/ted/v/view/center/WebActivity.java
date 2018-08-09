package com.veeca.ted.v.view.center;

import android.os.Bundle;
import android.webkit.WebView;

import com.veeca.ted.v.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends AutoLayoutActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        //激活JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://api.xiaovka.com/staticView/inviteFriendStaticAndroid.jsp");
    }
}
