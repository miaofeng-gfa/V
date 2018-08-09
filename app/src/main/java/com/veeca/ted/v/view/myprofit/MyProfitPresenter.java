package com.veeca.ted.v.view.myprofit;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.mian.MyProfit;
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

public class MyProfitPresenter extends BasePresenterImpl<MyProfitContract.View> implements MyProfitContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getMyProfitList(int page) {
        service.getMyProfitList(Constant.getUserId(), Constant.getToken(), page, 20)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyProfit>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getMyProfitList:" + e.toString());
                    }

                    @Override
                    public void onNext(MyProfit myProfit) {
                        if (myProfit.isSuccess()) mView.showMyProfitList(myProfit);
                        else mView.showError();
                    }
                });
    }
}
