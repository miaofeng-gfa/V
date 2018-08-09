package com.veeca.ted.v.view.approve.account;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserBind;
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

public class AccountPresenter extends BasePresenterImpl<AccountContract.View> implements AccountContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getUserBind() {
        service.getUserBind(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBind>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getUserBind:" + e.toString());
                    }

                    @Override
                    public void onNext(UserBind userBind) {
                        if (userBind.isSuccess())
                            mView.showUserBind(userBind);
                        else
                            mView.showError();
                    }
                });
    }

    @Override
    public void getWX() {
        service.getWX(Constant.getUserId(), Constant.getToken(), 0)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getWX:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showWX(results);
                    }
                });
    }

    @Override
    public void upUserThird(int type, String name, String headimgurl, String fans) {
        service.upUserThird(Constant.getUserId(), Constant.getToken(), type, name, null, null, headimgurl, null, fans)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("upUserThird:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e(results.toString());
                        mView.showThird(results);
                    }
                });
    }

    @Override
    public void upUserThird1(int type, String name, String openid, String unionid, String headimgurl) {
        service.upUserThird1(Constant.getUserId(), Constant.getToken(), type, name, openid, unionid, headimgurl, null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("upUserThird1:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e(results.toString());
                        mView.showThird1(results);
                    }
                });
    }
}
