package com.veeca.ted.v.view.bindaccount;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
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

public class BindaccountPresenter extends BasePresenterImpl<BindaccountContract.View> implements BindaccountContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void upUserThird2(int type, String tcauthimgurl) {
        service.upUserThird2(Constant.getUserId(), Constant.getToken(), type, tcauthimgurl, null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("upUserThird2:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e(results.toString());
                        if (results.isSuccess())
                            mView.showThird(results);
                        else mView.showError();
                    }
                });
    }


}
