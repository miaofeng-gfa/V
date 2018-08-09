package com.veeca.ted.v.view.vadshare;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.FriMoneyThir;
import com.veeca.ted.v.bean.FriendMoney;
import com.veeca.ted.v.bean.mian.FriendCount;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.BasePresenterImpl;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018-03-17.
 */

public class VadSharePresenter extends BasePresenterImpl<VadShareContract.View> implements VadShareContract.Presenter{

    private RetrofitService service = RetrofitHelper.getInstance().getServer();




    public void getProfit() {
        service.getFriendMoney(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FriendMoney>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getFriendMoney:" + e.toString());
                    }

                    @Override
                    public void onNext(FriendMoney money) {
                        LogUtils.e("getFriendMoney:" + money.toString());
                        if (money.isSuccess()) mView.showProfit(money);
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
                        LogUtils.e("getFriendCountstttttt:" +friendCount.toString());
                        if (friendCount.isSuccess()) {
                            mView.showFriendCounts(friendCount);
                        }
                    }
                });
    }


    public void getFriendMoney30() {
        service.getFriendMoney30(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FriMoneyThir>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getFriendMoney30:" + e.toString());
                    }

                    @Override
                    public void onNext(FriMoneyThir fmt) {
                        mView.showFriendMoney30(fmt);
                    }
                });
    }

   /* public void getRegisterFriend(int page) {
        service.getRegisterFriend(Constant.getUserId(), Constant.getToken(),page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterFriend>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRegisterFriend:" + e.toString());
                    }

                    @Override
                    public void onNext(RegisterFriend registerFriend) {
                        mView.showRegisterFriend(registerFriend);
                    }
                });
    }*/

   /* public void getNotRegisterFriend(int page) {
        service.getNotRegisterFriend(Constant.getUserId(), Constant.getToken(),page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoRegisterFriend>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getNotRegisterFriend:" + e.toString());
                    }

                    @Override
                    public void onNext(NoRegisterFriend noRegisterFriend) {
                        mView.showNotRegisterFriend(noRegisterFriend);
                    }
                });
    }*/

}
