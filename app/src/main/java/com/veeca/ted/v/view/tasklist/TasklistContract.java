package com.veeca.ted.v.view.tasklist;

import com.veeca.ted.v.bean.mian.TaskLists;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class TasklistContract {
    interface View extends BaseView {
        void showError();

        void showTaskLists(TaskLists taskLists);

    }

    interface Presenter extends BasePresenter<View> {
        void getTaskLists(int page);

    }
}
