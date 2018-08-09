package com.veeca.ted.v.view.video;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.VideoPlayListAdatper;
import com.veeca.ted.v.bean.Goods;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.VideoCode;
import com.veeca.ted.v.bean.VideoPlayerItemInfo;
import com.veeca.ted.v.bean.VideoUrl;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.myclass.SelectDialog;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.MediaHelper;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.login.LoginActivity;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;
import com.veeca.ted.v.widget.RecycleViewDivider;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VideoFragment extends MVPBaseFragment<VideoContract.View, VideoPresenter> implements VideoContract.View, VideoPlayListAdatper.IControl {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    private List<VideoPlayerItemInfo.DataBean> dataBeans = new ArrayList<>();
    private LinearLayoutManager lm;
    private VideoPlayListAdatper adapter;
    private Context context;
    private int page, shareState, pid, vid;
    private Goods goods;
    private VideoCode videoCode;
    private VideoUrl videoUrl;
    private int lastVisibleItem;
    private int userState;
    private SelectDialog dialog_login, codeDialog;
    private Dialog dialog_goods;
    private Intent intent;
    private UMWeb circleWeb;
    //    private int isShare = 0;
    private DecimalFormat df = new DecimalFormat("0.00");
    private Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_list, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        mActivity = getActivity();
        userState = Constant.getUserState();
        page = 0;
        initRecyclerView();
        mPresenter.getVideos(page);
        return view;
    }

    private void initRecyclerView() {
        //初始化RecyclerView
        lm = new LinearLayoutManager(context);
        recycler.setLayoutManager(lm);

        swipe.setColorSchemeResources(R.color.yellow);
        swipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                dataBeans.clear();
                mPresenter.getVideos(page);
            }
        });

        // 添加分割线
        recycler.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.HORIZONTAL, 12, context.getResources().getColor(R.color.font_bottom_color)));

        adapter = new VideoPlayListAdatper(context);
        adapter.setControl(this);
        recycler.setAdapter(adapter);
        //设置滑动监听
        recycler.addOnScrollListener(onScrollListener);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_DRAGGING)
                if (lastVisibleItem + 2 >= lm.getItemCount()) {
                    page++;
                    mPresenter.getVideos(page);
//                    swipe.setRefreshing(true);
                }
        }

        //进行滑动
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            //获取屏幕上显示的第一个条目和最后一个条目的下标
            int firstVisibleItemPosition = lm.findFirstVisibleItemPosition();
            int lastVisibleItemPosition = lm.findLastVisibleItemPosition();
            lastVisibleItem = lm.findLastVisibleItemPosition();
            //获取播放条目的下标
            int currentPosition = adapter.currentPosition;
            if ((firstVisibleItemPosition > currentPosition || lastVisibleItemPosition < currentPosition) && currentPosition > -1) {
                //让播放隐藏的条目停止
                MediaHelper.release();
                adapter.currentPosition = -1;
                adapter.notifyDataSetChanged();
            }
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showVideos(VideoPlayerItemInfo info) {
        if (page == 0) swipe.setRefreshing(false);
        if (info.isSuccess()) {
            dataBeans.addAll(info.getData());
            adapter.setVideoPlayerItemInfoList(dataBeans);
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 登录弹窗
     *
     * @author TED
     * created at 2017/11/15 19:08
     */
    private void loginDialog() {
        dialog_login = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.dialog_login, null);
        viewDialog.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_login.dismiss();
            }
        });
        viewDialog.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, LoginActivity.class);
                intent.putExtra("resultCode", 11);
                startActivityForResult(intent, 11);
                dialog_login.dismiss();
            }
        });
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_login.setContentView(viewDialog, layoutParams);
        dialog_login.show();
    }

    /**
     * 分享弹窗
     *
     * @author TED
     * created at 2017/12/13 14:31
     */
    private void goodsDialog(final Goods goods) {
        this.goods = goods;
        dialog_goods = new Dialog(context, R.style.BottomDialog);
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_goods, null);
        dialog_goods.setContentView(contentView);
        contentView.findViewById(R.id.goods_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_goods.dismiss();
//                if (isShare == 1) mPresenter.getCodeSuccess(pid, vid);
            }
        });
        Glide.with(context).load(goods.getData().getImg()).bitmapTransform(new RoundedCornersTransformation(context, 8, 0,
                RoundedCornersTransformation.CornerType.ALL)).into((ImageView) contentView.findViewById(R.id.goods_image));
        ((TextView) contentView.findViewById(R.id.goods_title)).setText(goods.getData().getTitle());
        ((TextView) contentView.findViewById(R.id.goods_money)).setText("¥" + goods.getData().getSellPrice());
        ((TextView) contentView.findViewById(R.id.goods_old)).setText("¥" + goods.getData().getOffPrice());
        ((TextView) contentView.findViewById(R.id.goods_old)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        ((TextView) contentView.findViewById(R.id.goods_min)).setText(goods.getData().getSellPoints());
        ((TextView) contentView.findViewById(R.id.goods_text_left)).setText("最高购买率 " + df.format(goods.getData().getBuyPer() * 100.0) + "%");
        ((TextView) contentView.findViewById(R.id.goods_text_right)).setText("销量 " + goods.getData().getSales());
        ((TextView) contentView.findViewById(R.id.text_title)).setText("分享赚 ¥" + df.format(goods.getData().getContPrice()));
        ((TextView) contentView.findViewById(R.id.text_content)).setText("您将获得“卖手分红” ¥" + df.format(goods.getData().getContPrice()));
        contentView.findViewById(R.id.goods_wx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareState = 1;
                mPresenter.getVideoUrl(goods.getData().getVid());
            }
        });
        contentView.findViewById(R.id.goods_circle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareState = 2;
                mPresenter.getVideoUrl(goods.getData().getVid());
            }
        });
        contentView.findViewById(R.id.goods_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareState = 3;
                mPresenter.getVideoCode(goods.getData().getVid());
            }
        });

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(params);
        dialog_goods.getWindow().setGravity(Gravity.BOTTOM);
        dialog_goods.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        dialog_goods.show();
    }

    /**
     * 二维码弹窗
     *
     * @author TED
     * created at 2017/12/13 14:32
     */
    private void codeDialog() {
        codeDialog = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View viewDialog = inflater.inflate(R.layout.dialog_code, null);

        Glide.with(context).load(videoCode.getData().getCover()).bitmapTransform(new RoundedCornersTransformation(context, 8, 0,
                RoundedCornersTransformation.CornerType.TOP)).into((ImageView) viewDialog.findViewById(R.id.code_bg));
        Glide.with(context).load(videoCode.getData().getHeadImgUrl()).into((ImageView) viewDialog.findViewById(R.id.code_avatar));
        Glide.with(context).load(goods.getData().getImg()).into((ImageView) viewDialog.findViewById(R.id.goods_image));
        ((TextView) viewDialog.findViewById(R.id.code_title)).setText(videoCode.getData().getTitle());
        ((TextView) viewDialog.findViewById(R.id.goods_title)).setText(goods.getData().getTitle());
        ((TextView) viewDialog.findViewById(R.id.goods_money)).setText("¥" + goods.getData().getSellPrice());
        ((TextView) viewDialog.findViewById(R.id.goods_old)).setText("¥" + goods.getData().getOffPrice());
        ((TextView) viewDialog.findViewById(R.id.goods_old)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        ((TextView) viewDialog.findViewById(R.id.goods_min)).setText(goods.getData().getSellPoints());
        ((TextView) viewDialog.findViewById(R.id.goods_text_left)).setText("最高购买率 " + df.format(goods.getData().getBuyPer() * 100.0) + "%");
        ((TextView) viewDialog.findViewById(R.id.goods_text_right)).setText("销量 " + goods.getData().getSales());
        ((TextView) viewDialog.findViewById(R.id.code_name)).setText(videoCode.getData().getNickName());
        ((TextView) viewDialog.findViewById(R.id.code_buy)).setText(df.format(videoCode.getData().getBuyPer() * 100.0) + "%");
        ((TextView) viewDialog.findViewById(R.id.code_see)).setText("" + videoCode.getData().getPlayNum());
        ((TextView) viewDialog.findViewById(R.id.code_share)).setText("" + videoCode.getData().getTranspond());
        BitmapDrawable bmpDraw = new BitmapDrawable(encodeAsBitmap(videoUrl.getData().getUrl()));
        ImageView imageView = viewDialog.findViewById(R.id.code);
        imageView.setBackground(bmpDraw);
        viewDialog.findViewById(R.id.code_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codeDialog.dismiss();
            }
        });

        viewDialog.findViewById(R.id.code_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadUtil.showLoad(mActivity);
                //发送到朋友圈
                viewDialog.findViewById(R.id.relative).setDrawingCacheEnabled(true);
                Bitmap thumbBmp = getViewBitmap(viewDialog.findViewById(R.id.relative));
                if (thumbBmp != null) {
                    mPresenter.getCodeSuccess(pid, vid);
                    UMImage image = new UMImage(getActivity(), thumbBmp);//bitmap文件
                    new ShareAction(getActivity()).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(shareListener).withMedia(image).share();
                } else {
                    LoadUtil.hideLoad();
                    ToastUtils.setToast("二维码生成失败");
                }
                // 拷贝图片，否则在setDrawingCacheEnabled(false)以后该图片会被释放掉
                viewDialog.findViewById(R.id.relative).setDrawingCacheEnabled(false);
            }
        });
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        codeDialog.setContentView(viewDialog, layoutParams);
        codeDialog.show();
        LoadUtil.hideLoad();
    }

    public static Bitmap getViewBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }


    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
