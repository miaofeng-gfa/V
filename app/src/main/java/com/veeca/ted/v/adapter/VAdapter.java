package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.VLists;
import com.veeca.ted.v.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/11/6.
 */

public class VAdapter extends RecyclerView.Adapter<VAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<VLists.DataBean> dataBeans = new ArrayList<>();

    public void clear() {
        dataBeans.clear();
    }

    public VAdapter(Context context) {
        this.context = context;
    }

    public void setDataBeans(List<VLists.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_v, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        VLists.DataBean dataBean = dataBeans.get(position);
        holder.itemView.setTag(dataBean);
        Glide.with(context).load(dataBean.getHeadImgUrl()).into(holder.vAvatar);
        holder.vName.setText(dataBean.getName());
        holder.vTitle.setText(dataBean.getPosition());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.v_avatar)
        CircleImageView vAvatar;
        @BindView(R.id.v_name)
        TextView vName;
        @BindView(R.id.v_title)
        TextView vTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取position
        mOnItemClickListener.onItemClick(v, (VLists.DataBean) v.getTag());
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, VLists.DataBean dataBean);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
