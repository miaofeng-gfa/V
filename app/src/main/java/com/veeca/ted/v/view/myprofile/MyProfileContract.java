package com.veeca.ted.v.view.myprofile;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.Circle;
import com.veeca.ted.v.bean.mian.Like;
import com.veeca.ted.v.bean.mian.UserCircle;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.bean.mian.UserLike;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyProfileContract {
    interface View extends BaseView {
        void showUserInfo(UserInfo userInfo);

        void showLike(UserLike userLike);

        void showCircle(UserCircle userCircle);

        void showMyProfile(Results results);

        void showApproveLike(Like like);

        void showApproveCircle(Circle circle);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo();

        void getUserLike();

        void getUserCircle();

        void getApproveCircle();

        void getApproveLike();

        void getMyProfile(String headimhurl, String nickname, String province, String labelIds, String circleIds);
    }
}
