package com.veeca.ted.v.view.release;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.myclass.SelectDialog;
import com.veeca.ted.v.view.approve.ApproveActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ReleaseActivity extends MVPBaseActivity<ReleaseContract.View, ReleasePresenter> implements ReleaseContract.View {

    private Context context;
    private Intent intent;
    private SelectDialog dialog_approve;
    @BindView(R.id.iv_release)
    ImageView ivRelease;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        ButterKnife.bind(this);
       
        context = getContext();
      
    }


    @OnClick(R.id.top_return)
    public void onViewClicked() {
        finish();
    }

    @OnClick(R.id.iv_release)
    public void onReleaseClicked() {
        approveDialog();
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
