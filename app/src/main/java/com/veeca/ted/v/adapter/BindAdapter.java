package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.UserV;
import com.veeca.ted.v.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/9/20.
 */

public class BindAdapter extends RecyclerView.Adapter<BindAdapter.ViewHolder> {

    private Context context;
    private List<UserV.DataBean.ThirdListBean> listBeans = new ArrayList<>();

    public void clear() {
        listBeans.clear();
    }

    public void setListBeans(List<UserV.DataBean.ThirdListBean> listBeans) {
        this.listBeans = listBeans;
    }

    public BindAdapter(Context context) {
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bind, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        UserV.DataBean.ThirdListBean dataBean = listBeans.get(position);
        holder.name.setText(dataBean.getTcthirdname());
        if (dataBean.getTcthirdname().equals("微博")) {
            String str1 = dataBean.getTcname().substring(0, 1);
            String str2 = dataBean.getTcname().substring(dataBean.getTcname().length() - 1, dataBean.getTcname().length());
            holder.userName.setText(str1 + "****" + str2);
        } else {
            holder.userName.setText(dataBean.getTcname());
        }
        Glide.with(context).load(dataBean.getTcthirdimg()).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.logo)
        CircleImageView logo;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.user_name)
        TextView userName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
