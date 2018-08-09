package com.veeca.ted.v.view.incomedetails;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.MyWithdraw;
import com.veeca.ted.v.bean.mian.MyMoney;
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

public class IncomeDetailsPresenter extends BasePresenterImpl<IncomeDetailsContract.View> implements IncomeDetailsContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getMyMoneyList(int page) {
        service.getMyMoneyList(Constant.getUserId(), Constant.getToken(), page, 10)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyMoney>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getMyMoneyList:" + e.toString());
                    }

                    @Override
                    public void onNext(MyMoney myMoney) {
                        if (myMoney.isSuccess()) mView.showMyMoneyList(myMoney);
                        else mView.showError();
                    }
                });
    }

    @Override
    public void getMyWithdrawList(int page) {
        service.getMyWithdrawList(Constant.getUserId(), Constant.getToken(), page, 10)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyWithdraw>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getMyWithdrawList:" + e.toString());
                    }

                    @Override
                    public void onNext(MyWithdraw myWithdraw) {
                        if (myWithdraw.isSuccess()) mView.showMyWithdrawList(myWithdraw);
                        else mView.showError();
                    }
                });
    }
}
