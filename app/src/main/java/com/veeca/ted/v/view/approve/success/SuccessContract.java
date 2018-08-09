package com.veeca.ted.v.view.approve.success;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SuccessContract {
    interface View extends BaseView {
        void showUserCard(Results results);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserCard(String cardImg);
    }
}
