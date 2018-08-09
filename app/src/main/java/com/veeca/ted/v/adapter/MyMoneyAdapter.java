package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Tasking;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/9/20.
 */

public class MyMoneyAdapter extends RecyclerView.Adapter<MyMoneyAdapter.ViewHolder> {

    private Context context;
    private List<Tasking.DataBean> dataBeans = new ArrayList<>();

    public void clear() {
        dataBeans.clear();
    }

    public MyMoneyAdapter(Context context) {
        this.context = context;
    }

    public void setDataBeans(List<Tasking.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tasking, parent, false);
        //将创建的View注册点击事件
//        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Tasking.DataBean dataBean = dataBeans.get(position);
//        holder.itemView.setTag(dataBean);
        holder.taskingName.setText(dataBean.getRes1());
        if (dataBean.getRes3() != 0) {
            holder.taskingNum.setText("已获得" + dataBean.getRes3() + "次点击");
        } else {
            holder.taskingNum.setVisibility(View.GONE);
        }
        if (dataBean.getRes2() == 2) {
            holder.taskingState.setText("推手赏金");
        }
        holder.taskingMoney.setText("¥" + dataBean.getRes4());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tasking_name)
        TextView taskingName;
        @BindView(R.id.tasking_num)
        TextView taskingNum;
        @BindView(R.id.tasking_state)
        TextView taskingState;
        @BindView(R.id.tasking_money)
        TextView taskingMoney;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //
//    @Override
//    public void onClick(View v) {
//        //注意这里使用getTag方法获取position
//        mOnItemClickListener.onItemClick(v, (Tasking.DataBean) v.getTag());
//    }
//
//    //define interface
//    public interface OnItemClickListener {
//        void onItemClick(View view, Tasking.DataBean dataBean);
//    }
//
//    private OnItemClickListener mOnItemClickListener = null;
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.mOnItemClickListener = listener;
//    }

}
