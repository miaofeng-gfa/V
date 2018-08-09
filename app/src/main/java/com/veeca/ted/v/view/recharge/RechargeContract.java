package com.veeca.ted.v.view.recharge;

import com.veeca.ted.v.bean.Recharge;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class RechargeContract {
    interface View extends BaseView {
        void showRecharge(Recharge recharge);

        void showUsableMoney(UsableMoney usableMoney);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getRecharge(double money);

        void getUsableMoney();
    }
}
