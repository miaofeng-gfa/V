package com.veeca.ted.v.view.circledetails;

import com.veeca.ted.v.bean.CircleData;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CircleDetailsContract {
    interface View extends BaseView {
        void showCircleData(CircleData circleData);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getCircleData(int scid);
    }
}
