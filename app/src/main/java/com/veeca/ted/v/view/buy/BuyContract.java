package com.veeca.ted.v.view.buy;

import com.veeca.ted.v.bean.VideoBuy;
import com.veeca.ted.v.bean.VideoSee;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BuyContract {
    interface View extends BaseView {
        void showVideoSee(VideoSee videoSee);

        void showVideoBuy(VideoBuy videoBuy);
    }

    interface Presenter extends BasePresenter<View> {
        void getVideoSee(int page);

        void getVideoBuy(int page);
    }
}
