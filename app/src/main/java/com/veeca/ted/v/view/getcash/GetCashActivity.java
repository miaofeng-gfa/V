package com.veeca.ted.v.view.getcash;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veeca.ted.v.R;
import com.veeca.ted.v.myclass.SelectDialog;
import com.veeca.ted.v.view.approve.ApproveActivity;
import com.veeca.ted.v.view.extract.ExtractActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class GetCashActivity extends MVPBaseActivity<GetCashContract.View, GetCashPresenter> implements GetCashContract.View {

    private Context context;
    private Intent intent;
    private SelectDialog dialog_approve;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getcash);
        ButterKnife.bind(this);
       
        context = getContext();
      
    }


    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @OnClick(R.id.rl_getcash_fubao)
    public  void onFuBaoClick(){
        intent = new Intent(context, ExtractActivity.class);
        intent.putExtra("getcashtype", "1");
        startActivity(intent);

    }

    @OnClick(R.id.rl_getcash_weixin)
    public  void onWeiXinClick(){
        intent = new Intent(context, ExtractActivity.class);
        intent.putExtra("getcashtype", "0");
        startActivity(intent);


    }
    private void approveDialog() {
        dialog_approve = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.dialog_approve, null);
        viewDialog.findViewById(R.id.approve_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, ApproveActivity.class);
                startActivity(intent);
                dialog_approve.dismiss();
            }
        });
        Display display = this.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_approve.setContentView(viewDialog, layoutParams);
        dialog_approve.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       
    }

}
