package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.QunList;
import com.veeca.ted.v.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/11/6.
 */

public class QunVAdapter extends RecyclerView.Adapter<QunVAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<QunList.DataBean.MemberListBean> dataBeans = new ArrayList<>();

    public void clear() {
        dataBeans.clear();
    }

    public QunVAdapter(Context context) {
        this.context = context;
    }

    public void setDataBeans(List<QunList.DataBean.MemberListBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qun_v, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        QunList.DataBean.MemberListBean dataBean = dataBeans.get(position);
        holder.itemView.setTag(dataBean);
        Glide.with(context).load(dataBean.getHeadimgurl()).into(holder.qunAvatar);
        holder.qunName.setText(dataBean.getName());
        holder.qunTitle.setText(dataBean.getPosition());
        if (dataBean.getTypes() == 1)
            holder.qunTag.setVisibility(View.VISIBLE);
        else
            holder.qunTag.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.qun_avatar)
        CircleImageView qunAvatar;
        @BindView(R.id.qun_name)
        TextView qunName;
        @BindView(R.id.qun_tag)
        TextView qunTag;
        @BindView(R.id.qun_title)
        TextView qunTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取position
        mOnItemClickListener.onItemClick(v, (QunList.DataBean.MemberListBean) v.getTag());
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, QunList.DataBean.MemberListBean dataBean);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
