package com.veeca.ted.v.view.bindweixin;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindWeiXinContract {
    interface View extends BaseView {
        void showUserPhoto(Results results);

    }

    interface Presenter extends BasePresenter<View> {
        void upUserPhoto(int type, String tcauthimgurl);

    }
}
