package com.veeca.ted.v.view.noregisterfriend;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.NoRegisterFriend;
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

public class NoRegisterFriendPresenter extends BasePresenterImpl<NoRegisterFriendContract.View> implements NoRegisterFriendContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    public void getNotRegisterFriend(int page) {
//        service.getNotRegisterFriend(Constant.getUserId(), Constant.getToken(),page)
        service.getNotRegisterFriend("304", "8cf20e62-0332-4c22-8067-6c5f217bf258",page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoRegisterFriend>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRegisterFriend:" + e.toString());
                    }

                    @Override
                    public void onNext(NoRegisterFriend noRegisterFriend) {
                        mView.showNotRegisterFriend(noRegisterFriend);
                    }
                });
    }


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
                        if (userInfo.isSuccess()){
                            mView.showUserInfo(userInfo);
                        }


                    }
                });
    }

}
