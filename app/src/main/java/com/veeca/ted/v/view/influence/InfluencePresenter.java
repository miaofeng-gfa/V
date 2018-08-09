package com.veeca.ted.v.view.influence;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserBind;
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

public class InfluencePresenter extends BasePresenterImpl<InfluenceContract.View> implements InfluenceContract.Presenter {

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
                        if (userInfo.isSuccess()) mView.showUserInfo(userInfo);
                        else mView.showError();
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
                        mView.showUserThird(results);
                    }
                });
    }

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
                        if (userBind.isSuccess()) mView.showUserBind(userBind);
                        else mView.showError();
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
                        mView.showUserThird1(results);
                    }
                });
    }


    @Override
    public void getPhoto(String jsonStr) {
        service.getPhone(Constant.getUserId(), Constant.getToken(), jsonStr)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getPhone:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        if (results.isSuccess()) mView.showPhoto();
                        else mView.showError();
                    }
                });
    }
}
