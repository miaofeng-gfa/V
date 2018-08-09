package com.veeca.ted.v.view.my;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
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

public class MyPresenter extends BasePresenterImpl<MyContract.View> implements MyContract.Presenter {
    private RetrofitService service = RetrofitHelper.getInstance().getServer();

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
                        LogUtils.e(userInfo.toString());
                        if (userInfo.isSuccess())
                            mView.showUserInfo(userInfo);
                        else
                            mView.showError();
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
}
