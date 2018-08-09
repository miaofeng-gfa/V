package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.CircleData;
import com.veeca.ted.v.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/8/9.
 */

public class PopularityAdapter extends RecyclerView.Adapter<PopularityAdapter.ViewHolder> implements View.OnClickListener {

    private List<CircleData.UserListBean> list = new ArrayList<>();

    private Context context;

    public PopularityAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<CircleData.UserListBean> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popularity, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CircleData.UserListBean dataBean = list.get(position);
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(dataBean.getId());
        Glide.with(context).load(dataBean.getHeadimgurl()).into(holder.popuAvatar);
        Glide.with(context).load(R.mipmap.red_v).into(holder.popuSex);
        holder.popuName.setText(dataBean.getNickname());
        String str1 = dataBean.getUtag();
        String[] str = str1.split("[|]");
        holder.popuTags1.setText("#" + str[0] + " #" + str[1] + " #" + str[2]);
        holder.popuTags2.setText("#" + str[3] + " #" + str[4]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取position
        mOnItemClickListener.onItemClick(v, (int) v.getTag());
    }


    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.popu_avatar)
        CircleImageView popuAvatar;
        @BindView(R.id.popu_sex)
        ImageView popuSex;
        @BindView(R.id.popu_name)
        TextView popuName;
        @BindView(R.id.popu_tags1)
        TextView popuTags1;
        @BindView(R.id.popu_tags2)
        TextView popuTags2;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, int id);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
