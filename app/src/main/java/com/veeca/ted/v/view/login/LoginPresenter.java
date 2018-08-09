package com.veeca.ted.v.view.login;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Login;
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

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

//    @Override
//    public void getCode(String phone) {
//        service.getCode(phone)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Results>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtils.e("getCode:" + e.toString());
//                    }
//
//                    @Override
//                    public void onNext(Results results) {
//                        if (results.isSuccess())
//                            ToastUtils.setToast("发送成功");
//                        else
//                            ToastUtils.setToast("发送失败");
//                    }
//                });
//    }
//    @Override
//    public void login(String phone, String code) {
//        service.login(phone, code, null)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Login>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtils.e("login:" + e.toString());
//                    }
//
//                    @Override
//                    public void onNext(Login login) {
//                        LogUtils.e(login.toString());
//                        if (login.isSuccess())
//                            mView.loginSuccess(login);
//                        else
//                            ToastUtils.setToast("登录失败");
//                    }
//                });
//    }

    @Override
    public void getLogin(String headimgurl, String nickname, int sex, String country, String province, String city, String openid, String unionid) {
        service.login(headimgurl, nickname, sex, country, province, city, openid, unionid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Login>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("login:" + e.toString());
                    }

                    @Override
                    public void onNext(Login login) {
                        mView.showLogin(login);
                    }
                });
    }

    @Override
    public void getProperties() {
        service.getProperties(Constant.getUserId(), Constant.getToken())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
