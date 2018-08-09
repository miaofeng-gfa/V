package com.veeca.ted.v.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.QunList;
import com.veeca.ted.v.utils.CustomLinearGridLayoutManager;
import com.veeca.ted.v.widget.SuperCircleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/8/5.
 */

public class QunAdapter extends RecyclerView.Adapter<QunAdapter.ViewHolder> {//implements View.OnClickListener
    List<QunList.DataBean> lists = new ArrayList<>();
    Context context;
    String colors[] = {"#4FC7FF", "#FFD14F", "#86E371", "#F7728B", "#FD74EB"};

    private CustomLinearGridLayoutManager listLayoutManager;

    private QunVAdapter qunVAdapter;

    public void clear() {
        lists.clear();
    }

    public void setLists(List<QunList.DataBean> lists) {
        this.lists = lists;
    }

    public QunAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qun, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final QunList.DataBean dataBean = lists.get(position);
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(dataBean);
        Glide.with(context).load(dataBean.getFheadimgurl()).into(holder.qunAvatar);
        holder.qunName.setText(dataBean.getFname());
        if (dataBean.getPerson() < 100) {
            holder.qunNum.setText("50+");
        } else if (dataBean.getPerson() >= 100 && dataBean.getPerson() < 200) {
            holder.qunNum.setText("100+");
        } else if (dataBean.getPerson() >= 200 && dataBean.getPerson() < 300) {
            holder.qunNum.setText("200+");
        } else if (dataBean.getPerson() >= 300 && dataBean.getPerson() < 400) {
            holder.qunNum.setText("300+");
        } else {
            holder.qunNum.setText("400+");
        }
        String[] strings = dataBean.getCircleName().split(",");
        for (int i = 0; i < 3; i++) {
            holder.qunTags.get(i).setVisibility(View.GONE);
        }
        for (int i = 0; i < strings.length; i++) {
            holder.qunTags.get(i).setVisibility(View.VISIBLE);
            holder.qunTags.get(i).setText(strings[i]);
        }
        if (dataBean.getFmanpre() > 50) {
            holder.tvs.get(0).setText("男性");
            holder.cdTvs.get(0).setTextColor(context.getResources().getColor(R.color.man));
            holder.qunText.setTextColor(context.getResources().getColor(R.color.man));
            initSuperCircleView(dataBean.getFmanpre(), holder.superviews.get(0), holder.cdTvs.get(0), colors[0]);
        } else {
            holder.cdTvs.get(0).setTextColor(context.getResources().getColor(R.color.woman));
            holder.qunText.setTextColor(context.getResources().getColor(R.color.woman));
            holder.tvs.get(0).setText("女性");
            initSuperCircleView((100 - dataBean.getFmanpre()), holder.superviews.get(0), holder.cdTvs.get(0), colors[4]);
        }
        holder.grade.setText(dataBean.getFgrade() + "");
        for (int i = 1; i <= dataBean.getFgrade(); i++) {
            Glide.with(context).load(R.mipmap.xing).into(holder.xings.get(i - 1));
            if ((dataBean.getFgrade() - i) > 0 && (dataBean.getFgrade() - i) < 1) {
                Glide.with(context).load(R.mipmap.xing_ban).into(holder.xings.get(i));
            }
        }
        holder.tvs.get(1).setText(dataBean.getFaname());
        initSuperCircleView(dataBean.getFapre(), holder.superviews.get(1), holder.cdTvs.get(1), colors[1]);
        holder.tvs.get(2).setText(dataBean.getFrname());
        initSuperCircleView(dataBean.getFrpre(), holder.superviews.get(2), holder.cdTvs.get(2), colors[2]);
        holder.tvs.get(3).setText(dataBean.getLabelName());
        initSuperCircleView(dataBean.getFlpre(), holder.superviews.get(3), holder.cdTvs.get(3), colors[3]);
        holder.qunHot.setText("火热度 " + dataBean.getFhot());

        if (dataBean.getIsState() == 0) {
            holder.qunBtn.setText("已申请");
            holder.qunBtn.setTextColor(context.getResources().getColor(R.color.font_gray_9));
            holder.qunBtn.setBackgroundResource(R.mipmap.qun_btn_n);
        } else {
            holder.qunBtn.setTextColor(context.getResources().getColor(R.color.font_color));
            holder.qunBtn.setBackgroundResource(R.mipmap.qun_btn);
            if (dataBean.getIsfree() == 0)
                holder.qunBtn.setText("免费");
            else
                holder.qunBtn.setText("¥" + dataBean.getFmoney());
        }
        holder.qunBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.chkClick(dataBean);
            }
        });

        qunVAdapter = new QunVAdapter(context);
        listLayoutManager = new CustomLinearGridLayoutManager(context, dataBean.getMemberList().size(),
                LinearLayoutManager.VERTICAL, false);
        listLayoutManager.setScrollEnabled(false);
        holder.qunRecycler.setLayoutManager(listLayoutManager);
        holder.qunRecycler.setHasFixedSize(true);
        qunVAdapter.setDataBeans(dataBean.getMemberList());

        holder.qunRecycler.setAdapter(qunVAdapter);
        //todo item点击
        qunVAdapter.setOnItemClickListener(new QunVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, QunList.DataBean.MemberListBean dataBean) {
                control.itemClick(dataBean);
            }
        });
    }

    /**
     * 初始化圆环数据
     */
    private void initSuperCircleView(int i, final SuperCircleView superCircleView, final TextView textView, String colors) {

        superCircleView.setShowSelect(false);
        superCircleView.setMColors(colors, colors, colors);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, i);
        valueAnimator.setTarget(textView);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int i = Integer.valueOf(String.valueOf(animation.getAnimatedValue()));
                textView.setText(i + "");
                superCircleView.setSelect((int) (360 * (i / 100f)));
            }
        });
        valueAnimator.start();
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public interface IControl {
        void chkClick(QunList.DataBean dataBean);

        void itemClick(QunList.DataBean.MemberListBean dataBean);
    }

    IControl control;

    public void setControl(IControl control) {
        this.control = control;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.qun_avatar)
        ImageView qunAvatar;
        @BindView(R.id.qun_name)
        TextView qunName;
        @BindView(R.id.grade)
        TextView grade;
        @BindView(R.id.qun_text)
        TextView qunText;
        @BindView(R.id.qun_num)
        TextView qunNum;
        @BindViews({R.id.qun_tag1, R.id.qun_tag2, R.id.qun_tag3})
        List<TextView> qunTags;
        @BindViews({R.id.xing1, R.id.xing2, R.id.xing3, R.id.xing4, R.id.xing5})
        List<ImageView> xings;
        @BindViews({R.id.superview1, R.id.superview2, R.id.superview3, R.id.superview4})
        List<SuperCircleView> superviews;
        @BindViews({R.id.cd_tv1, R.id.cd_tv2, R.id.cd_tv3, R.id.cd_tv4})
        List<TextView> cdTvs;
        @BindViews({R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.tv_4})
        List<TextView> tvs;
        @BindView(R.id.qun_btn)
        Button qunBtn;
        @BindView(R.id.qun_recycler)
        RecyclerView qunRecycler;
        @BindView(R.id.qun_hot)
        TextView qunHot;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
