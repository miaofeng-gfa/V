package com.veeca.ted.v.view.income;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.FriendMoney;
import com.veeca.ted.v.bean.RewardMoney;
import com.veeca.ted.v.bean.SumMoney;
import com.veeca.ted.v.bean.Syt;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.mian.Buy;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.buy.BuyActivity;
import com.veeca.ted.v.view.getcash.GetCashActivity;
import com.veeca.ted.v.view.incomedetails.IncomeDetailsActivity;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;
import com.veeca.ted.v.view.mymoney.MyMoneyActivity;
import com.veeca.ted.v.view.myprofit.MyProfitActivity;
import com.veeca.ted.v.view.recharge.RechargeActivity;
import com.veeca.ted.v.widget.CountNumberView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class IncomeFragment extends MVPBaseFragment<IncomeContract.View, IncomePresenter> implements IncomeContract.View {


    Unbinder unbinder;
    @BindView(R.id.income_top)
    CountNumberView incomeTop;
    @BindView(R.id.income_money)
    TextView incomeMoney;
    @BindView(R.id.income_profit)
    TextView incomeProfit;
    @BindView(R.id.income_buy)
    TextView incomeBuy;
    @BindView(R.id.income_keyong)
    TextView incomeKeyong;
    @BindView(R.id.btn_week)
    Button btnWeek;
    @BindView(R.id.btn_month)
    Button btnMonth;
    @BindView(R.id.webView)
    WebView webView;
    private Context context;
    private String xName_week, data1_week, data2_week;
    private String xName_month, data1_month, data2_month;
    private String xName, data1, data2;
    private Intent intent;
    private WebSettings webSettings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income, null);
        context = getActivity();
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
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
        mPresenter.getBuy();
        mPresenter.getSyt7();
        mPresenter.getSyt30();
        mPresenter.getMoney();
        mPresenter.getProfit();
        mPresenter.getSumMoney();
        mPresenter.getUsableMoney();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.income_details, R.id.income_1, R.id.income_2, R.id.income_3, R.id.income_extract, R.id.income_recharge, R.id.btn_week, R.id.btn_month})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.income_details:
                intent = new Intent(context, IncomeDetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.income_1:
                intent = new Intent(context, MyMoneyActivity.class);
                startActivity(intent);
                break;
            case R.id.income_2:
                intent = new Intent(context, MyProfitActivity.class);
                startActivity(intent);
                break;
            case R.id.income_3:
                intent = new Intent(context, BuyActivity.class);
                startActivity(intent);
                break;
            case R.id.income_extract:
                intent = new Intent(context, GetCashActivity.class);
                startActivity(intent);
                break;
            case R.id.income_recharge:
                intent = new Intent(context, RechargeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_week:
                btnWeek.setTextColor(getResources().getColor(R.color.font_fa));
                btnMonth.setTextColor(getResources().getColor(R.color.font_gray_9));
                xName = xName_week;
                data1 = data1_week;
                data2 = data2_week;
                webView.loadUrl("javascript:setEcharts()");
                break;
            case R.id.btn_month:
                btnMonth.setTextColor(getResources().getColor(R.color.font_fa));
                btnWeek.setTextColor(getResources().getColor(R.color.font_gray_9));
                xName = xName_month;
                data1 = data1_month;
                data2 = data2_month;
                webView.loadUrl("javascript:setEcharts()");
                break;
        }
    }

    @Override
    public void showMoney(RewardMoney money) {
        incomeMoney.setText("¥" + money.getRewardMoney() + "");
    }

    @Override
    public void showProfit(FriendMoney money) {
        incomeProfit.setText("¥" + money.getFriendMoney() + "");
    }

    @Override
    public void showBuy(Buy buy) {
        incomeBuy.setText("¥" + buy.getData() + "");
    }

    @Override
    public void showSumMoney(SumMoney sumMoney) {
        incomeTop.showNumberWithAnimation(sumMoney.getSumMoney(), CountNumberView.FLOATREGEX, "3000");
    }

    @Override
    public void showUsableMoney(UsableMoney usableMoney) {
        incomeKeyong.setText(usableMoney.getUsableMoney() + "");
    }

    @Override
    public void showSyt7(Syt syt) {
        for (int i = 0; i < syt.getDatafriend().size(); i++) {
            if (i == syt.getDatafriend().size() - 1) {
                data1_week = data1_week + syt.getDatafriend().get(i).getS();
                data2_week = data2_week + syt.getData().get(i).getS();
                xName_week = xName_week + syt.getDatafriend().get(i).getD().substring(3);
            } else if (i == 0) {
                data1_week = syt.getDatafriend().get(i).getS() + ",";
                data2_week = syt.getData().get(i).getS() + ",";
                xName_week = syt.getDatafriend().get(i).getD().substring(3) + ",";
            } else {
                data1_week = data1_week + syt.getDatafriend().get(i).getS() + ",";
                data2_week = data2_week + syt.getData().get(i).getS() + ",";
                xName_week = xName_week + syt.getDatafriend().get(i).getD().substring(3) + ",";
            }
        }
        xName = xName_week;
        data1 = data1_week;
        data2 = data2_week;
//        webView.loadUrl("javascript:setEcharts()");
    }

    @Override
    public void showSyt30(Syt syt) {
        for (int i = 0; i < syt.getDatafriend().size(); i++) {
            if (i == syt.getDatafriend().size() - 1) {
                data1_month = data1_month + syt.getDatafriend().get(i).getS();
                data2_month = data2_month + syt.getData().get(i).getS();
                xName_month = xName_month + syt.getDatafriend().get(i).getD().substring(3);
            } else if (i == 0) {
                data1_month = syt.getDatafriend().get(i).getS() + ",";
                data2_month = syt.getData().get(i).getS() + ",";
                xName_month = syt.getDatafriend().get(i).getD().substring(3) + ",";
            } else {
                data1_month = data1_month + syt.getDatafriend().get(i).getS() + ",";
                data2_month = data2_month + syt.getData().get(i).getS() + ",";
                xName_month = xName_month + syt.getDatafriend().get(i).getD().substring(3) + ",";
            }
        }
    }

    @Override
    public void onResume() {
        //这是 Fragment 从创建到显示的最后一个回调的方法
        super.onResume();
        mPresenter.getUsableMoney();
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }
}
