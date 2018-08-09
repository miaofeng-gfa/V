package com.veeca.ted.v.view.extract;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.IsFirstMoney;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.UserAllCard;
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

public class ExtractPresenter extends BasePresenterImpl<ExtractContract.View> implements ExtractContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getAllCard() {
        service.getAllCard(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserAllCard>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getAllCard:" + e.toString());
                    }

                    @Override
                    public void onNext(UserAllCard userAllCard) {
                        if (userAllCard.isSuccess()) mView.showAllCard(userAllCard);
                        else mView.showError();
                    }
                });
    }

    @Override
    public void getExtract(String amount) {
        service.getExtract(Constant.getUserId(), Constant.getToken(), amount)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        LogUtils.e("getExtract:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e("kkkkkkkkkkk"+results.toString());
                        if (results.isSuccess()) mView.showExtract(results);
                        else mView.showError();
                    }
                });
    }


    public void getCashWeiXin(String amount) {
        service.getCashWeiXin(Constant.getUserId(), Constant.getToken(), amount)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getCashWeiXin:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e("oooooooooo"+results.toString());
                        if (results.isSuccess()) mView.showExtract(results);
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

    @Override
    public void getIsTxAll() {
        service.isTxAll(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IsFirstMoney>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getUsableMoney:" + e.toString());
                    }

                    @Override
                    public void onNext(IsFirstMoney isfirstmoney) {
                        if (isfirstmoney.isSuccess()) mView.showIsTxAll(isfirstmoney);
                        else mView.showError();
                    }
                });
    }



}
