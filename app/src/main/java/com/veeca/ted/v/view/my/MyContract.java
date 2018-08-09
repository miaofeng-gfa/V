package com.veeca.ted.v.view.my;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyContract {
    interface View extends BaseView {
        void showUserInfo(UserInfo userInfo);

        void showError();

        void showWardCont(Results results);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo();

        void getWardCont();
    }
}
