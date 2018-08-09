package com.veeca.ted.v.view.main;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.Version;
import com.veeca.ted.v.bean.mian.Income;
import com.veeca.ted.v.bean.mian.Sign;
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

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getVersion() {
        service.getNewVersion(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Version>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getNewVersion:" + e.toString());
                    }

                    @Override
                    public void onNext(Version version) {
                        mView.showVersion(version);
                    }
                });
    }

    @Override
    public void getSign() {
        service.getSign(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Sign>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getSign:" + e.toString());
                    }

                    @Override
                    public void onNext(Sign sign) {
                        if (sign.isSuccess())
                            mView.showSign(sign);
                        else
                            LogUtils.e("getSign:" + sign.getMsg());
                    }
                });
    }

    @Override
    public void getSignSuccess(int gisign, int ginum, int inum) {
        service.getSignSuccess(Constant.getUserId(), Constant.getToken(), gisign, ginum, inum)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getSignSuccess:" + e.toString());

                    }

                    @Override
                    public void onNext(Results results) {
                        if (results.isSuccess())
                            mView.showSignSuccess(results);
                        else
                            mView.showError();
                    }
                });
    }

    @Override
    public void getMainIncome() {
        service.getMainIncome(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Income>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getMainIncome:" + e.toString());
                    }

                    @Override
                    public void onNext(Income income) {
                        if (income.isSuccess())
                            mView.showMainIncome(income);
                        else
                            mView.showError();
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
                        if (userInfo.isSuccess()) mView.showUserInfo(userInfo);
                        else mView.showError();
                    }
                });
    }
}
