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
import com.veeca.ted.v.bean.VideoSee;
import com.veeca.ted.v.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Ted on 2017/9/20.
 */

public class SeeAdapter extends RecyclerView.Adapter<SeeAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<VideoSee.DataBean> seeLists = new ArrayList<>();

    public void clear() {
        seeLists.clear();
    }

    public SeeAdapter(Context context) {
        this.context = context;
    }

    public void setSeeLists(List<VideoSee.DataBean> seeLists) {
        this.seeLists = seeLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buy_see, parent, false);
        //将创建的View注册点击事件
//        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        VideoSee.DataBean dataBean = seeLists.get(position);
//        holder.itemView.setTag(dataBean);
        Glide.with(context).load(dataBean.getProductImg()).bitmapTransform(new RoundedCornersTransformation(context, 8, 0,
                RoundedCornersTransformation.CornerType.ALL)).into(holder.image);
        Glide.with(context).load(dataBean.getHeadImg()).into(holder.userAvatar);
        holder.userName.setText(dataBean.getNickName() + " 查看了你分享的商品");
        holder.time.setText(dataBean.getUpdateTime());
    }

    @Override
    public int getItemCount() {
        return seeLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.user_avatar)
        CircleImageView userAvatar;
        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.time)
        TextView time;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //
    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取position
        mOnItemClickListener.onItemClick(v, (VideoSee.DataBean) v.getTag());
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, VideoSee.DataBean dataBean);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
