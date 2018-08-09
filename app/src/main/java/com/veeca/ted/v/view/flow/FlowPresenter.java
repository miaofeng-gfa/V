package com.veeca.ted.v.view.flow;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.Task;
import com.veeca.ted.v.bean.TaskState;
import com.veeca.ted.v.bean.TaskV;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.BasePresenterImpl;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class FlowPresenter extends BasePresenterImpl<FlowContract.View> implements FlowContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getTask(int hid) {
        service.getTask(Constant.getUserId(), Constant.getToken(), hid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Task>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getTask:" + e.toString());
                    }

                    @Override
                    public void onNext(Task task) {
                        LogUtils.e("getTask:" + task.toString());
                        if (task.isSuccess()) mView.showTask(task);
                        else {
                            mView.showError();
                        }
                    }
                });
    }

    @Override
    public void getUserInfo() {
        service.getUserInfo(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getUserInfo:" + e.toString());
                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        LogUtils.e("getUserInfo:" + userInfo.toString());
                        if (userInfo.isSuccess()) mView.showUserInfo(userInfo);
                        else {
                            mView.showError();
                        }
                    }
                });
    }

    @Override
    public void getTaskV(int hid) {
        service.getTaskV(hid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TaskV>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getTaskV:" + e.toString());
                    }

                    @Override
                    public void onNext(TaskV taskV) {
                        LogUtils.e("getTaskV:" + taskV.toString());
                        mView.showTaskV(taskV);
                    }
                });
    }

    @Override
    public void getWardCont() {
        service.getWardCont(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getWardCont:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e("getWardCont:" + results.toString());
                        mView.showWardCont(results);
                    }
                });
    }

    @Override
    public void getShare(int hid) {
        service.getShare(Constant.getUserId(), Constant.getToken(), hid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getShare:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e("getShare:" + results.toString());
                        if (results.isSuccess()) mView.showShare(results);
                        else {
                            mView.showError();
                        }
                    }
                });
    }

    @Override
    public void getUserTaskState(int hid) {
        service.getUserTaskState(Constant.getUserId(), Constant.getToken(), hid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TaskState>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getUserTaskState:" + e.toString());
                    }

                    @Override
                    public void onNext(TaskState taskState) {
                        LogUtils.e("getUserTaskState:" + taskState.toString());

                    }
                });
    }
}
