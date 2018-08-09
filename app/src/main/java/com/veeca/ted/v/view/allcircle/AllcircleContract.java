package com.veeca.ted.v.view.allcircle;

import com.veeca.ted.v.bean.mian.AllCircle;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AllcircleContract {
    interface View extends BaseView {
        void showAllCircle(AllCircle allCircle);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getAllCircle();
    }
}
