package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veeca.ted.v.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/9/20.
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<String> dataBeans = new ArrayList<>();

    public void clear() {
        dataBeans.clear();
    }

    public AddressAdapter(Context context) {
        this.context = context;
    }

    public void setDataBeans(String[] dataBeans) {
        for (int i = 0; i < dataBeans.length; i++)
            this.dataBeans.add(dataBeans[i]);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String dataBean = dataBeans.get(position);
        holder.itemView.setTag(dataBean);
        holder.addressText.setText(dataBean);
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.address_text)
        TextView addressText;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //
    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取position
        mOnItemClickListener.onItemClick(v, (String) v.getTag());
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, String dataBean);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
