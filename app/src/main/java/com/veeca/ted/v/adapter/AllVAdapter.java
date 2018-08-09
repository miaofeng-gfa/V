package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.TaskV;
import com.veeca.ted.v.widget.CircleImageView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/9/20.
 */

public class AllVAdapter extends RecyclerView.Adapter<AllVAdapter.ViewHolder> {

    private Context context;
    private List<TaskV.XiaovShareListBean> listBeans = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("0.00");

    public void clear() {
        listBeans.clear();
    }

    public void setListBeans(List<TaskV.XiaovShareListBean> listBeans) {
        this.listBeans = listBeans;
    }

    public AllVAdapter(Context context) {
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_v, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        TaskV.XiaovShareListBean dataBean = listBeans.get(position);
        int id = position + 1;
        holder.vId.setText(id + "");
        Glide.with(context).load(dataBean.getRes2()).into(holder.vAvatar);
        holder.vName.setText(dataBean.getRes1());
        holder.vNum.setText("已获得点击" + dataBean.getRes3() + "次");
        holder.vMoney.setText("¥" + df.format(dataBean.getRes4()));
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.v_id)
        TextView vId;
        @BindView(R.id.v_avatar)
        CircleImageView vAvatar;
        @BindView(R.id.v_name)
        TextView vName;
        @BindView(R.id.v_num)
        TextView vNum;
        @BindView(R.id.v_money)
        TextView vMoney;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
