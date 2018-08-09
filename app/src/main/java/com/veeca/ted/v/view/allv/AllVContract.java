package com.veeca.ted.v.view.allv;

import com.veeca.ted.v.bean.TaskV;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AllVContract {
    interface View extends BaseView {
        void showAll(TaskV taskV);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getTaskAllV(int hid,int page);
    }
}
