package com.veeca.ted.v.view.tasklist;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.mian.TaskLists;
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

public class TasklistPresenter extends BasePresenterImpl<TasklistContract.View> implements TasklistContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();


    @Override
    public void getTaskLists(int page) {

        service.getTaskLists2(Constant.getUserId(), Constant.getToken(), page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TaskLists>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getTaskLists:" + e.toString());
                    }

                    @Override
                    public void onNext(TaskLists taskLists) {
                        if (taskLists.isSuccess())
                            mView.showTaskLists(taskLists);
                        else
                            mView.showError();
                    }
                });
    }

//    @Override
//    public void getTaskLists3(int page) {
//        service.getTaskLists3(Constant.getUserId(), Constant.getToken(), page)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<TaskLists>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtils.e("getTaskLists3:" + e.toString());
//                    }
//
//                    @Override
//                    public void onNext(TaskLists taskLists) {
//                        if (taskLists.isSuccess())
//                            mView.showTaskLists3(taskLists);
//                        else
//                            mView.showError();
//                    }
//                });
//    }
}
