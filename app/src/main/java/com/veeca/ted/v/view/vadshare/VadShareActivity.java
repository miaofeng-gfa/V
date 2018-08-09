package com.veeca.ted.v.view.vadshare;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.MyFragmentAdapater;
import com.veeca.ted.v.bean.FriMoneyThir;
import com.veeca.ted.v.bean.FriendMoney;
import com.veeca.ted.v.bean.mian.FriendCount;
import com.veeca.ted.v.myclass.SelectDialog;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;
import com.veeca.ted.v.view.noregisterfriend.NoRegisterFriendFragment;
import com.veeca.ted.v.view.registerfriend.RegisterFriendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VadShareActivity extends MVPBaseActivity<VadShareContract.View,VadSharePresenter> implements VadShareContract.View {

    private Context context;
    private Intent intent;
    private SelectDialog dialog_approve;
    @BindView(R.id.tv_vadshare_rules)
    TextView tvVadRules;
    @BindView(R.id.tv_vadshare_count)
    TextView tvVadshareCount;
    @BindView(R.id.tv_vadshare_money)
    TextView tvVadshareMoney;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.vadshare_tabLayout)
    TabLayout vadshareTabLayout;
    @BindView(R.id.vadshare_viewpager)
    ViewPager vadshareViewpager;

    private WebSettings webSettings;
    private String xName, data1, data2;
    private List<String> stringList;
    private int hasGetFriend;
    private  int noGetFriend;
    private MVPBaseFragment task_list_one, task_list_two;
    private List<MVPBaseFragment> fragments;
    private MyFragmentAdapater myFragmentAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vad_share);
        ButterKnife.bind(this);
        context = getContext();
        mPresenter.getFriendCounts();
        mPresenter.getProfit();
        mPresenter.getFriendMoney30();
        initData();

    }

    private void initData() {
        webView.loadUrl("file:///android_asset/echarts.html");
        webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JsInteration(), "android");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView.loadUrl("javascript:setEcharts()");



        task_list_one = new NoRegisterFriendFragment();
        task_list_two = new RegisterFriendFragment();
        fragments = new ArrayList<>();
        fragments.add(task_list_one);
        fragments.add(task_list_two);

        stringList = new ArrayList<>();
        stringList.add("未认领"+noGetFriend+"人");
        stringList.add("已认领"+hasGetFriend+"人");
        vadshareTabLayout.setupWithViewPager(vadshareViewpager);
        vadshareTabLayout.setTabMode(TabLayout.MODE_FIXED);
        myFragmentAdapater = new MyFragmentAdapater(this.getSupportFragmentManager(), stringList);
        myFragmentAdapater.setFragments(fragments);
        vadshareViewpager.setAdapter(myFragmentAdapater);
    }

    //Android调用有返回值js方法
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void onClick(View v) {

    }

    public class JsInteration {

        @JavascriptInterface
        public String xName() {
            return xName;
        }

        @JavascriptInterface
        public String data1() {
            return data2;
        }

        @JavascriptInterface
        public String data2() {
            return data1;
        }
    }

    @OnClick(R.id.iv_top_return)
    public void onViewClicked() {
        finish();
    }
    @OnClick(R.id.tv_vadshare_rules)
    public void onRulesClicked() {
        approveDialog();
    }

    private void approveDialog() {
        dialog_approve = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.vadshare_pop, null);
        viewDialog.findViewById(R.id.rl_vadshare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_approve.dismiss();
            }
        });

        Display display = this.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_approve.setContentView(viewDialog, layoutParams);
        dialog_approve.show();
    }

    public void showFriendCounts(FriendCount friendCount){

        hasGetFriend = friendCount.getCount1();
        noGetFriend = friendCount.getCount2();
        tvVadshareCount.setText(""+(hasGetFriend+noGetFriend));
    }
    public void showProfit(FriendMoney money){

        tvVadshareMoney.setText(""+money.getFriendMoney());

    }
    public void showFriendMoney30(FriMoneyThir fmt){

        LogUtils.e("yyyy==="+fmt.toString());

        for (int i = 0; i < fmt.getData().size(); i++) {
            if (i == fmt.getData().size() - 1) {
                data1 = data1 + fmt.getData().get(i).getNum();
                data2 = data2+fmt.getData().get(i).getNum();
                xName = xName + (""+fmt.getData().get(i).getD()).substring(3);
            } else if (i == 0) {
                data1 = fmt.getData().get(i).getNum() + ",";
                data2 = fmt.getData().get(i).getNum() + ",";
                xName = (""+fmt.getData().get(i).getD()).substring(3) + ",";

            } else {
                data1 = fmt.getData().get(i).getNum() + ",";
                data2 = data2 + fmt.getData().get(i).getNum() + ",";
                xName = xName + (""+fmt.getData().get(i).getD()).substring(3) + ",";
            }
        }


    }

   /* public void  showRegisterFriend(RegisterFriend registerFriend){

        LogUtils.e("tttttttttt==="+registerFriend.toString());

    }*/

    /*public void  showNotRegisterFriend(NoRegisterFriend noRegisterFriend){
        LogUtils.e("jjjjjjjjjjjj==="+noRegisterFriend.toString());
    }*/


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
