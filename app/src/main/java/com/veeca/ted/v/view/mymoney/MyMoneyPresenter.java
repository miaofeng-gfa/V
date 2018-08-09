package com.veeca.ted.v.view.mymoney;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Tasking;
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

public class MyMoneyPresenter extends BasePresenterImpl<MyMoneyContract.View> implements MyMoneyContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getTasking(int type, int page) {
        service.getTasking(Constant.getUserId(), Constant.getToken(), type, page, 10)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Tasking>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getTasking:" + e.toString());
                    }

                    @Override
                    public void onNext(Tasking tasking) {
                        if (tasking.isSuccess()) mView.showTasking(tasking);
                        else mView.showError();
                    }
                });
    }
}
