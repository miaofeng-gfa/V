package com.veeca.ted.v.view.community;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.QunList;
import com.veeca.ted.v.bean.QunTags;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.VLists;
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

public class CommunityPresenter extends BasePresenterImpl<CommunityContract.View> implements CommunityContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getV() {
        service.getV()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VLists>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getV:" + e.toString());
                    }

                    @Override
                    public void onNext(VLists vLists) {
                        if (vLists.isSuccess()) mView.showV(vLists);
                        else mView.showError();
                    }
                });
    }

    @Override
    public void getQun(String id, final int page, int sign) {
        service.getQun(id, page, 10, 1, sign)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QunList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getQun:" + e.toString());
                    }

                    @Override
                    public void onNext(QunList qunList) {
                        if (qunList.isSuccess()) mView.showQun(qunList);
                        else mView.showError();
                    }
                });

    }

    @Override
    public void getQunTags() {
        service.getQunTags()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QunTags>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getQunTags:" + e.toString());
                    }

                    @Override
                    public void onNext(QunTags qunTags) {
                        if (qunTags.isSuccess()) mView.showQunTags(qunTags);
                        else mView.showError();
                    }
                });
    }

    @Override
    public void getJoinQun(final int state, int fid, double money, String wx, final int sign, final int free) {
        service.getJoinQun(Constant.getUserId(), Constant.getToken(), fid, money, wx, sign, free)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getJoinQun:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showJoinQun(state, results);
                    }
                });
    }

    @Override
    public void getUsableMoney(final int i) {
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
                        mView.showUsableMoney(i, usableMoney);
                    }
                });
    }
}
