package com.veeca.ted.v.view.allcircle;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.mian.AllCircle;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.BasePresenterImpl;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AllcirclePresenter extends BasePresenterImpl<AllcircleContract.View> implements AllcircleContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getAllCircle() {
        service.getAllCircle(0)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AllCircle>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getAllCircle:" + e.toString());
                    }

                    @Override
                    public void onNext(AllCircle allCircle) {
                        if (allCircle.isSuccess())
                            mView.showAllCircle(allCircle);
                        else
                            mView.showError();
                    }
                });
    }
}
