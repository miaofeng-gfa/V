package com.veeca.ted.v.view.center;

import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CenterContract {
    interface View extends BaseView {
        void showUserInfo(UserInfo userInfo);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo();
    }
}
