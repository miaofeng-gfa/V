package com.veeca.ted.v.view.circledetails;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.CircleData;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.BasePresenterImpl;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CircleDetailsPresenter extends BasePresenterImpl<CircleDetailsContract.View> implements CircleDetailsContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getCircleData(int scid) {
        service.getCircleData(scid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CircleData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getCircleData:" + e.toString());
                    }

                    @Override
                    public void onNext(CircleData circleData) {
                        if (circleData.isSuccess()) mView.showCircleData(circleData);
                        else mView.showError();
                    }
                });
    }
}
