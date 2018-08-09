package com.veeca.ted.v.view.extract;

import com.veeca.ted.v.bean.IsFirstMoney;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.UserAllCard;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ExtractContract {
    interface View extends BaseView {

        void showAllCard(UserAllCard userAllCard);

        void showUsableMoney(UsableMoney usableMoney);

        void showIsTxAll(IsFirstMoney isfirstmoney);

        void showExtract(Results results);


        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getAllCard();

        void getExtract(String amount);

        void getUsableMoney();

        void getIsTxAll();

    }
}
