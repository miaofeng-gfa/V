package com.veeca.ted.v.view.flow;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.AllVAdapter;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.Task;
import com.veeca.ted.v.bean.TaskV;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.myclass.SelectDialog;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.allv.AllVActivity;
import com.veeca.ted.v.view.approve.ApproveActivity;
import com.veeca.ted.v.view.h5.H5Activity;
import com.veeca.ted.v.view.influence.InfluenceActivity;
import com.veeca.ted.v.view.login.LoginActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.view.position.PositionActivity;
import com.veeca.ted.v.widget.CircleImageView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class FlowActivity extends MVPBaseActivity<FlowContract.View, FlowPresenter> implements FlowContract.View {

    @BindView(R.id.task_iv_logo)
    CircleImageView taskIvLogo;
    @BindView(R.id.task_tv_title)
    TextView taskTvTitle;
    @BindView(R.id.flow_tv_l_money)
    TextView flowTvLMoney;
    @BindView(R.id.flow_visi_z)
    LinearLayout flowVisiZ;
    @BindView(R.id.flow_tv_r_money)
    TextView flowTvRMoney;
    @BindView(R.id.flow_visi_r)
    LinearLayout flowVisiR;
    @BindView(R.id.task_tv_state)
    TextView taskTvState;
    @BindView(R.id.task_tv_name)
    TextView taskTvName;
    @BindView(R.id.flow_progressBar)
    ProgressBar flowProgressBar;
    @BindView(R.id.task_tv_sum)
    TextView taskTvSum;
    @BindView(R.id.task_tv_count)
    TextView taskTvCount;
    @BindView(R.id.flow_tv_money)
    TextView flowTvMoney;
    @BindView(R.id.flow_visi)
    LinearLayout flowVisi;
    @BindView(R.id.flow_tv_num)
    TextView flowTvNum;
    @BindView(R.id.flow_recycler)
    RecyclerView flowRecycler;
    @BindView(R.id.task_btn)
    Button taskBtn;
    private Context context;
    private Intent intent;
    private String cpc, coverimg, title, shareUrl, url;
    private int userState, userRep, taskRep, hid;
    private DecimalFormat df = new DecimalFormat("0.00");
    private SelectDialog dialog_login, dialog_influence, dialog_approve;
    private AllVAdapter vAdapter;
    private LinearLayoutManager layoutManager;
    private UMWeb web;
    private boolean flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        LoadUtil.showLoad(this);
        ButterKnife.bind(this);
        context = getContext();
        userState = Constant.getUserState();
        userRep = Constant.getUserRep();
        intent = getIntent();
        hid = intent.getIntExtra("id", 0);
        mPresenter.getTask(hid);

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
            LogUtils.e("分享成功的回调");
            mPresenter.getShare(hid);
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            ToastUtils.setToast("分享失败");
            LogUtils.e("分享失败的回调");
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            ToastUtils.setToast("分享取消");
            LogUtils.e("分享取消");
        }
    };

    @OnClick({R.id.top_return, R.id.task_btn, R.id.flow_btn_task_v, R.id.flow_btn_context})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.task_btn:
                LogUtils.e("userRep:" + userRep + ",taskRep:" + taskRep);
                if (userState != 1) loginDialog();
                else {
                    switch (userRep) {
                        case 0:
                            if (taskRep == 0)
                                new ShareAction(this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(shareListener)
                                        .withMedia(web)
                                        .share();
                            else approveDialog();
                            break;
                        case 1:
                            if (taskRep == 2) mPresenter.getWardCont();
                            else
                                new ShareAction(this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(shareListener)
                                        .withMedia(web)
                                        .share();
                            break;
                        case 2:
                            new ShareAction(this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(shareListener)
                                    .withMedia(web)
                                    .share();
                            break;
                    }
                }
                break;
            case R.id.flow_btn_task_v:
                intent = new Intent(context, AllVActivity.class);
                intent.putExtra("hid", hid);
                startActivity(intent);
                break;
            case R.id.flow_btn_context:
                intent = new Intent(context, H5Activity.class);
                intent.putExtra("url", url);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @Override
    public void showError() {
        LoadUtil.hideLoad();
        ToastUtils.setToast("网络异常");
    }

    @Override
    public void showTask(Task task) {
        mPresenter.getTaskV(hid);
        title = task.getData().getTitle();
        coverimg = task.getData().getCoverimg();
        shareUrl = task.getShareUrl();

        web = new UMWeb(shareUrl);
        web.setTitle("小V咖 - " + title);//标题
        UMImage image = new UMImage(this, coverimg);//网络图片
        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
        image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享
        image.compressFormat = Bitmap.CompressFormat.PNG;//用户分享透明背景的图片可以设置这种方式，但是qq好友，微信朋友圈，不支持透明背景图片，会变成黑色
        web.setThumb(image);  //缩略图

        taskRep = task.getData().getRep();
        Glide.with(context).load(task.getHeadimgurl()).into(taskIvLogo);
        taskTvTitle.setText(task.getNickname());
        cpc = df.format(task.getData().getCpc());
        flowTvLMoney.setText(cpc);
        if (task.getData().getStatusr() == 3) {
            taskTvState.setText("进行中");
            taskTvState.setBackgroundColor(getResources().getColor(R.color.yellow));
            taskTvState.setTextColor(getResources().getColor(R.color.font_color));
            taskBtn.setText("分享赚¥ " + cpc + " X 朋友圈点击量");
        } else {
            taskTvState.setText("已结束");
            taskTvState.setBackgroundColor(getResources().getColor(R.color.font_gray_9));
            taskTvState.setTextColor(getResources().getColor(R.color.font_gray_d));
            taskBtn.setTextColor(getResources().getColor(R.color.font_gray_d));
            taskBtn.setText("赏金已被抢完");
            taskBtn.setBackgroundColor(getResources().getColor(R.color.font_gray_9));
            taskBtn.setEnabled(false);
        }
        if (task.getData().getIsjoin() != 0) {
            flowVisiZ.setVisibility(View.VISIBLE);
            flowVisiR.setVisibility(View.VISIBLE);
            flowVisi.setVisibility(View.VISIBLE);
            int i1 = task.getData().getRes1();
            String i2 = df.format(task.getData().getRes2());
            flowTvMoney.setText("已获得" + i1 + "次点击，即将赚" + i2 + "元");
            flowTvRMoney.setText(i2);
            taskBtn.setTextColor(getResources().getColor(R.color.white));
            taskBtn.setText("进行中");
            taskBtn.setBackgroundColor(getResources().getColor(R.color.font_7244));
            taskBtn.setEnabled(false);
        }
        taskTvName.setText(task.getData().getTitle());
        String i3 = df.format(task.getData().getPayment());
        taskTvSum.setText("共" + i3 + "元");
        taskTvCount.setText(task.getData().getLeft1() + "");
        flowProgressBar.setMax(task.getData().getPayment());
        flowProgressBar.setProgress((int) (task.getData().getPayment() - task.getData().getLeft1()));
        url = task.getData().getUrl();
    }

    @Override
    public void showTaskV(TaskV taskV) {
        LoadUtil.hideLoad();
        List<TaskV.XiaovShareListBean> xiaovShareListBeans = new ArrayList<>();
        flowTvNum.setText(taskV.getJoinCount() + "人");
        vAdapter = new AllVAdapter(context);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        flowRecycler.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));//设置分割线
        flowRecycler.setHasFixedSize(true);
        flowRecycler.setLayoutManager(layoutManager);
        xiaovShareListBeans.addAll(taskV.getXiaovShareList());
        vAdapter.setListBeans(xiaovShareListBeans);
        flowRecycler.setAdapter(vAdapter);
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        mPresenter.getTask(hid);
        Constant.setUserRep(userInfo.getData().getRep());
        userRep = Constant.getUserRep();
    }

    @Override
    public void showShare(Results results) {
        LoadUtil.showLoad(this);
        mPresenter.getTask(hid);
    }

    @Override
    public void showWardCont(Results results) {
        LogUtils.e(results.toString());
        if (results.getState() == 0) flag = false;
        else flag = true;
        influenceDialog();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            LoadUtil.showLoad(this);
            userState = Constant.getUserState();
            if (userState == 1)
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
                intent.putExtra("resultCode", 10);
                startActivityForResult(intent, 10);
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

    private void influenceDialog() {
        dialog_influence = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.dialog_influence, null);
        viewDialog.findViewById(R.id.influence_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag)
                    intent = new Intent(context, InfluenceActivity.class);
                else {
                    intent = new Intent(context, PositionActivity.class);
                }
                startActivity(intent);
                dialog_influence.dismiss();
            }
        });
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_influence.setContentView(viewDialog, layoutParams);
        dialog_influence.show();
    }

    private void approveDialog() {
        dialog_approve = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.dialog_approve, null);
        viewDialog.findViewById(R.id.approve_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, ApproveActivity.class);
                startActivity(intent);
                dialog_approve.dismiss();
            }
        });
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_approve.setContentView(viewDialog, layoutParams);
        dialog_approve.show();
    }
}
