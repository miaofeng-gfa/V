package com.veeca.ted.v.view.approve.account;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserBind;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AccountContract {
    interface View extends BaseView {
        void showError();

        void showUserBind(UserBind userBind);

        void showThird(Results results);

        void showThird1(Results results);

        void showWX(Results results);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserBind();

        void getWX();

        void upUserThird(int type, String name, String headimgurl, String fans);

        void upUserThird1(int type, String name, String openid, String unionid, String headimgurl);
    }
}
