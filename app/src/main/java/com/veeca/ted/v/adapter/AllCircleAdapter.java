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
import com.veeca.ted.v.bean.mian.AllCircle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/11/16.
 */

public class AllCircleAdapter extends RecyclerView.Adapter<AllCircleAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<AllCircle.DataBean> arrayList = new ArrayList<>();

    public void clear() {
        arrayList.clear();
    }

    public AllCircleAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(List<AllCircle.DataBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AllCircle.DataBean dataBean = arrayList.get(position);
        holder.itemView.setTag(dataBean);
        holder.circleName.setText(dataBean.getSctitle());
        Glide.with(context).load(dataBean.getScicon()).into(holder.circleImage);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.circle_image)
        ImageView circleImage;
        @BindView(R.id.circle_name)
        TextView circleName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public void onClick(View view) {
        //注意这里使用getTag方法获取position
        mOnItemClickListener.onItemClick(view, (AllCircle.DataBean) view.getTag());
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, AllCircle.DataBean dataBean);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
