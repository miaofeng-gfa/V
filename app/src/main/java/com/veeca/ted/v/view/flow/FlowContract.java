package com.veeca.ted.v.view.flow;

import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.Task;
import com.veeca.ted.v.bean.TaskV;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.view.mvp.BasePresenter;
import com.veeca.ted.v.view.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class FlowContract {
    interface View extends BaseView {
        void showError();

        void showTask(Task task);

        void showTaskV(TaskV taskV);

        void showUserInfo(UserInfo userInfo);

        void showShare(Results results);

        void showWardCont(Results results);

    }

    interface Presenter extends BasePresenter<View> {
        void getTask(int hid);

        void getUserInfo();

        void getTaskV(int hid);

        void getWardCont();

        void getShare(int hid);

        void getUserTaskState(int hid);
    }
}
