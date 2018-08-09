package com.veeca.ted.v.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.veeca.ted.v.view.mvp.MVPBaseFragment;

import java.util.List;

/**
 * 碎片适配器
 * Created  on 2016/7/7.
 */
public class MyFragmentAdapater extends FragmentPagerAdapter {

    public void setFragments(List<MVPBaseFragment> fragments) {
        this.fragments = fragments;
    }

    private List<String> list;

    // 碎片集合
    private List<MVPBaseFragment> fragments;

    /**
     * 构造器
     *
     * @param fm 碎片管理者对象
     */
    public MyFragmentAdapater(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);// 返回当前碎片元素
    }

    @Override
    public int getCount() {
        return fragments.size();// 返回集合大小
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
