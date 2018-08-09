package com.veeca.ted.v.view.hello;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.veeca.ted.v.R;
import com.veeca.ted.v.view.login.LoginActivity;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import xu.viewpagerflextitle.MyPagerAdapter;

public class Hello2Activity extends AutoLayoutActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @SuppressLint("WrongViewCast")
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    private ArrayList<View> viewList;//view数组
    private MyPagerAdapter mAdapter;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ButterKnife.bind(this);
        LayoutInflater inflater = getLayoutInflater();
        mActivity = this;
        viewList = new ArrayList();// 将要分页显示的View装入数组中
        viewList.add(inflater.inflate(R.layout.layout_hello, null));
        viewList.add(inflater.inflate(R.layout.layout_hello, null));
        viewList.add(inflater.inflate(R.layout.layout_hello, null));
        viewList.add(inflater.inflate(R.layout.layout_hello, null));


        mAdapter = new MyPagerAdapter(viewList);
        viewpager.setAdapter(mAdapter);
        indicator.setViewPager(viewpager);
        viewpager.setCurrentItem(0);
        viewList.get(0).findViewById(R.id.hello_bg).setBackgroundResource(R.mipmap.hello1);
        viewList.get(1).findViewById(R.id.hello_bg).setBackgroundResource(R.mipmap.hello2);
        viewList.get(2).findViewById(R.id.hello_bg).setBackgroundResource(R.mipmap.hello3);
        viewList.get(3).findViewById(R.id.hello_bg).setBackgroundResource(R.mipmap.hello4);

        viewList.get(3).findViewById(R.id.btn_start).setVisibility(View.VISIBLE);
        viewList.get(3).findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mActivity, MainActivity.class);
                Intent intent = new Intent(mActivity, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
