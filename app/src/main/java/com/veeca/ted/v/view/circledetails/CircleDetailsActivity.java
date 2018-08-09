package com.veeca.ted.v.view.circledetails;


import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.PopularityAdapter;
import com.veeca.ted.v.adapter.TagAdapter;
import com.veeca.ted.v.bean.CircleData;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.view.vinfo.VInfoActivity;
import com.veeca.ted.v.widget.SuperCircleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CircleDetailsActivity extends MVPBaseActivity<CircleDetailsContract.View, CircleDetailsPresenter> implements CircleDetailsContract.View {

    @BindView(R.id.user_view)
    RecyclerView userView;
    @BindViews({R.id.superview1, R.id.superview2, R.id.superview3, R.id.superview4})
    List<SuperCircleView> superviews;
    @BindViews({R.id.circle_tv_1, R.id.circle_tv_2, R.id.circle_tv_3, R.id.circle_tv_4})
    List<TextView> circle_tvs;
    @BindViews({R.id.cd_tv1, R.id.cd_tv2, R.id.cd_tv3, R.id.cd_tv4})
    List<TextView> textViews;
    @BindView(R.id.tagCloud)
    TagCloudView tagCloud;
    @BindView(R.id.mScrollView)
    ScrollView mScrollView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.circle_logo)
    ImageView circleLogo;
    private Context context;
    private Intent intent;
    private int scId;
    private TagAdapter tagAdapter;
    private List<String> tag_list = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private String colors[] = {"#FFFF6673", "#FFFF7244", "#FFFFA044", "#FFFFDD00"};
    private PopularityAdapter circleAdapter;
    private List<CircleData.UserListBean> userListBeans = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_details);
        ButterKnife.bind(this);
        context = getContext();
        intent = getIntent();
        scId = intent.getIntExtra("scId", 0);
        title.setText(intent.getStringExtra("title"));
        initData();
        initListener();
        mPresenter.getCircleData(scId);
    }

    /**
     * 初始化圆环数据
     */
    private void initSuperCircleView(int i, final SuperCircleView superCircleView, final TextView textView, String colors) {
        superCircleView.setShowSelect(false);
        superCircleView.setMColors(colors, colors, colors);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, i);
        valueAnimator.setTarget(textView);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int i = Integer.valueOf(String.valueOf(animation.getAnimatedValue()));
                textView.setText(i + "");
                superCircleView.setSelect((int) (360 * (i / 100f)));
            }
        });
        valueAnimator.start();
    }

    private void initData() {
        circleLogo.setFocusable(true);
        circleLogo.setFocusableInTouchMode(true);
        circleLogo.requestFocus();
        //tagcloud
        tagAdapter = new TagAdapter(tag_list);
        tagCloud.setAdapter(tagAdapter);
        circleAdapter = new PopularityAdapter(context);
        layoutManager = new GridLayoutManager(context, 10, LinearLayoutManager.VERTICAL, false);
//        user_view.addItemDecoration(new SpaceItemDecoration(16, 3));
        userView.setLayoutManager(layoutManager);
        circleAdapter.setList(userListBeans);
        userView.setAdapter(circleAdapter);
        //小V头像点击
        circleAdapter.setOnItemClickListener(new PopularityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int id) {
                //todo 小V头像点击
                intent = new Intent(context, VInfoActivity.class);
                intent.putExtra("uid", id);
                startActivity(intent);
            }
        });
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

    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showCircleData(CircleData circleData) {
        Glide.with(context).load(circleData.getCircleMap().getScbanner()).into(circleLogo);
        for (int i = 0; i < 4; i++) {
            circle_tvs.get(i).setText(circleData.getPerList().get(i).getLabelName());
            initSuperCircleView(circleData.getPerList().get(i).getPer(), superviews.get(i), textViews.get(i), colors[i]);
        }
        for (int i = 0; i < circleData.getTagList().size(); i++) {
            tag_list.add(circleData.getTagList().get(i).getTag());
        }
        tagAdapter.notifyDataSetChanged();
        userListBeans.addAll(circleData.getUserList());
        circleAdapter.setList(userListBeans);
        circleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }
}
