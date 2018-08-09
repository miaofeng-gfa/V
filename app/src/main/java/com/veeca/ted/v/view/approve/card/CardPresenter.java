package com.veeca.ted.v.view.approve.card;

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

public class CardPresenter extends BasePresenterImpl<CardContract.View> implements CardContract.Presenter {

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
                        LogUtils.e("getUserInfo:" + userInfo.toString());
                        if (userInfo.isSuccess())
                            mView.showUserInfo(userInfo);
                        else mView.showUserError();
                    }
                });
    }

    @Override
    public void upV() {
        service.upV(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("upV:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e("upV:" + results.toString());
                        if (results.isSuccess()) mView.showV(results);
                        else mView.showError();
                    }
                });
    }

    @Override
    public void upCard(String IDCardName, String IDCard) {
        service.upCard(Constant.getUserId(), Constant.getToken(), IDCardName, IDCard)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("upCard:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e("upCard:" + results.toString());
                        if (results.isSuccess()) mView.showCard(results);
                        else mView.showError();
                    }
                });
    }

    @Override
    public void upAddress(String province) {
        service.upAddress(Constant.getUserId(), Constant.getToken(), province)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("upAddress:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e("upAddress:" + results.toString());
                        if (results.isSuccess()) mView.showAddress(results);
                        else mView.showError();
                    }
                });
    }
}
