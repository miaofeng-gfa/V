package com.veeca.ted.v.view.vshow;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.VInfo;
import com.veeca.ted.v.bean.VLive;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.view.mvp.BasePresenterImpl;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VShowPresenter extends BasePresenterImpl<VShowContract.View> implements VShowContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getVInfo(int rid) {
        service.getVInfo(rid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVInfo:" + e.toString());
                    }

                    @Override
                    public void onNext(VInfo vInfo) {
                        mView.showVInfo(vInfo);
                    }
                });
    }

    @Override
    public void getVTag(int rid) {
        service.getVTag(rid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVTag:" + e.toString());
                    }

                    @Override
                    public void onNext(List<String> list) {
                        mView.showVTag(list);
                    }
                });
    }

    @Override
    public void getVLive(int rid) {
        service.getVLive(rid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<VLive>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVLive:" + e.toString());
                    }

                    @Override
                    public void onNext(List<VLive> vLives) {
                        mView.showVLive(vLives);
                    }
                });
    }

    @Override
    public void getReward(int uid, String money, String wxAccount, int rid, int num) {
        service.getReward(uid, money, wxAccount, rid, num)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getReward:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showReward(results);
                    }
                });
    }

    @Override
    public void getEngagement(int rsid, int rid, int uid, String shareUrl) {
        service.getEngagement(rsid, rid, uid, shareUrl)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getEngagement:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showEngagement(results);
                    }
                });
    }
}
