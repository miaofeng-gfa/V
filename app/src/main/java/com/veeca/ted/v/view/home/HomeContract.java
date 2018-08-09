package com.veeca.ted.v.view.home;

import com.veeca.ted.v.bean.mian.AllCircle;
import com.veeca.ted.v.bean.mian.FriendCount;
import com.veeca.ted.v.bean.mian.HomeMoney;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HomeContract {
    interface View extends BaseView {
        void showError();

        void showAllCircle(AllCircle allCircle);

        void showMoney(HomeMoney homeMoney);

        void showFriendCounts(FriendCount friendCount);
    }

    interface Presenter extends BasePresenter<View> {
        void getMoney();

        void getAllCircle();

        void getFriendCounts();
    }
}
