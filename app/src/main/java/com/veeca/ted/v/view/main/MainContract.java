package com.veeca.ted.v.view.main;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.Version;
import com.veeca.ted.v.bean.mian.Income;
import com.veeca.ted.v.bean.mian.Sign;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainContract {
    interface View extends BaseView {
        void showVersion(Version version);

        void showSign(Sign sign);

        void showSignSuccess(Results results);

        void showMainIncome(Income income);

        void showUserInfo(UserInfo userInfo);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getVersion();

        void getSign();

        void getSignSuccess(int gisign, int ginum, int inum);

        void getMainIncome();

        void getUserInfo();
    }
}
