package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.mian.MyProfit;
import com.veeca.ted.v.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/9/20.
 */

public class MyProfitAdapter extends RecyclerView.Adapter<MyProfitAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<MyProfit.DataBean> dataBeans = new ArrayList<>();

    public void clear() {
        dataBeans.clear();
    }

    public MyProfitAdapter(Context context) {
        this.context = context;
    }

    public void setDataBeans(List<MyProfit.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profit, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MyProfit.DataBean dataBean = dataBeans.get(position);
        holder.itemView.setTag(dataBean);
        holder.proMoney.setText(dataBean.getOof() + "");
        Glide.with(context).load(dataBean.getXiaovUser().getHeadimgurl()).into(holder.proAvatar);
        holder.proTitle.setText("已赚赏金¥"+dataBean.getXiaovUser().getRes1());
        holder.proName.setText(dataBean.getXiaovUser().getNickname());

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pro_avatar)
        CircleImageView proAvatar;
        @BindView(R.id.pro_name)
        TextView proName;
        @BindView(R.id.pro_title)
        TextView proTitle;
        @BindView(R.id.pro_money)
        TextView proMoney;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //
    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取position
        mOnItemClickListener.onItemClick(v, (MyProfit.DataBean) v.getTag());
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, MyProfit.DataBean dataBean);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
