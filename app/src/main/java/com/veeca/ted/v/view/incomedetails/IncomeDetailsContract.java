package com.veeca.ted.v.view.incomedetails;

import com.veeca.ted.v.bean.MyWithdraw;
import com.veeca.ted.v.bean.mian.MyMoney;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class IncomeDetailsContract {
    interface View extends BaseView {
        void showMyMoneyList(MyMoney myMoney);

        void showMyWithdrawList(MyWithdraw myWithdraw);

        void showError();

    }

    interface Presenter extends BasePresenter<View> {
        void getMyMoneyList(int page);

        void getMyWithdrawList(int page);
    }
}
