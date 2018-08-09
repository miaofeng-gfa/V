package com.veeca.ted.v.view.myprofit;

import com.veeca.ted.v.bean.mian.MyProfit;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyProfitContract {
    interface View extends BaseView {
        void showMyProfitList(MyProfit profit);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getMyProfitList(int page);
    }
}
