package com.veeca.ted.v.view.bindphone;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindPhoneContract {
    interface View extends BaseView {
        void showCode(Results results);

        void showPhone(Results results);
    }

    interface Presenter extends BasePresenter<View> {
        void getCode(String phone);

        void getPhone(String phone, String code);
    }
}
