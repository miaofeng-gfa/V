package com.veeca.ted.v.view.gold;

import com.veeca.ted.v.bean.mian.Gold;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class GoldContract {
    interface View extends BaseView {
        void showGold(Gold gold);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void getGold();
    }
}