//            isShare = 1;
            LoadUtil.hideLoad();
            LogUtils.e(vid + ":" + pid);
            ToastUtils.setToast("分享成功");
            LogUtils.e("分享成功的回调");
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            ToastUtils.setToast("分享失败");
            LoadUtil.hideLoad();
            LogUtils.e("分享失败的回调");
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            ToastUtils.setToast("分享取消");
            LoadUtil.hideLoad();
            LogUtils.e("分享取消");
        }
    };


    /**
     * ZXing 二维码
     *
     * @author TED
     * created at 2017/9/30 11:26
     */
    private Bitmap encodeAsBitmap(String str) {
        Bitmap bitmap = null;
        BitMatrix result = null;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.MARGIN, 0);   //设置白边
        try {
            result = multiFormatWriter.encode(str, BarcodeFormat.QR_CODE, 360, 360, hints);
            // 使用 ZXing Android Embedded 要写的代码
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae) { // ?
            return null;
        }
        return bitmap;
    }


    @Override
    public void showGoods(Goods goods) {
        LoadUtil.hideLoad();
        if (goods.isSuccess()) {
            goodsDialog(goods);
        }
    }

    @Override
    public void showVideoCode(VideoCode videoCode) {
        this.videoCode = videoCode;
        if (videoCode.isSuccess()) mPresenter.getVideoUrl(goods.getData().getVid());
    }

    @Override
    public void showVideoUrl(VideoUrl videoUrl) {
        this.videoUrl = videoUrl;
        if (videoUrl.isSuccess()) {
            circleWeb = new UMWeb(videoUrl.getData().getUrl());
            circleWeb.setTitle(videoUrl.getData().getTitle());//标题
            UMImage image = new UMImage(context, videoUrl.getData().getCover());//网络图片
            circleWeb.setThumb(image);  //缩略图
            circleWeb.setDescription(videoUrl.getData().getSubTitle());
            switch (shareState) {
                case 1:
                    LoadUtil.showLoad(mActivity);
                    mPresenter.getCodeSuccess(pid, vid);
                    new ShareAction((Activity) context).setPlatform(SHARE_MEDIA.WEIXIN).setCallback(shareListener)
                            .withMedia(circleWeb)
                            .share();
                    break;
                case 2:
                    LoadUtil.showLoad(mActivity);
                    mPresenter.getCodeSuccess(pid, vid);
                    new ShareAction(getActivity()).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(shareListener)
                            .withMedia(circleWeb)
                            .share();
                    break;
                case 3:
                    LoadUtil.showLoad(mActivity);
                    codeDialog();
                    break;
            }
        }
    }

    @Override
    public void showCodeSuccess(Results results) {
        LogUtils.e(results.toString());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == 11) {
            userState = Constant.getUserState();
        }
    }

    @Override
    public void itemClick(int pid, int vid) {
        if (userState == 1) {
            this.pid = pid;
            this.vid = vid;
            LoadUtil.showLoad(mActivity);
            mPresenter.getGoods(vid);
        } else loginDialog();
    }
}
