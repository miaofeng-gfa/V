package com.veeca.ted.v.view.vinfo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.BindAdapter;
import com.veeca.ted.v.adapter.MyPagerAdapter;
import com.veeca.ted.v.adapter.TagAdapter;
import com.veeca.ted.v.bean.UserV;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.widget.CircleImageView;
import com.veeca.ted.v.widget.CountNumberView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VInfoActivity extends MVPBaseActivity<VInfoContract.View, VInfoPresenter> implements VInfoContract.View {

    @BindView(R.id.user_avatar)
    CircleImageView userAvatar;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_sex)
    ImageView userSex;
    @BindView(R.id.user_age)
    TextView userAge;
    @BindView(R.id.user_loc)
    TextView userLoc;
    @BindView(R.id.user_money)
    CountNumberView userMoney;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.pager_view)
    ViewPager pagerView;
    @BindView(R.id.mScrollView)
    ScrollView mScrollView;
    private Context context;
    private Intent intent;
    private int uid, state;
    private TagCloudView tagCloud;
    private View view1, view2, view3;
    private ArrayList<View> viewList;//view数组
    private List<String> tag_list = new ArrayList<>();
    private TagAdapter tagAdapter;
    private WebView webViewLike, webViewCircle;
    private MyPagerAdapter myPagerAdapter;
    private BindAdapter bindAdapter;
    private LinearLayoutManager layoutManager;
    private String[] tab_title = {"标签", "兴趣", "圈子"};
    private String name_circle, data_circle, name_like, data_like;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_info);
        ButterKnife.bind(this);
        context = getContext();
        LoadUtil.showLoad(this);
        initView();
        initData();
        initListener();
        intent = getIntent();
        uid = intent.getIntExtra("uid", 0);
        state = intent.getIntExtra("state", 0);
        mPresenter.getUserV(uid);
    }

    private void initView() {
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout_tag, null);
        view2 = inflater.inflate(R.layout.layout_pie, null);
        view3 = inflater.inflate(R.layout.layout_pie, null);
        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        myPagerAdapter = new MyPagerAdapter(viewList);
        pagerView.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(pagerView);
        tabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(tab_title[i]);
        }
        tagCloud = ButterKnife.findById(view1, R.id.tagCloud);
        webViewLike = ButterKnife.findById(view2, R.id.webView);
        webViewCircle = ButterKnife.findById(view3, R.id.webView);
    }

    private void initData() {
        tagAdapter = new TagAdapter(tag_list);
        tagCloud.setAdapter(tagAdapter);
        bindAdapter = new BindAdapter(context);
    }

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showUserV(UserV userV) {
        LoadUtil.hideLoad();
        Glide.with(context).load(userV.getData().getHeadimgurl()).into(userAvatar);
        userName.setText(userV.getData().getNickname());
        userAge.setText(userV.getData().getAge() + "岁");
        userLoc.setText(userV.getData().getProvince());
        if (userV.getData().getSex() == 1) {
            Glide.with(context).load(R.mipmap.man).into(userSex);
        } else {
            Glide.with(context).load(R.mipmap.woman).into(userSex);
        }
        userMoney.showNumberWithAnimation(userV.getData().getSumEarn(), CountNumberView.FLOATREGEX, "99999999");
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));//设置分割线
        recycler.setLayoutManager(layoutManager);
        bindAdapter.setListBeans(userV.getData().getThirdList());
        recycler.setAdapter(bindAdapter);
        for (int i = 0; i < userV.getData().getTagList().size(); i++) {
            tag_list.add(userV.getData().getTagList().get(i).getTag());
        }
        tagAdapter.notifyDataSetChanged();
        name_circle = name_like = data_circle = data_like = "";
        for (int i = 0; i < userV.getData().getLabelList().size(); i++) {
            name_like = name_like + userV.getData().getLabelList().get(i).getLabelName() + ",";
            name_circle = name_circle + userV.getData().getCircleList().get(i).getCircleName() + ",";
            data_circle = data_circle + userV.getData().getCircleList().get(i).getCweight() + ",";
            data_like = data_like + userV.getData().getLabelList().get(i).getLweight() + ",";
        }
        name_like = name_like.substring(0, name_like.length() - 1);
        name_circle = name_circle.substring(0, name_circle.length() - 1);
        data_like = data_like.substring(0, data_like.length() - 1);
        data_circle = data_circle.substring(0, data_circle.length() - 1);
        initWeb();
    }

    private void initWeb() {
        webViewLike.loadUrl("file:///android_asset/echarts_pie.html");
        WebSettings webSettingsLike = webViewLike.getSettings();
        webSettingsLike.setUseWideViewPort(true);
        webSettingsLike.setLoadWithOverviewMode(true);
        webSettingsLike.setJavaScriptEnabled(true);
        webViewLike.addJavascriptInterface(new JsLike(), "android");
        webViewLike.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webViewCircle.loadUrl("file:///android_asset/echarts_pie.html");
        WebSettings webSettingsCircle = webViewCircle.getSettings();
        webSettingsCircle.setUseWideViewPort(true);
        webSettingsCircle.setLoadWithOverviewMode(true);
        webSettingsCircle.setJavaScriptEnabled(true);
        webViewCircle.addJavascriptInterface(new JsCircle(), "android");
        webViewCircle.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }

    public class JsLike {

        @JavascriptInterface
        public String getTitle() {
            return "兴趣";
        }

        @JavascriptInterface
        public String getData() {
            return data_like;
        }

        @JavascriptInterface
        public String getName() {
            return name_like;
        }
    }

    public class JsCircle {

        @JavascriptInterface
        public String getTitle() {
            return "圈子";
        }

        @JavascriptInterface
        public String getData() {
            return data_circle;
        }

        @JavascriptInterface
        public String getName() {
            return name_circle;
        }
    }

    private void initListener() {
        //tagcloud
        tagCloud.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    //允许ScrollView截断点击事件，ScrollView可滑动
                    mScrollView.requestDisallowInterceptTouchEvent(false);
                } else {
                    //不允许ScrollView截断点击事件，点击事件由子View处理
                    mScrollView.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        tagCloud.setOnTagClickListener(new TagCloudView.OnTagClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, int position) {
                ToastUtils.setToast(tag_list.get(position));
            }
        });
    }
}
