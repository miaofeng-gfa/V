package com.veeca.ted.v.view.login;

import com.veeca.ted.v.bean.Login;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        void showLogin(Login login);
    }

    interface Presenter extends BasePresenter<View> {

        void getLogin(String headimgurl, String nickname, int sex, String country, String province, String city, String openid, String unionid);

        void getProperties();
    }
}
