package com.veeca.ted.v.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagsAdapter;
import com.veeca.ted.v.R;

import java.util.List;

/**
 * Created by Ted on 2017/7/22.
 */

public class TagAdapter extends TagsAdapter {

    List<String> list;

    public TagAdapter(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(Context context, int position, ViewGroup parent) {
        TextView tv_tag = (TextView) View.inflate(context, R.layout.item_tag,null);
        tv_tag.setText(getItem(position));
        return tv_tag;
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return position%7;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {
        ((TextView)view).setTextColor(themeColor);
    }
}
