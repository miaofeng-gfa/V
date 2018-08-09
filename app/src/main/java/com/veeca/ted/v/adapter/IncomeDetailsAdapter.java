package com.veeca.ted.v.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.MyWithdraw;
import com.veeca.ted.v.bean.mian.MyMoney;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ted on 2017/9/20.
 */

public class IncomeDetailsAdapter extends RecyclerView.Adapter<IncomeDetailsAdapter.ViewHolder> {

    private int type;
    private Context context;
    private List<MyMoney.DataBean> moneyLists = new ArrayList<>();
    private List<MyWithdraw.DataBean> withdrawLists = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("0.00");

    public void clear() {
        moneyLists.clear();
        withdrawLists.clear();
    }

    public IncomeDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setMoneyLists(List<MyMoney.DataBean> moneyLists, int type) {
        this.type = type;
        this.moneyLists = moneyLists;
    }

     public void setWithdrawLists(List<MyWithdraw.DataBean> withdrawLists, int type) {
         this.type = type;
        this.withdrawLists = withdrawLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_income_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (type == 1) {
            MyMoney.DataBean dataBean = moneyLists.get(position);
            holder.exMoney.setText("¥" + df.format(dataBean.getOof()));
            holder.exTime.setText(dataBean.getGettime());
            holder.exTitle.setText(dataBean.getTitle());
        } else {
            MyWithdraw.DataBean dataBean = withdrawLists.get(position);
            String title;
            switch (dataBean.getStatuss()) {
                case 0:
                    title = "发起提现";

                    break;
                case 1:
                    title = "提现成功";
                    holder.exMoney.setText("¥" + df.format(dataBean.getAmount()));
                    break;
                default:
                    title = "提现失败";

                    break;
            }
            holder.exTime.setText(dataBean.getUpdatetime());
            holder.exTitle.setText(title);
        }

    }

    @Override
    public int getItemCount() {
        if (type == 1)
            return moneyLists.size();
        else
            return withdrawLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ex_title)
        TextView exTitle;
        @BindView(R.id.ex_time)
        TextView exTime;
        @BindView(R.id.ex_money)
        TextView exMoney;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
