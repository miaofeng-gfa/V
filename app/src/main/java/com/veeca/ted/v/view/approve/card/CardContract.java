package com.veeca.ted.v.view.approve.card;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CardContract {
    interface View extends BaseView {
        void showError();

        void showUserError();

        void showUserInfo(UserInfo userInfo);

        void showV(Results results);

        void showCard(Results results);

        void showAddress(Results results);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo();

        void upV();

        void upCard(String IDCardName, String IDCard);

        void upAddress(String province);
    }
}
