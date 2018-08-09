package com.veeca.ted.v.view.influence;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.ContactBean;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserBind;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.utils.ContactUtil;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.bindaccount.BindaccountActivity;
import com.veeca.ted.v.view.bindweixin.BindWeiXinActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.widget.CircleImageView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class InfluenceActivity extends MVPBaseActivity<InfluenceContract.View, InfluencePresenter> implements InfluenceContract.View {

    @BindView(R.id.my_influence)
    TextView myInfluence;
    @BindView(R.id.influence_weixin_avatar)
    CircleImageView influenceWeixinAvatar;
    @BindView(R.id.influence_weixin_name)
    TextView influenceWeixinName;
    @BindView(R.id.weixin_state)
    TextView weixinState;
    @BindView(R.id.influence_weibo_avatar)
    CircleImageView influenceWeiboAvatar;
    @BindView(R.id.influence_weibo_name)
    TextView influenceWeiboName;
    @BindView(R.id.weibo_state)
    TextView weiboState;
    @BindView(R.id.influence_linear1)
    LinearLayout influenceLinear1;
    @BindView(R.id.influence_linear2)
    LinearLayout influenceLinear2;
    @BindViews({R.id.influence_3, R.id.influence_4, R.id.influence_5, R.id.influence_6,
            R.id.influence_7, R.id.influence_8, R.id.influence_9, R.id.influence_10, R.id.influence_11, R.id.influence_12, R.id.influence_13,
            R.id.influence_14, R.id.influence_15, R.id.influence_16, R.id.influence_17, R.id.influence_18, R.id.influence_19, R.id.influence_20})
    List<ImageView> imgInfluences;
    private Context context;
    private Intent intent;
    private int callLogRequestCode = 1;
    private int contactRequestCode = 2;
    private boolean flag = true;
    private int bind_id;
    private String name, avatar, fans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_influence);
        ButterKnife.bind(this);
        context = getContext();
    }

    //第三方的类型（0：微信 1：QQ 2：微博3:知乎4公众号5贴吧6豆瓣7京东8淘宝9秒拍10斗鱼11映客12天涯13美拍 14快手 15花椒 16陌陌 17NICE 18小红书 19领英）
    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.top_return, R.id.influence_linear1, R.id.influence_linear2, R.id.influence_3, R.id.influence_4, R.id.influence_5, R.id.influence_6, R.id.influence_7,
            R.id.influence_8, R.id.influence_9, R.id.influence_10, R.id.influence_11, R.id.influence_12, R.id.influence_13, R.id.influence_14,
            R.id.influence_15, R.id.influence_16, R.id.influence_17, R.id.influence_18, R.id.influence_19, R.id.influence_20, R.id.influence_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.influence_linear1:
                //todo 跳绑定微信图片
                intent = new Intent(context, BindWeiXinActivity.class);
                startActivity(intent);
                break;
            case R.id.influence_linear2:
                bind_id = 2;
                authorization(SHARE_MEDIA.SINA);
                break;
            case R.id.influence_3:
                bind_id = 1;
                authorization(SHARE_MEDIA.QQ);
                break;
            case R.id.influence_4:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定公众号");
                intent.putExtra("id", 4);
                startActivity(intent);
                break;
            case R.id.influence_5:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定豆瓣");
                intent.putExtra("id", 6);
                startActivity(intent);
                break;
            case R.id.influence_6:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定知乎");
                intent.putExtra("id", 3);
                startActivity(intent);
                break;
            case R.id.influence_7:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定百度贴吧");
                intent.putExtra("id", 5);
                startActivity(intent);
                break;
            case R.id.influence_8:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定淘宝");
                intent.putExtra("id", 8);
                startActivity(intent);
                break;
            case R.id.influence_9:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定京东");
                intent.putExtra("id", 7);
                startActivity(intent);
                break;
            case R.id.influence_10:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定天涯");
                intent.putExtra("id", 12);
                startActivity(intent);
                break;
            case R.id.influence_11:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定斗鱼");
                intent.putExtra("id", 10);
                startActivity(intent);
                break;
            case R.id.influence_12:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定美拍");
                intent.putExtra("id", 13);
                startActivity(intent);
                break;
            case R.id.influence_13:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定映客");
                intent.putExtra("id", 11);
                startActivity(intent);
                break;
            case R.id.influence_14:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定秒拍");
                intent.putExtra("id", 9);
                startActivity(intent);
                break;
            case R.id.influence_15:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定快手");
                intent.putExtra("id", 14);
                startActivity(intent);
                break;
            case R.id.influence_16:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定花椒");
                intent.putExtra("id", 15);
                startActivity(intent);
                break;
            case R.id.influence_17:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定陌陌");
                intent.putExtra("id", 16);
                startActivity(intent);
                break;
            case R.id.influence_18:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定NICE");
                intent.putExtra("id", 17);
                startActivity(intent);
                break;
            case R.id.influence_19:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定小红书");
                intent.putExtra("id", 18);
                startActivity(intent);
                break;
            case R.id.influence_20:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定领英");
                intent.putExtra("id", 19);
                startActivity(intent);
                break;
            case R.id.influence_btn:
                if (flag) {
                    flag = false;
                    boolean isReadContact = checkPermission(Manifest.permission.READ_CONTACTS);
                    if (isReadContact) {
                        requestPerssion(new String[]{Manifest.permission.READ_CONTACTS}, contactRequestCode);
                        LoadUtil.showLoad((Activity) context);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                readContact();
                            }
                        }).start();
                    } else {
                        new AlertDialog.Builder(context)
                                .setTitle("重要提示:")
                                .setMessage("无法访问通讯录将不能提升影响力!(通讯录信息只用于匹配好友,我们将严格保密您的个人信息)")
                                .setNegativeButton("取消", null)
                                .setCancelable(true)
                                .setPositiveButton("前往", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                                        intent.setData(uri);
                                        startActivityForResult(intent, callLogRequestCode);
                                    }
                                })
                                .show();
                        flag = true;
                    }
                }
                break;
        }
    }

    /**
     * 读取本机通讯录信息
     *
     * @throws Throwable
     */
    private void readContact() {
        flag = true;
        try {
            List<ContactBean> allContact = ContactUtil.getAllContact(context);
            //上传通讯录
            mPresenter.getPhoto(allContact.toString());

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //已经授权
        } else {
            //点击了不再提示,拒绝权限
            //跳转到设置界面
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivityForResult(intent, callLogRequestCode);
        }
    }

    //授权
    private void authorization(SHARE_MEDIA share_media) {
        UMShareAPI.get(context).getPlatformInfo(this, share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                LogUtils.e("onStart " + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                LogUtils.e("onComplete " + "授权完成");
                if (bind_id == 1)
                    mPresenter.upUserThird1(bind_id, map.get("name"), null, null, map.get("iconurl"));
                else {
                    name = map.get("name");
                    avatar = map.get("iconurl");
                    fans = map.get("followers_count");
                    mPresenter.upUserThird(bind_id, map.get("name"), map.get("iconurl"), map.get("followers_count"));
                }
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                LogUtils.e("onError " + "授权失败");
                ToastUtils.setToast("授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                LogUtils.e("onCancel " + "授权取消");
                ToastUtils.setToast("授权取消");
            }
        });
    }

    @Override
    public void showError() {
        LoadUtil.hideLoad();
        ToastUtils.setToast("网络异常");
    }

    @Override
    public void showUserBind(UserBind userBind) {
        if (userBind.getData() != null) {
            for (int j = 0; j < userBind.getData().size(); j++) {
                setBind(userBind.getData().get(j));
            }
        }
    }

    private void setBind(UserBind.DataBean dataBean) {
        switch (dataBean.getType()) {
            case 0://微信
                Glide.with(context).load(dataBean.getTcimg()).into(influenceWeixinAvatar);
                influenceWeixinName.setText(dataBean.getTcname());
                if (dataBean.getTcstate() == 0) {
                    weixinState.setText("上传");
                } else if (dataBean.getTcstate() == 1) {
                    influenceLinear1.setClickable(false);
                    weixinState.setText("审核中");
                } else if (dataBean.getTcstate() == 2) {
                    influenceLinear1.setClickable(false);
                    weixinState.setText(dataBean.getTcfans() + "");
                }
                break;
            case 1://QQ
                imgInfluences.get(0).setImageResource(R.mipmap.qq_c);
                imgInfluences.get(0).setClickable(false);
                break;
            case 2://微博
                influenceLinear2.setClickable(false);
                Glide.with(context).load(dataBean.getTcimg()).into(influenceWeiboAvatar);
                influenceWeiboName.setText(dataBean.getTcname());
                weiboState.setText(dataBean.getTcfans() + "");
                break;
            case 3://知乎
                imgInfluences.get(3).setImageResource(R.mipmap.zhihu_c);
                imgInfluences.get(3).setClickable(false);
                break;
            case 4://公众号
                imgInfluences.get(1).setImageResource(R.mipmap.gongzonghao_c);
                imgInfluences.get(1).setClickable(false);
                break;
            case 5://贴吧
                imgInfluences.get(4).setImageResource(R.mipmap.tieba_c);
                imgInfluences.get(4).setClickable(false);
                break;
            case 6://豆瓣
                imgInfluences.get(2).setImageResource(R.mipmap.douban_c);
                imgInfluences.get(2).setClickable(false);
                break;
            case 7://京东
                imgInfluences.get(6).setImageResource(R.mipmap.jingdong_c);
                imgInfluences.get(6).setClickable(false);
                break;
            case 8://淘宝
                imgInfluences.get(5).setImageResource(R.mipmap.taobao_c);
                imgInfluences.get(5).setClickable(false);
                break;
            case 9://秒拍
                imgInfluences.get(11).setImageResource(R.mipmap.miaopai_c);
                imgInfluences.get(11).setClickable(false);
                break;
            case 10://斗鱼
                imgInfluences.get(8).setImageResource(R.mipmap.douyu_c);
                imgInfluences.get(8).setClickable(false);
                break;
            case 12://天涯
                imgInfluences.get(7).setImageResource(R.mipmap.tianya_c);
                imgInfluences.get(7).setClickable(false);
                break;
            case 11://映客
                imgInfluences.get(10).setImageResource(R.mipmap.yingke_c);
                imgInfluences.get(10).setClickable(false);
                break;
            case 13://美拍
                imgInfluences.get(9).setImageResource(R.mipmap.meipai_c);
                imgInfluences.get(9).setClickable(false);
                break;
            case 14://快手
                imgInfluences.get(12).setImageResource(R.mipmap.kuaishou);
                imgInfluences.get(12).setClickable(false);
                break;
            case 15://花椒
                imgInfluences.get(13).setImageResource(R.mipmap.huajiao);
                imgInfluences.get(13).setClickable(false);
                break;
            case 16://陌陌
                imgInfluences.get(14).setImageResource(R.mipmap.momo);
                imgInfluences.get(14).setClickable(false);
                break;
            case 17://nice
                imgInfluences.get(15).setImageResource(R.mipmap.nice);
                imgInfluences.get(15).setClickable(false);
                break;
            case 18://小红书
                imgInfluences.get(16).setImageResource(R.mipmap.xiaohongshu);
                imgInfluences.get(16).setClickable(false);
                break;
            case 19://领英
                imgInfluences.get(17).setImageResource(R.mipmap.lingying);
                imgInfluences.get(17).setClickable(false);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadUtil.showLoad((Activity) context);
        mPresenter.getUserInfo();
        mPresenter.getUserBind();
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        LoadUtil.hideLoad();
        myInfluence.setText(userInfo.getData().getInfluence());
    }

    @Override
    public void showUserThird(Results results) {
        if (results.isSuccess()) {
            Glide.with(context).load(avatar).into(influenceWeiboAvatar);
            influenceWeiboName.setText(name);
            weiboState.setText(fans);
        } else ToastUtils.setToast("网络异常,请重新尝试");
    }

    @Override
    public void showUserThird1(Results results) {
        if (results.isSuccess()) {
            imgInfluences.get(0).setImageResource(R.mipmap.qq_c);
            imgInfluences.get(0).setClickable(false);
        } else ToastUtils.setToast("网络异常,请重新尝试");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @Override
    public void showPhoto() {
        ToastUtils.setToast("通讯录上传成功");
        mPresenter.getUserInfo();
    }
}
