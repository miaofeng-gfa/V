package com.veeca.ted.v.view.home;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.mian.AllCircle;
import com.veeca.ted.v.bean.mian.FriendCount;
import com.veeca.ted.v.bean.mian.HomeMoney;
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

public class HomePresenter extends BasePresenterImpl<HomeContract.View> implements HomeContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getMoney() {
        service.getMoney()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeMoney>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getMoney:" + e.toString());
                    }

                    @Override
                    public void onNext(HomeMoney homeMoney) {
                        if (homeMoney.isSuccess()) {
                            mView.showMoney(homeMoney);
                        } else
                            mView.showError();
                    }
                });
    }

    public void getFriendCounts(){

        service.getFriendCounts(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FriendCount>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getFriendCounts:" + e.toString());

                    }

                    @Override
                    public void onNext(FriendCount friendCount) {
                        LogUtils.e("getFriendCountspppp:" +friendCount.toString());
                        if (friendCount.isSuccess()) {
                            mView.showFriendCounts(friendCount);
                        } else
                            mView.showError();
                    }
                });
    }


    @Override
    public void getAllCircle() {
        service.getAllCircle(1)
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
                        if (allCircle.isSuccess()) {
                            mView.showAllCircle(allCircle);
                        } else
                            mView.showError();
                    }
                });
    }
}
