package com.veeca.ted.v.view.main;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.Version;
import com.veeca.ted.v.bean.mian.Income;
import com.veeca.ted.v.bean.mian.Sign;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.myclass.SelectDialog;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.SharedPrefenencesUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.community.CommunityFragment;
import com.veeca.ted.v.view.home.HomeFragment;
import com.veeca.ted.v.view.income.IncomeFragment;
import com.veeca.ted.v.view.login.LoginActivity;
import com.veeca.ted.v.view.more.MoreActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.view.my.MyFragment;
import com.veeca.ted.v.view.release.ReleaseActivity;
import com.veeca.ted.v.view.set.SetActivity;
import com.veeca.ted.v.view.vadshare.VadShareActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.UpdateAppUtils;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View {

    @BindView(R.id.tv_new_more)
    TextView mainNewMore;
    @BindView(R.id.iv_main_more)
    ImageView ivMainMore;
    @BindView(R.id.iv_my_message)
    ImageView ivMyMessage;
    @BindView(R.id.iv_my_seting)
    ImageView ivMaySeting;
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindViews({R.id.main_image_home, R.id.main_image_community, R.id.main_image_income, R.id.main_image_my})
    List<ImageView> arr_iv;
    @BindViews({R.id.main_text_home, R.id.main_text_community, R.id.main_text_income, R.id.main_text_my})
    List<TextView> arr_tv;
    // 声明碎片: 首页,收益
    private Fragment home_frag, community_frag, income_frag, my_frag;
    private Fragment[] fragments;// 碎片数组
    // 下面的两个数组是分别装资源ID
    // 默认的ID(白色的图片)
    private int[] arr_id_default = {
            R.mipmap.shangjin_n,
            R.mipmap.shequn_n,
            R.mipmap.shouyi_n,
            R.mipmap.my_n
    };
    // 选中的ID(黄色的图片)
    private int[] arr_id_selected = {
            R.mipmap.shangjin_s,
            R.mipmap.shequn_s,
            R.mipmap.shouyi_s,
            R.mipmap.my_s
    };

    private SharedPrefenencesUtils utils;
    private Context context;
    private Intent intent;
    private Long xtime = Long.valueOf(10000000);
    private int userState;
    private SelectDialog dialog_login, dialog_sign, dialog_income;
    private boolean flag;
    private String qrcode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        utils = SharedPrefenencesUtils.getInstance();
        userState = (int) utils.getData("userState", 0);
        context = getContext();
        initFragment();
        mPresenter.getVersion();
        if (userState == 1) {
            //todo
            mPresenter.getSign();
            mPresenter.getUserInfo();
        }


    }


    /**
     * 重写返回键
     *
     * @author TED
     * created at 2017/11/15 19:09
     */
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - xtime) < 2000) {
            finish();
            super.onBackPressed();
        } else {
            ToastUtils.setToast("再按一次退出!");
            xtime = System.currentTimeMillis();
        }
    }


    /**
     * 初始化碎片
     *
     * @author TED
     * created at 2017/11/15 19:09
     */
    private void initFragment() {
        home_frag = new HomeFragment();
        community_frag = new CommunityFragment();
        income_frag = new IncomeFragment();
        my_frag = new MyFragment();
        fragments = new Fragment[4];
        fragments[0] = home_frag;
        fragments[1] = community_frag;
        fragments[2] = income_frag;
        fragments[3] = my_frag;

        change(fragments[0]);// 切换碎片
        checkHighLight(0);// 添加高亮
    }

    /**
     * 切换碎片的方法
     *
     * @author TED
     * created at 2017/11/15 19:09
     */
    private void change(Fragment f) {
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, f)
                .commit();// 提交事务
    }


    /**
     * 选中高亮
     *
     * @author TED
     * created at 2017/11/15 19:09
     */
    private void checkHighLight(int index) {
        //  高亮字体
        for (int i = 0; i < arr_tv.size(); i++) {
            arr_tv.get(i).setTextColor(getResources().getColor(R.color.font_gray_60));// 灰色
        }
        arr_tv.get(index).setTextColor(getResources().getColor(R.color.yellow));//黄色
        // 高亮图标
        // 全部的图标要先统一程默认的图标
        setAllImageDefault();
        arr_iv.get(index).setImageResource(arr_id_selected[index]);
    }

    /**
     * 设置默认图片资源
     *
     * @author TED
     * created at 2017/11/15 19:08
     */
    private void setAllImageDefault() {
        for (int i = 0; i < arr_iv.size(); i++) {
            arr_iv.get(i).setImageResource(arr_id_default[i]);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 0) {
            userState = (int) utils.getData("userState", 0);

        }

    }

    @OnClick({R.id.iv_main_more,R.id.tv_new_more,R.id.iv_my_seting,R.id.iv_my_message, R.id.main_home, R.id.main_community, R.id.main_btn, R.id.main_income, R.id.main_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_main_more:
               /* if (userState == 1) {
                    intent = new Intent(context, MoreActivity.class);
                    startActivity(intent);
                } else {
                    loginDialog();
                }*/
                break;
            case R.id.iv_my_message:
                if (userState == 1) {
                    intent = new Intent(context, MoreActivity.class);
                    startActivity(intent);
                } else {
                    loginDialog();
                }
                break;
            case R.id.tv_new_more:
                intent = new Intent(context, ReleaseActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_my_seting:
                intent = new Intent(this, SetActivity.class);
                startActivityForResult(intent, 234);
                break;
            case R.id.main_home:
                change(fragments[0]);// 切换碎片
                checkHighLight(0);// 添加高亮
                mainNewMore.setVisibility(View.GONE);
                ivMainMore.setVisibility(View.VISIBLE);
                ivMyMessage.setVisibility(View.GONE);
                ivMaySeting.setVisibility(View.GONE);
                break;
            case R.id.main_community:
                change(fragments[1]);// 切换碎片
                checkHighLight(1);// 添加高亮
                mainNewMore.setVisibility(View.VISIBLE);
                ivMainMore.setVisibility(View.GONE);
                ivMyMessage.setVisibility(View.GONE);
                ivMaySeting.setVisibility(View.GONE);
                break;
            case R.id.main_btn:
                if (userState == 1) {
                    /*intent = new Intent(context, CenterActivity.class);
                    intent.putExtra("qrcode", qrcode);*/
                    intent = new Intent(context, VadShareActivity.class);
                    startActivity(intent);
                } else {
                    loginDialog();
                }
                break;
            case R.id.main_income:
                if (userState == 1) {
                    change(fragments[2]);// 切换碎片
                    checkHighLight(2);// 添加高亮
                } else {
                    loginDialog();
                }
                mainNewMore.setVisibility(View.GONE);
                ivMainMore.setVisibility(View.GONE);
                ivMyMessage.setVisibility(View.GONE);
                ivMaySeting.setVisibility(View.GONE);
                break;
            case R.id.main_my:
                if (userState == 1) {
                    change(fragments[3]);// 切换碎片
                    checkHighLight(3);// 添加高亮
                } else {
                    loginDialog();
                }
                mainNewMore.setVisibility(View.GONE);
                ivMainMore.setVisibility(View.GONE);
                ivMyMessage.setVisibility(View.VISIBLE);
                ivMaySeting.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        userState = (int) utils.getData("userState", 0);
        if (userState == 1) {
            mPresenter.getSign();
            mPresenter.getUserInfo();
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
                intent.putExtra("resultCode", 0);
                startActivityForResult(intent, 0);
                dialog_login.dismiss();
            }
        });
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_login.setContentView(viewDialog, layoutParams);
        dialog_login.show();
    }

    /**
     * 返回当前程序版本名
     */
    public static int getAppVersionCode(Context context) {
        String versionName = "";
        int versioncode = 0;
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            versioncode = pi.versionCode;
            if (versionName == null || versionName.length() <= 0) {
                return 0;
            }
        } catch (Exception e) {
            LogUtils.e("VersionInfo+Exception" + e.toString());
        }
        return versioncode;
    }

    /**
     * 获取版本号
     *
     * @author TED
     * created at 2017/11/15 19:08
     */
    @Override
    public void showVersion(Version version) {
        LogUtils.e(version.toString());
        if (version.isSuccess()) {
            int oldCode = getAppVersionCode(context);
            int newCode = version.getData().getVersionCode();
            if (newCode > oldCode) {
                if (version.getData().getIsForce() == 0)
                    flag = false;
                else
                    flag = true;
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    UpdateAppUtils.from((Activity) context)
                            .serverVersionCode(newCode)
                            .serverVersionName(version.getData().getVersionName())
                            .apkPath(version.getData().getDownload())
                            .downloadBy(UpdateAppUtils.DOWNLOAD_BY_BROWSER)
                            .isForce(flag)
                            .update();
                } else {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        UpdateAppUtils.from((Activity) context)
                                .serverVersionCode(newCode)
                                .serverVersionName(version.getData().getVersionName())
                                .apkPath(version.getData().getDownload())
                                .downloadBy(UpdateAppUtils.DOWNLOAD_BY_BROWSER)
                                .isForce(flag)
                                .update();
                    } else //申请权限
                        ActivityCompat.requestPermissions((Activity) context,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
            }
        }
    }

    @Override
    public void showSign(final Sign sign) {
        dialog_sign = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.jinbi, null);
        ((TextView) viewDialog.findViewById(R.id.textView5)).setText("恭喜您获得" + sign.getGinum() + "个金币");
        viewDialog.findViewById(R.id.jinbibtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getSignSuccess(sign.getGisign(), sign.getGinum(), sign.getInum());
            }
        });
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_sign.setContentView(viewDialog, layoutParams);
        dialog_sign.show();
    }

    @Override
    public void showSignSuccess(Results results) {
        dialog_sign.dismiss();
        mPresenter.getMainIncome();
    }

    @Override
    public void showMainIncome(Income income) {
        if (income.getData() != 0) {
            dialog_income = new SelectDialog(context, R.style.dialog);
            LayoutInflater inflater1 = LayoutInflater.from(context);
            View viewDialog1 = inflater1.inflate(R.layout.shangjin, null);
            Display display1 = getWindowManager().getDefaultDisplay();
            int width = display1.getWidth();
            int height = display1.getHeight();
            //设置dialog的宽高为屏幕的宽高
            ViewGroup.LayoutParams layoutParams1 = new ViewGroup.LayoutParams(width, height);
            ((TextView) viewDialog1.findViewById(R.id.money)).setText(income.getData() + "");
            viewDialog1.findViewById(R.id.shangjinbtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_income.dismiss();
                }
            });
            dialog_income.setContentView(viewDialog1, layoutParams1);
            dialog_income.show();
        }
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        Constant.setUserRep(userInfo.getData().getRep());
        Constant.setIsV(userInfo.getData().getState());
        qrcode = userInfo.getData().getQrCode();
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }
}
