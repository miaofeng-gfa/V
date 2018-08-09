package com.veeca.ted.v.view.video;

import com.veeca.ted.v.bean.Goods;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.VideoCode;
import com.veeca.ted.v.bean.VideoPlayerItemInfo;
import com.veeca.ted.v.bean.VideoUrl;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VideoContract {
    interface View extends BaseView {
        void showVideos(VideoPlayerItemInfo info);

        void showGoods(Goods goods);

        void showVideoCode(VideoCode videoCode);

        void showVideoUrl(VideoUrl videoUrl);

        void showCodeSuccess(Results results);
    }

    interface Presenter extends BasePresenter<View> {
        void getVideos(int page);

        void getGoods(int vid);

        void getVideoCode(int vid);

        void getVideoUrl(int vid);

        void getCodeSuccess(int pid, int vid);

        void getPlay(int vid);
    }
}
