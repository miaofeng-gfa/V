package com.veeca.ted.v.view.recharge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Recharge2Activity extends AutoLayoutActivity {

    @BindView(R.id.recharge2_money)
    TextView recharge2Money;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge2);
        ButterKnife.bind(this);
        intent = getIntent();
        recharge2Money.setText(intent.getStringExtra("money"));
    }

    @OnClick({R.id.top_return, R.id.recharge2_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.recharge2_btn:
                finish();
                break;
        }
    }
}
