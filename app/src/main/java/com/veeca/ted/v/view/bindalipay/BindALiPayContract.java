package com.veeca.ted.v.view.bindalipay;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindALiPayContract {
    interface View extends BaseView {
        void showUserInfo(UserInfo userInfo);

        void showBindALiPay(Results results);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo();

        void getBindALiPay(String name, String idCard, String account);
    }
}
