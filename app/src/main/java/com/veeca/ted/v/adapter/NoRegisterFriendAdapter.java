package com.veeca.ted.v.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.NoRegisterFriend;
import com.veeca.ted.v.view.invite.InviteActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/11/20.
 */

public class NoRegisterFriendAdapter extends RecyclerView.Adapter<NoRegisterFriendAdapter.ViewHolder> {
    private Context context;
    private List<NoRegisterFriend.DataBean> noRegisterFriendLists = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("0.00");
    private String cpc;
    private Intent intent;
    private  String qrcode;

    //记录之前播放的条目下标
    public int currentPosition = -1;
    public NoRegisterFriendAdapter(Context context) {
        this.context = context;
    }

    public void setTaskLists(List taskLists) {
        this.noRegisterFriendLists = taskLists;
    }

    public void  setQrcode(String qrcode){
        this.qrcode = qrcode;
    }

    public void clear() {
        noRegisterFriendLists.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noregisterfriend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final NoRegisterFriend.DataBean dataBean = noRegisterFriendLists.get(position);



        Glide.with(context)
                .load(dataBean.getHeadimgurl())
                .asBitmap()
                .centerCrop().
                into(new BitmapImageViewTarget(holder.ivRegFriPic) {
                @Override
                protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);

                circularBitmapDrawable.setCircular(true);
                holder.ivRegFriPic.setImageDrawable(circularBitmapDrawable);
            }
        });
//                .into(holder.ivRegFriPic);
        holder.tvRegFriName.setText(dataBean.getNickname());
        holder.tvRegFriDay.setText(""+dataBean.getClicktm()+"天");




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, InviteActivity.class);
                intent.putExtra("qrcode", qrcode);
                context.startActivity(intent);
            }
        });

    }
    public void setPlayPosition(int position) {
        currentPosition = position;
    }

    @Override
    public int getItemCount() {
        return noRegisterFriendLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_regfir_pic)
        ImageView ivRegFriPic;
        @BindView(R.id.tv_regfir_name)
        TextView tvRegFriName;
        @BindView(R.id.tv_regfir_count)
        TextView tvRegFriCount;
        @BindView(R.id.tv_regfir_day)
        TextView tvRegFriDay;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
