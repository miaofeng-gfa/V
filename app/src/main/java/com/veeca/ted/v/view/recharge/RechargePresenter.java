package com.veeca.ted.v.view.recharge;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Recharge;
import com.veeca.ted.v.bean.UsableMoney;
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

public class RechargePresenter extends BasePresenterImpl<RechargeContract.View> implements RechargeContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getRecharge(double money) {
        service.getRecharge(Constant.getUserId(), Constant.getToken(), money)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Recharge>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRecharge:" + e.toString());
                    }

                    @Override
                    public void onNext(Recharge recharge) {
                        if (recharge.isSuccess()) mView.showRecharge(recharge);
                        else mView.showError();
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
                        else mView.showError();
                    }
                });
    }
}
