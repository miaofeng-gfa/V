package com.veeca.ted.v.view.buy;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.VideoBuy;
import com.veeca.ted.v.bean.VideoSee;
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

public class BuyPresenter extends BasePresenterImpl<BuyContract.View> implements BuyContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getVideoSee(int page) {
        service.getVideoSee(Constant.getUserId(), Constant.getToken(), page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoSee>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVideoSee:" + e.toString());
                    }

                    @Override
                    public void onNext(VideoSee videoSee) {
                        mView.showVideoSee(videoSee);
                    }
                });
    }

    @Override
    public void getVideoBuy(int page) {
        service.getVideoBuy(Constant.getUserId(), Constant.getToken(), page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBuy>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVideoBuy:" + e.toString());
                    }

                    @Override
                    public void onNext(VideoBuy videoBuy) {
                        mView.showVideoBuy(videoBuy);
                    }
                });
    }
}
