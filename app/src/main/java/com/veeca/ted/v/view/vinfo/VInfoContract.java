package com.veeca.ted.v.view.vinfo;

import com.veeca.ted.v.bean.UserV;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VInfoContract {
    interface View extends BaseView {
        void showUserV(UserV userV);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserV(int uid);
    }
}
