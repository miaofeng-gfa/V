package com.veeca.ted.v.view.extract;

import android.os.Bundle;
import android.view.View;

import com.veeca.ted.v.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExtractEndActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_end);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.top_return, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.btn:
                finish();
                break;
        }
    }
}
