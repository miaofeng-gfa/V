package com.veeca.ted.v.view.influence;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserBind;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class InfluenceContract {
    interface View extends BaseView {
        void showError();

        void showUserBind(UserBind userBind);

        void showUserInfo(UserInfo userInfo);

        void showUserThird1(Results results);

        void showUserThird(Results results);

        void showPhoto();

    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo();

        void upUserThird(int type, String name, String headimgurl, String fans);

        void getUserBind();

        void upUserThird1(int type, String name, String openid, String unionid, String headimgurl);

        void getPhoto(String jsonStr);
    }
}
