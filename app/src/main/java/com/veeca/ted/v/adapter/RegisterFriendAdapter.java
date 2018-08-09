package com.veeca.ted.v.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.veeca.ted.v.R;
import com.veeca.ted.v.api.RetrofitHelper;
import com.veeca.ted.v.api.RetrofitService;
import com.veeca.ted.v.bean.RegisterFriend;
import com.veeca.ted.v.bean.mian.FriendsMoney;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.myclass.SelectDialog;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ted on 2017/11/20.
 */

public class RegisterFriendAdapter extends RecyclerView.Adapter<RegisterFriendAdapter.ViewHolder> {
    private Context context;
    public static List<RegisterFriend.DataBean> registerFriendLists = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("0.00");
    private String cpc;
    private Intent intent;
    WindowManager wm;
    private UserInfo userInfo;

    //记录之前播放的条目下标
    public int currentPosition = -1;
    public RegisterFriendAdapter(Context context) {
        this.context = context;
    }

    public void setTaskLists(List registerFriendLists) {
        this.registerFriendLists = registerFriendLists;

    }

    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    public void clear() {
        registerFriendLists.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        wm = (WindowManager) parent.getContext().getSystemService(Context.WINDOW_SERVICE);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_registerfriend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {

        return registerFriendLists.size();

    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final RegisterFriend.DataBean dataBean = registerFriendLists.get(position);

        holder.tvRegFriNum.setText("" + position);

        Glide.with(context)
                .load(dataBean.getHeadimgurl())
                .asBitmap()
                /*.centerCrop().into(new BitmapImageViewTarget(holder.ivRegFriPic) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                     circularBitmapDrawable.setCircular(true);
                    holder.ivRegFriPic.setImageDrawable(circularBitmapDrawable);
                }
            });*/
                .transform(new CircleTransform(context))
                .into(holder.ivRegFriPic);
        holder.tvRegFriCount.setText("");
        holder.tvRegFriName.setText(dataBean.getNickname());
        holder.tvRegFriMoney.setText("￥" + dataBean.getRes1());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RetrofitService service = RetrofitHelper.getInstance().getServer();
                service.getShareMoney(Constant.getUserId(), Constant.getToken(), dataBean.getPid())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<FriendsMoney>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(FriendsMoney friendsriendsMoney) {
                                approveDialog(friendsriendsMoney, dataBean);


                            }
                        });
            }
        });

    }

    private SelectDialog dialog_approve;
    private  GridView gv;
    private String[] titles;
    private  String[] images;
    private FriendsMoney friendsriendsMoney1;
    private void approveDialog(FriendsMoney friendsriendsMoney,RegisterFriend.DataBean dataBean) {

        this.friendsriendsMoney1 = friendsriendsMoney;
        dialog_approve = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.dialog_regfri, null);

        ImageView pic= viewDialog.findViewById(R.id.iv_regfir_picme);
        ImageView pic2 = viewDialog.findViewById(R.id.iv_regfir_pic2);
        TextView tvTa = viewDialog.findViewById(R.id.tv_dia_ta);
        TextView tvFir = viewDialog.findViewById(R.id.tv_dia_fri);
        TextView tvnamef = viewDialog.findViewById(R.id.tv_dia_namef);
        TextView  tvTopName = viewDialog.findViewById(R.id.tv_dia_topNa);
        final Button btTv = viewDialog.findViewById(R.id.bt_dia_ren);
        final Button btTvUn = viewDialog.findViewById(R.id.bt_dia_unren);
        gv = viewDialog.findViewById(R.id.gd_dia);
        gv.setOverScrollMode(View.OVER_SCROLL_NEVER);


        btTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btTv.setBackground(context.getResources().getDrawable(R.mipmap.qun_btn));
                btTv.setTextColor(context.getResources().getColor(R.color.font_bottom_color));
                btTvUn.setBackground(context.getResources().getDrawable(R.mipmap.qun_btn_n));
                btTvUn.setTextColor(context.getResources().getColor(R.color.white));
                List<FriendsMoney.DataBean> fmr = friendsriendsMoney1.getRegisterList();
                titles = new String[fmr.size()];
                images = new String[fmr.size()];
                if (fmr != null) {
                    for (int i = 0; i < fmr.size(); i++) {
                        titles[i] = fmr.get(i).getNickname();
                        images[i] = fmr.get(i).getHeadimgurl();
                    }

                    PictureAdapter pictureAdapter = new PictureAdapter(titles, images, context);
                    gv.setAdapter(pictureAdapter);
                }


            }
        });
        btTvUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btTv.setBackground(context.getResources().getDrawable(R.mipmap.qun_btn_n));
                btTv.setTextColor(context.getResources().getColor(R.color.white));
                btTvUn.setBackground(context.getResources().getDrawable(R.mipmap.qun_btn));
                btTvUn.setTextColor(context.getResources().getColor(R.color.font_bottom_color));
                List<FriendsMoney.DataBean> fmrnot = friendsriendsMoney1.getNotRegisterList();
                titles = new String[fmrnot.size()];
                images = new String[fmrnot.size()];
                if (fmrnot != null) {
                    for (int i = 0; i < fmrnot.size(); i++) {
                        titles[i] = fmrnot.get(i).getNickname();
                        images[i] = fmrnot.get(i).getHeadimgurl();
                    }

                    PictureAdapter2 pictureAdapter2 = new PictureAdapter2(titles, images, context);
                    gv.setAdapter(pictureAdapter2);
                }


            }
        });


        List<FriendsMoney.DataBean> fmr = friendsriendsMoney.getRegisterList();
        titles = new String[fmr.size()];
        images = new String[fmr.size()];
        if (fmr != null) {
            for (int i = 0; i < fmr.size(); i++) {
                titles[i] = fmr.get(i).getNickname();
                images[i] = fmr.get(i).getHeadimgurl();
            }
        }


        PictureAdapter pictureAdapter = new PictureAdapter(titles, images, context);
        gv.setAdapter(pictureAdapter);
        titles = null;
        images = null;

        Glide.with(context).load(userInfo.getData().getHeadimgurl())
                .asBitmap()
                .transform(new CircleTransform(context))
                .into(pic);
        Glide.with(context)
                .load(dataBean.getHeadimgurl())
                .asBitmap()
                .transform(new CircleTransform(context))
                .into(pic2);


        viewDialog.findViewById(R.id.iv_top_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog_approve.dismiss();
            }
        });
        tvTopName.setText(dataBean.getNickname());
        tvTa.setText("" + friendsriendsMoney.getSetScale());
        tvFir.setText(dataBean.getRes1());
        tvnamef.setText(dataBean.getNickname());
        btTv.setText("已经认领" + friendsriendsMoney.getCount1() + "人");
        btTvUn.setText("未认领" + friendsriendsMoney.getCount2() + "人");


        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_approve.setContentView(viewDialog, layoutParams);
        dialog_approve.show();


    }


    public void setPlayPosition(int position) {
        currentPosition = position;
    }



    static class ViewHolder extends RecyclerView.ViewHolder {

      @BindView(R.id.tv_regfri_num)
      TextView tvRegFriNum;
      @BindView(R.id.iv_regfir_pic)
      ImageView ivRegFriPic;
      @BindView(R.id.tv_regfir_name)
      TextView tvRegFriName;
      @BindView(R.id.tv_regfir_count)
      TextView tvRegFriCount;
      @BindView(R.id.tv_regfir_money)
      TextView tvRegFriMoney;



        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public static class CircleTransform extends BitmapTransformation {
        public CircleTransform(Context context) {
            super(context);
        }

        @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override public String getId() {
            return getClass().getName();
        }
    }
}
