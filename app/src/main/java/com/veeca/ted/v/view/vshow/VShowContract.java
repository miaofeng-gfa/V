package com.veeca.ted.v.view.vshow;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.VInfo;
import com.veeca.ted.v.bean.VLive;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VShowContract {
    interface View extends BaseView {
        void showVInfo(VInfo vInfo);

        void showVTag(List<String> list);

        void showReward(Results results);

        void showEngagement(Results results);

        void showVLive(List<VLive> vLives);
    }

    interface Presenter extends BasePresenter<View> {
        void getVInfo(int rid);

        void getVTag(int rid);

        void getVLive(int rid);

        void getReward(int uid, String money, String wxAccount, int rid, int num);

        void getEngagement(int rsid, int rid, int uid, String shareUrl);
    }
}
