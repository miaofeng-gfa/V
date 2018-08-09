package com.veeca.ted.v.view.allv;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.TaskV;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.BasePresenterImpl;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AllVPresenter extends BasePresenterImpl<AllVContract.View> implements AllVContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getTaskAllV(int hid, int page) {
        service.getTaskAllV(hid, page, 20)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TaskV>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getTaskAllV:" + e.toString());
                    }

                    @Override
                    public void onNext(TaskV taskV) {
                        if (taskV.isSuccess()) mView.showAll(taskV);
                        else mView.showError();
                    }
                });
    }
}
