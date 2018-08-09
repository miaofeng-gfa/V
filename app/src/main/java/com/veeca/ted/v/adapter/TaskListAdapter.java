package com.veeca.ted.v.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.mian.TaskLists;
import com.veeca.ted.v.view.flow.FlowActivity;
import com.veeca.ted.v.view.h5.H5Activity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/11/20.
 */

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {
    private Context context;
    private List<TaskLists.DataBean> taskLists = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("0.00");
    private String cpc;
    private Intent intent;

    //记录之前播放的条目下标
    public int currentPosition = -1;
    public TaskListAdapter(Context context) {
        this.context = context;
    }

    public void setTaskLists(List taskLists) {
        this.taskLists = taskLists;
    }

    public void clear() {
        taskLists.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final TaskLists.DataBean dataBean = taskLists.get(position);
//        holder.itemView.setTag(dataBean);
       /* if (dataBean.getRep()==0){
            holder.tvTaskRep.setText("认证");
            holder.tvTaskRep.setTextColor(context.getResources().getColor(R.color.font_gray_1c));
            holder.tvTaskRep.setBackground(context.getResources().getDrawable(R.drawable.approve));
        }else if(dataBean.getRep()==1){
            holder.tvTaskRep.setText("VIP");
            holder.tvTaskRep.setTextColor(context.getResources().getColor(R.color.font_gray_1c));
            holder.tvTaskRep.setBackground(context.getResources().getDrawable(R.drawable.taskvip));
        }*/

        if ((dataBean.getIsjoin()==0)){
            holder.taskItemIn.setVisibility(View.GONE);
            holder.taskItemUn.setVisibility(View.VISIBLE);
             holder.tvTaskState.setVisibility(View.VISIBLE);
        }else{
            holder.taskItemIn.setVisibility(View.VISIBLE);
            holder.taskItemUn.setVisibility(View.GONE);
             holder.tvTaskState.setVisibility(View.GONE);
        }


            if (dataBean.getStatusr() == 3) {
                holder.tvTaskState.setText("预测你的转发分红");
                holder.tvTaskState.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.tvTaskName.setText("可提现");
                holder.tvTaskName.setVisibility(View.VISIBLE);
                holder.tvTaskBtn.setBackground(context.getResources().getDrawable(R.mipmap.video_btn));
                holder.tvTaskSurplus.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.tvTaskMoney.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.tvClickCount.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.tvClickCountDes.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.tvItemMonry.setTextColor(context.getResources().getColor(R.color.yellow));
                holder.tvItemMonryDes.setTextColor(context.getResources().getColor(R.color.yellow));
            } else {
                holder.tvTaskState.setText("已错过的转发分红");
                holder.tvTaskState.setTextColor(context.getResources().getColor(R.color.font_gray_c));
                holder.tvTaskName.setVisibility(View.INVISIBLE);
                holder.tvTaskBtn.setBackground(context.getResources().getDrawable(R.mipmap.qun_btn_n));
                holder.tvTaskSurplus.setTextColor(context.getResources().getColor(R.color.font_gray_c));
                holder.tvTaskMoney.setTextColor(context.getResources().getColor(R.color.font_gray_c));
                holder.tvClickCount.setTextColor(context.getResources().getColor(R.color.font_gray_c));
                holder.tvClickCountDes.setTextColor(context.getResources().getColor(R.color.font_gray_c));
                holder.tvItemMonry.setTextColor(context.getResources().getColor(R.color.font_gray_c));
                holder.tvItemMonryDes.setTextColor(context.getResources().getColor(R.color.font_gray_c));
            }

        Glide.with(context).load(R.drawable.gold).asGif().placeholder(R.color.font_color)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(((ViewHolder) holder).image);

        holder.tvTaskSurplus.setText("¥" +String.format("%.2f",Double.valueOf(dataBean.getLeft1())) );
        holder.tvTaskContent.setText(dataBean.getTitle());
        holder.tvTaskSee.setText(""+String.format("%.1f",Double.valueOf(dataBean.getCountc()/10000.0))+"w");
        holder.tvTaskShare.setText(""+dataBean.getForward());
        cpc = df.format(dataBean.getCpc());
        holder.tvTaskMoney.setText("¥" +cpc);
        if (dataBean.getCpccount()==null){
            holder.tvClickCount.setText("0");
            holder.tvItemMonry.setText("0");
        }else{
            holder.tvClickCount.setText(""+dataBean.getCpccount());
            holder.tvItemMonry.setText(""+Integer.parseInt(dataBean.getCpccount())*dataBean.getCpc());
        }


        Glide.with(context)
                .load(dataBean.getCoverimg())
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        Drawable drawable = new BitmapDrawable(resource);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            holder.itemTaskBg.setBackground(drawable);   //设置背景
                        }
                    }
                });
        holder.tvTaskBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent = new Intent(context, FlowActivity.class);
                intent.putExtra("id", dataBean.getId());
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*intent = new Intent(context, FlowActivity.class);
                intent.putExtra("id", dataBean.getId());*/
                intent = new Intent(context, H5Activity.class);
                intent.putExtra("url", dataBean.getUrl());
                context.startActivity(intent);
            }
        });

    }
    public void setPlayPosition(int position) {
        currentPosition = position;
    }

    @Override
    public int getItemCount() {
        return taskLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_task_state)
        TextView tvTaskState;
        @BindView(R.id.tv_task_surplus)
        TextView tvTaskSurplus;
        @BindView(R.id.tv_task_money)
        TextView tvTaskMoney;
        @BindView(R.id.tv_task_name)
        TextView tvTaskName;
        @BindView(R.id.tv_task_content)
        TextView tvTaskContent;
        @BindView(R.id.item_task_bg)
        RelativeLayout itemTaskBg;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.task_see)
        TextView tvTaskSee;
        @BindView(R.id.task_share)
        TextView tvTaskShare;
        @BindView(R.id.task_click_count)
        TextView tvClickCount;
        @BindView(R.id.task_item_money)
        TextView tvItemMonry;
        @BindView(R.id.task_click_countdes)
        TextView tvClickCountDes;
        @BindView(R.id.task_item_moneydes)
        TextView tvItemMonryDes;
        @BindView(R.id.task_btn)
        LinearLayout tvTaskBtn;
        @BindView(R.id.task_item_injoined)
        LinearLayout taskItemIn;
        @BindView(R.id.task_item_uninjoin)
        LinearLayout taskItemUn;
       /* @BindView(R.id.tv_task_lvrep)
        TextView tvTaskRep;
*/
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
