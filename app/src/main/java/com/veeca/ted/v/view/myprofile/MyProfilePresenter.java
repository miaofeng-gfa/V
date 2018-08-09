package com.veeca.ted.v.view.myprofile;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.Circle;
import com.veeca.ted.v.bean.mian.Like;
import com.veeca.ted.v.bean.mian.UserCircle;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.bean.mian.UserLike;
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

public class MyProfilePresenter extends BasePresenterImpl<MyProfileContract.View> implements MyProfileContract.Presenter {

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
                        mView.showUserInfo(userInfo);
                    }
                });
    }

    @Override
    public void getUserLike() {
        service.getUserLike(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserLike>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getUserLike:" + e.toString());
                    }

                    @Override
                    public void onNext(UserLike userLike) {
                        mView.showLike(userLike);
                    }
                });
    }

    @Override
    public void getUserCircle() {
        service.getUserCircle(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserCircle>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getUserCircle:" + e.toString());
                    }

                    @Override
                    public void onNext(UserCircle userCircle) {
                        mView.showCircle(userCircle);
                    }
                });
    }

    @Override
    public void getMyProfile(String headimhurl, String nickname, String province, String labelIds, String circleIds) {
        service.getMyProfile(Constant.getUserId(), Constant.getToken(), headimhurl, nickname, province, labelIds, circleIds)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getMyProfile:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showMyProfile(results);
                    }
                });
    }

    @Override
    public void getApproveCircle() {
        service.getApproveCircle(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Circle>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getApproveCircle:" + e.toString());
                    }

                    @Override
                    public void onNext(Circle circle) {
                        mView.showApproveCircle(circle);
                    }
                });
    }

    @Override
    public void getApproveLike() {
        service.getApproveLike(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Like>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getApproveLike:" + e.toString());
                    }

                    @Override
                    public void onNext(Like like) {
                        mView.showApproveLike(like);
                    }
                });
    }
}
