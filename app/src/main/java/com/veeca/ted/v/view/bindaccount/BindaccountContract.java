package com.veeca.ted.v.view.bindaccount;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindaccountContract {
    interface View extends BaseView {
        void showError();

        void showThird(Results results);

    }

    interface Presenter extends BasePresenter<View> {

        void upUserThird2(int type, String tcauthimgurl);
    }
}
