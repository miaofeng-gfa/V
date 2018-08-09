package com.veeca.ted.v.view.vadshare;

import com.veeca.ted.v.bean.FriMoneyThir;
import com.veeca.ted.v.bean.FriendMoney;
import com.veeca.ted.v.bean.mian.FriendCount;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * Created by Administrator on 2018-03-17.
 */

public class VadShareContract {
    interface View extends BaseView {

        void showFriendCounts(FriendCount friendCount);

        void showProfit(FriendMoney money);

        void showFriendMoney30(FriMoneyThir fmt);

//        void showRegisterFriend(RegisterFriend registerFriend);

//        void showNotRegisterFriend(NoRegisterFriend noRegisterFriend);
    }

    interface  Presenter extends BasePresenter<View> {
        void getFriendCounts();

        void getProfit();

        void getFriendMoney30();

//        void getRegisterFriend(int page);

//        void getNotRegisterFriend(int page);
    }
}
