package com.veeca.ted.v.view.task;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.veeca.ted.v.R;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class TaskActivity extends MVPBaseActivity<TaskContract.View, TaskPresenter> implements TaskContract.View {

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }
}
