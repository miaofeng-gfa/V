package com.veeca.ted.v.view.noregisterfriend;

import com.veeca.ted.v.bean.NoRegisterFriend;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class NoRegisterFriendContract {
    interface View extends BaseView {
        void showError();

        void  showUserInfo(UserInfo userInfo);

        void showNotRegisterFriend(NoRegisterFriend noRegisterFriend);

    }

    interface Presenter extends BasePresenter<View> {


        void getNotRegisterFriend(int page);

        void getUserInfo();

    }
}
