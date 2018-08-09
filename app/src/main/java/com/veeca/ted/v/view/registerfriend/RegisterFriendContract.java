package com.veeca.ted.v.view.registerfriend;

import com.veeca.ted.v.bean.RegisterFriend;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class RegisterFriendContract {
    interface View extends BaseView {
        void showError();

        void  showUserInfo(UserInfo userInfo);

        void showRegisterFriend(RegisterFriend registerFriend);

    }

    interface Presenter extends BasePresenter<View> {

        void getRegisterFriend(int page);

        void getUserInfo();



    }
}
