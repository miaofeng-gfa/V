package com.veeca.ted.v.view.bindphone;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.BasePresenterImpl;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindPhonePresenter extends BasePresenterImpl<BindPhoneContract.View> implements BindPhoneContract.Presenter {
    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getCode(String phone) {
        service.getCode(phone)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getCode:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showCode(results);
                    }
                });
    }

    @Override
    public void getPhone(String phone, String code) {
        service.getPhone( phone, code)
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
                        mView.showPhone(results);
                    }
                });
    }
}
