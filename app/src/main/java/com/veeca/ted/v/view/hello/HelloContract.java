package com.veeca.ted.v.view.hello;

import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HelloContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {
        void getProperties();
    }
}
