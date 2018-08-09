package com.veeca.ted.v.view.bindweixin;

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

public class BindWeiXinPresenter extends BasePresenterImpl<BindWeiXinContract.View> implements BindWeiXinContract.Presenter {
    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void upUserPhoto(int type, String tcauthimgurl) {
        service.upUserPhoto(Constant.getUserId(), Constant.getToken(), type, tcauthimgurl)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("upUserPhoto:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showUserPhoto(results);
                    }
                });
    }
}
