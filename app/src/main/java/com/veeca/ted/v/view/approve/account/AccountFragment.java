package com.veeca.ted.v.view.approve.account;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserBind;
import com.veeca.ted.v.eventbus.ApproveEventbus;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.approve.card.CardFragment;
import com.veeca.ted.v.view.bindaccount.BindaccountActivity;
import com.veeca.ted.v.view.bindweixin.BindWeiXinActivity;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AccountFragment extends MVPBaseFragment<AccountContract.View, AccountPresenter> implements AccountContract.View {

    @BindViews({R.id.account_1, R.id.account_2, R.id.account_3, R.id.account_4, R.id.account_5, R.id.account_6,
            R.id.account_7, R.id.account_8, R.id.account_9, R.id.account_10, R.id.account_11, R.id.account_12, R.id.account_13,
            R.id.account_14, R.id.account_15, R.id.account_16, R.id.account_17, R.id.account_18, R.id.account_19, R.id.account_20})
    List<ImageView> accounts;
    Unbinder unbinder;
    private Intent intent;
    private Context context;
    private int i, weixin, weibo, bind_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, null);
        unbinder = ButterKnife.bind(this, view);
        context = getActivity();
        i = weixin = weibo = 0;
        mPresenter.getUserBind();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.account_1, R.id.account_2, R.id.account_3, R.id.account_4, R.id.account_5, R.id.account_6, R.id.account_7,
            R.id.account_8, R.id.account_9, R.id.account_10, R.id.account_11, R.id.account_12, R.id.account_13, R.id.account_14,
            R.id.account_15, R.id.account_16, R.id.account_17, R.id.account_18, R.id.account_19, R.id.account_20, R.id.account_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.account_1:
                intent = new Intent(context, BindWeiXinActivity.class);
                startActivityForResult(intent, 232);
                break;
            case R.id.account_2:
                bind_id = 2;
                authorization(SHARE_MEDIA.SINA);
                break;
            case R.id.account_3:
                bind_id = 1;
                authorization(SHARE_MEDIA.QQ);
                break;
            case R.id.account_4:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定公众号");
                intent.putExtra("id", 4);
                startActivity(intent);
                break;
            case R.id.account_5:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定豆瓣");
                intent.putExtra("id", 6);
                startActivity(intent);
                break;
            case R.id.account_6:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定知乎");
                intent.putExtra("id", 3);
                startActivity(intent);
                break;
            case R.id.account_7:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定百度贴吧");
                intent.putExtra("id", 5);
                startActivity(intent);
                break;
            case R.id.account_8:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定淘宝");
                intent.putExtra("id", 8);
                startActivity(intent);
                break;
            case R.id.account_9:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定京东");
                intent.putExtra("id", 7);
                startActivity(intent);
                break;
            case R.id.account_10:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定天涯");
                intent.putExtra("id", 12);
                startActivity(intent);
                break;
            case R.id.account_11:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定斗鱼");
                intent.putExtra("id", 10);
                startActivity(intent);
                break;
            case R.id.account_12:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定美拍");
                intent.putExtra("id", 13);
                startActivity(intent);
                break;
            case R.id.account_13:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定映客");
                intent.putExtra("id", 11);
                startActivity(intent);
                break;
            case R.id.account_14:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定秒拍");
                intent.putExtra("id", 9);
                startActivity(intent);
                break;
            case R.id.account_15:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定快手");
                intent.putExtra("id", 14);
                startActivity(intent);
                break;
            case R.id.account_16:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定花椒");
                intent.putExtra("id", 15);
                startActivity(intent);
                break;
            case R.id.account_17:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定陌陌");
                intent.putExtra("id", 16);
                startActivity(intent);
                break;
            case R.id.account_18:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定NICE");
                intent.putExtra("id", 17);
                startActivity(intent);
                break;
            case R.id.account_19:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定小红书");
                intent.putExtra("id", 18);
                startActivity(intent);
                break;
            case R.id.account_20:
                intent = new Intent(context, BindaccountActivity.class);
                intent.putExtra("title", "绑定领英");
                intent.putExtra("id", 19);
                startActivity(intent);
                break;
            case R.id.account_btn:
                if (i >= 2 && weixin != 0 && weibo != 0) {
                    EventBus.getDefault().post(new ApproveEventbus(1));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.approve_frame, new CardFragment()).commit();
                } else if (weixin == 0) {
                    ToastUtils.setToast("微信为必选项!");
                } else if (weibo == 0) {
                    ToastUtils.setToast("微博为必选项!");
                } else {
                    ToastUtils.setToast("至少绑定2个账号!");
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 232 && resultCode == 232) {
            mPresenter.getUserBind();
        }
    }

    //授权
    private void authorization(SHARE_MEDIA share_media) {
        UMShareAPI.get(context).getPlatformInfo(getActivity(), share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                LogUtils.e("onStart " + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                LogUtils.e("onComplete " + "授权完成");
                if (bind_id == 1)
                    mPresenter.upUserThird1(bind_id, map.get("name"), null, null, map.get("iconurl"));
                else
                    mPresenter.upUserThird(bind_id, map.get("name"), map.get("iconurl"), map.get("followers_count"));
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
    public void onResume() {
        super.onResume();
        mPresenter.getUserBind();
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }

    //第三方的类型（0：微信 1：QQ 2：微博3:知乎4公众号5贴吧6豆瓣7京东8淘宝9秒拍10斗鱼11映客12天涯13美拍 14快手 15花椒 16陌陌 17NICE 18小红书 19领英）
    @Override
    public void showUserBind(UserBind userBind) {
        if (userBind.getData() != null) {
            i = userBind.getData().size();
            for (int j = 0; j < userBind.getData().size(); j++) {
                setBind(userBind.getData().get(j));
            }
        }
    }

    @Override
    public void showThird(Results results) {
        if (results.isSuccess()) {
            weibo = 1;
            i++;
            accounts.get(1).setImageResource(R.mipmap.weibo_c);
            accounts.get(1).setClickable(false);
        } else ToastUtils.setToast("网络异常,请重新尝试");
    }

    @Override
    public void showThird1(Results results) {
        if (results.isSuccess()) {
            i++;
            accounts.get(2).setImageResource(R.mipmap.qq_c);
            accounts.get(2).setClickable(false);
        } else ToastUtils.setToast("网络异常,请重新尝试");
    }

    @Override
    public void showWX(Results results) {
        if (results.isSuccess()) {
            weixin = 1;
            accounts.get(0).setImageResource(R.mipmap.weixin_c);
            accounts.get(0).setClickable(false);
        } else {
            weixin = 0;
            accounts.get(0).setImageResource(R.mipmap.weixin);
            accounts.get(0).setClickable(true);
        }
    }

    private void setBind(UserBind.DataBean dataBean) {
        switch (dataBean.getType()) {
            case 0://微信
                //todo 查询微信是否上传过截图
                mPresenter.getWX();
                break;
            case 1://QQ
                accounts.get(2).setImageResource(R.mipmap.qq_c);
                accounts.get(2).setClickable(false);
                break;
            case 2://微博
                weibo = 1;
                accounts.get(1).setImageResource(R.mipmap.weibo_c);
                accounts.get(1).setClickable(false);
                break;
            case 3://知乎
                accounts.get(5).setImageResource(R.mipmap.zhihu_c);
                accounts.get(5).setClickable(false);
                break;
            case 4://公众号
                accounts.get(3).setImageResource(R.mipmap.gongzonghao_c);
                accounts.get(3).setClickable(false);
                break;
            case 5://贴吧
                accounts.get(6).setImageResource(R.mipmap.tieba_c);
                accounts.get(6).setClickable(false);
                break;
            case 6://豆瓣
                accounts.get(4).setImageResource(R.mipmap.douban_c);
                accounts.get(4).setClickable(false);
                break;
            case 7://京东
                accounts.get(8).setImageResource(R.mipmap.jingdong_c);
                accounts.get(8).setClickable(false);
                break;
            case 8://淘宝
                accounts.get(7).setImageResource(R.mipmap.taobao_c);
                accounts.get(7).setClickable(false);
                break;
            case 9://秒拍
                accounts.get(13).setImageResource(R.mipmap.miaopai_c);
                accounts.get(13).setClickable(false);
                break;
            case 10://斗鱼
                accounts.get(10).setImageResource(R.mipmap.douyu_c);
                accounts.get(10).setClickable(false);
                break;
            case 12://天涯
                accounts.get(9).setImageResource(R.mipmap.tianya_c);
                accounts.get(9).setClickable(false);
                break;
            case 11://映客
                accounts.get(12).setImageResource(R.mipmap.yingke_c);
                accounts.get(12).setClickable(false);
                break;
            case 13://美拍
                accounts.get(11).setImageResource(R.mipmap.meipai_c);
                accounts.get(11).setClickable(false);
                break;
            case 14://快手
                accounts.get(14).setImageResource(R.mipmap.kuaishou);
                accounts.get(14).setClickable(false);
                break;
            case 15://花椒
                accounts.get(15).setImageResource(R.mipmap.huajiao);
                accounts.get(15).setClickable(false);
                break;
            case 16://陌陌
                accounts.get(16).setImageResource(R.mipmap.momo);
                accounts.get(16).setClickable(false);
                break;
            case 17://nice
                accounts.get(17).setImageResource(R.mipmap.nice);
                accounts.get(17).setClickable(false);
                break;
            case 18://小红书
                accounts.get(18).setImageResource(R.mipmap.xiaohongshu);
                accounts.get(18).setClickable(false);
                break;
            case 19://领英
                accounts.get(19).setImageResource(R.mipmap.lingying);
                accounts.get(19).setClickable(false);
                break;
        }
    }
}
