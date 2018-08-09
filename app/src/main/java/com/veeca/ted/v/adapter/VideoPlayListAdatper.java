package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.VideoPlayerItemInfo;
import com.veeca.ted.v.widget.VideoPlayer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ============================================================
 * Copyright：JackChan和他的朋友们有限公司版权所有 (c) 2017
 * Author：   JackChan
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChan1999
 * GitBook：  https://www.gitbook.com/@alleniverson
 * CSDN博客： http://blog.csdn.net/axi295309066
 * 个人博客： https://jackchan1999.github.io/
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：VideoPlayer
 * Package_Name：com.jackchan.videoplayer
 * Version：1.0
 * time：2017/5/24 18:05
 * des ：adapter
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/24 18:05
 * updateDes：${TODO}
 * ============================================================
 */

public class VideoPlayListAdatper extends RecyclerView.Adapter {

    private Context context;
    private List<VideoPlayerItemInfo.DataBean> videoPlayerItemInfoList;

    //记录之前播放的条目下标
    public int currentPosition = -1;

    public VideoPlayListAdatper(Context context) {
        this.context = context;
    }

    public void setVideoPlayerItemInfoList(List<VideoPlayerItemInfo.DataBean> videoPlayerItemInfoList) {
        this.videoPlayerItemInfoList = videoPlayerItemInfoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ListViewHolder viewHolder = (ListViewHolder) holder;
        //获取到条目对应的数据
        final VideoPlayerItemInfo.DataBean info = videoPlayerItemInfoList.get(position);
        //传递给条目里面的MyVideoPlayer
        viewHolder.videoPlayer.setPlayData(info);
        //把条目的下标传递给MyVideoMediaController对象
        viewHolder.videoPlayer.mediaController.setPosition(position);
        //把Adapter对象传递给MyVideoMediaController对象
        viewHolder.videoPlayer.mediaController.setAdapter(this);
        if (position != currentPosition) {
            //设置为初始化状态
            viewHolder.videoPlayer.initViewDisplay();
        }
        Glide.with(context).load(R.drawable.gold).asGif()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(((ListViewHolder) holder).image);
        viewHolder.videoMoney.setText("¥" + info.getSellPrice());
        viewHolder.videoCommission.setText("¥" + info.getContPrice());
        viewHolder.videoSee.setText("" + info.getPlayNum());
        viewHolder.videoShare.setText("" + info.getTranspond());
        Glide.with(context).load(info.getCover()).into(viewHolder.videoBg);
        viewHolder.videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.itemClick(info.getPid(), info.getVid());
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoPlayerItemInfoList != null ? videoPlayerItemInfoList.size() : 0;
    }

    public void setPlayPosition(int position) {
        currentPosition = position;
    }


    static class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_bg)
        ImageView videoBg;
        @BindView(R.id.videoPlayer)
        VideoPlayer videoPlayer;
        @BindView(R.id.video_money)
        TextView videoMoney;
        @BindView(R.id.video_see)
        TextView videoSee;
        @BindView(R.id.video_share)
        TextView videoShare;
        @BindView(R.id.video_btn)
        LinearLayout videoBtn;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.video_commission)
        TextView videoCommission;

        ListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public interface IControl {
        void itemClick(int pid, int vid);
    }

    IControl control;

    public void setControl(IControl control) {
        this.control = control;
    }
}
