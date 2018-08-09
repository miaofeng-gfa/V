package com.veeca.ted.v.view.mymoney;

import com.veeca.ted.v.bean.Tasking;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyMoneyContract {
    interface View extends BaseView {
        void showError();

        void showTasking(Tasking tasking);
    }

    interface Presenter extends BasePresenter<View> {
        void getTasking(int type, int page);
    }
}
