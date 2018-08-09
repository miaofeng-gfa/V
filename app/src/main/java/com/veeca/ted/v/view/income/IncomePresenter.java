package com.veeca.ted.v.view.income;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.FriendMoney;
import com.veeca.ted.v.bean.RewardMoney;
import com.veeca.ted.v.bean.SumMoney;
import com.veeca.ted.v.bean.Syt;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.mian.Buy;
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

public class IncomePresenter extends BasePresenterImpl<IncomeContract.View> implements IncomeContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getMoney() {
        service.getRewardMoney(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RewardMoney>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRewardMoney:" + e.toString());
                    }

                    @Override
                    public void onNext(RewardMoney money) {
                        if (money.isSuccess()) mView.showMoney(money);
                    }
                });
    }

    @Override
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
                        if (money.isSuccess()) mView.showProfit(money);
                    }
                });
    }

    @Override
    public void getBuy() {
        service.getBuy(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Buy>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBuy:" + e.toString());
                    }

                    @Override
                    public void onNext(Buy buy) {
                        if (buy.isSuccess()) mView.showBuy(buy);
                    }
                });
    }

    @Override
    public void getSumMoney() {
        service.getSumMoney(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SumMoney>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getSumMoney:" + e.toString());
                    }

                    @Override
                    public void onNext(SumMoney sumMoney) {
                        if (sumMoney.isSuccess()) mView.showSumMoney(sumMoney);
                    }
                });
    }

    @Override
    public void getUsableMoney() {
        service.getUsableMoney(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UsableMoney>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getUsableMoney:" + e.toString());
                    }

                    @Override
                    public void onNext(UsableMoney usableMoney) {
                        if (usableMoney.isSuccess()) mView.showUsableMoney(usableMoney);
                    }
                });
    }

    @Override
    public void getSyt7() {
        service.getSyt7(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Syt>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getSyt7:" + e.toString());
                    }

                    @Override
                    public void onNext(Syt syt) {
                        if (syt.isSuccess()) mView.showSyt7(syt);
                    }
                });
    }

    @Override
    public void getSyt30() {
        service.getSyt30(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Syt>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getSyt30:" + e.toString());
                    }

                    @Override
                    public void onNext(Syt syt) {
                        if (syt.isSuccess()) mView.showSyt30(syt);
                    }
                });
    }
}
