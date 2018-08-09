package com.veeca.ted.v.view.community;

import com.veeca.ted.v.bean.QunList;
import com.veeca.ted.v.bean.QunTags;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.VLists;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CommunityContract {
    interface View extends BaseView {
        void showV(VLists vLists);

        void showQun(QunList qunList);

        void showQunTags(QunTags tags);

        void showError();

        void showJoinQun(int state, Results results);

        void showUsableMoney(int i, UsableMoney usableMoney);
    }

    interface Presenter extends BasePresenter<View> {
        void getV();

        void getQun(String id, final int page, int sign);

        void getQunTags();

        void getJoinQun(int state, int fid, double money, String wx, int sign, int free);

        void getUsableMoney(int i);
    }
}
