package com.veeca.ted.v.view.income;

import com.veeca.ted.v.bean.FriendMoney;
import com.veeca.ted.v.bean.RewardMoney;
import com.veeca.ted.v.bean.SumMoney;
import com.veeca.ted.v.bean.Syt;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.mian.Buy;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class IncomeContract {
    interface View extends BaseView {
        void showMoney(RewardMoney money);

        void showProfit(FriendMoney money);

        void showBuy(Buy buy);

        void showSumMoney(SumMoney sumMoney);

        void showUsableMoney(UsableMoney usableMoney);

        void showSyt7(Syt syt);

        void showSyt30(Syt syt);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getMoney();

        void getProfit();

        void getBuy();

        void getSumMoney();

        void getUsableMoney();

        void getSyt7();

        void getSyt30();
    }
}
