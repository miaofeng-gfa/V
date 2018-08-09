package com.veeca.ted.v.view.video;

import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.Goods;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.VideoCode;
import com.veeca.ted.v.bean.VideoPlayerItemInfo;
import com.veeca.ted.v.bean.VideoUrl;
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

public class VideoPresenter extends BasePresenterImpl<VideoContract.View> implements VideoContract.Presenter {

    private RetrofitService service = RetrofitHelper.getInstance().getServer();

    @Override
    public void getVideos(int page) {
        service.getVideos(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoPlayerItemInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVideos:" + e.toString());
                    }

                    @Override
                    public void onNext(VideoPlayerItemInfo info) {
                        mView.showVideos(info);
                    }
                });
    }

    @Override
    public void getGoods(int vid) {
        service.getGoods(vid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Goods>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getGoods:" + e.toString());
                    }

                    @Override
                    public void onNext(Goods goods) {
                        mView.showGoods(goods);
                    }
                });
    }

    @Override
    public void getVideoCode(int vid) {
        service.getVideoCode(vid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoCode>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVideoCode:" + e.toString());
                    }

                    @Override
                    public void onNext(VideoCode videoCode) {
                        mView.showVideoCode(videoCode);
                    }
                });
    }

    @Override
    public void getVideoUrl(int vid) {
        service.getVideoUrl(Constant.getUserId(), Constant.getToken(), vid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoUrl>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getVideoUrl:" + e.toString());
                    }

                    @Override
                    public void onNext(VideoUrl videoUrl) {
                        mView.showVideoUrl(videoUrl);
                    }
                });
    }

    @Override
    public void getCodeSuccess(int pid, int vid) {
        service.getCodeSuccess(Constant.getUserId(), pid, vid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getCodeSuccess:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        mView.showCodeSuccess(results);
                    }
                });
    }

    @Override
    public void getPlay(int vid) {
        service.getplay(vid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Results>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getplay:" + e.toString());
                    }

                    @Override
                    public void onNext(Results results) {
                        LogUtils.e(results.toString());
                    }
                });
    }
}
