package com.veeca.ted.v.view.recharge;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alipay.sdk.app.PayTask;
import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.Recharge;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.utils.alipay.PayResult;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class RechargeActivity extends MVPBaseActivity<RechargeContract.View, RechargePresenter> implements RechargeContract.View {

    @BindView(R.id.recharge_money)
    EditText rechargeMoney;
    @BindView(R.id.recharge_btn)
    Button rechargeBtn;
    private Context context;
    private Activity mActivity;
    private static final int SDK_PAY_FLAG = 1;
    private Intent intent;
    private double money;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        ButterKnife.bind(this);
        mActivity = this;
        context = getContext();
        rechargeMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().contains(".")) {
                    if (charSequence.length() - 1 - charSequence.toString().indexOf(".") > 2) {
                        charSequence = charSequence.toString().subSequence(0,
                                charSequence.toString().indexOf(".") + 3);
                        rechargeMoney.setText(charSequence);
                        rechargeMoney.setSelection(charSequence.length());
                    }
                }
                if (charSequence.toString().trim().substring(0).equals(".")) {
                    charSequence = "0" + charSequence;
                    rechargeMoney.setText(charSequence);
                    rechargeMoney.setSelection(2);
                }

                if (charSequence.toString().startsWith("0")
                        && charSequence.toString().trim().length() > 1) {
                    if (!charSequence.toString().substring(1, 2).equals(".")) {
                        rechargeMoney.setText(charSequence.subSequence(0, 1));
                        rechargeMoney.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void recharge(final String s) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask((Activity) context);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(s, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            if (msg.what == SDK_PAY_FLAG) {
                PayResult payResult = new PayResult((String) msg.obj);
                /**
                 * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                 * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                 * docType=1) 建议商户依赖异步通知
                 */
                String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                String resultStatus = payResult.getResultStatus();
                LoadUtil.hideLoad();
                // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                if (TextUtils.equals(resultStatus, "9000")) {
                    ToastUtils.setToast("支付成功");
                    //todo 支付成功
                    mPresenter.getUsableMoney();
                } else {
                    rechargeBtn.setFocusable(true);
                    // 判断resultStatus 为非"9000"则代表可能支付失败
                    // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                    if (TextUtils.equals(resultStatus, "8000")) {
                        ToastUtils.setToast("支付结果确认中");
                        //todo 支付确认中
                    } else {
                        // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                        ToastUtils.setToast("支付失败");
                        //todo 支付失败
                    }
                }
            }
        }
    };

    @OnClick({R.id.top_return, R.id.recharge_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.recharge_btn:
                LoadUtil.showLoad(mActivity);
                rechargeBtn.setFocusable(false);
                money = Double.parseDouble("".equals(rechargeMoney.getText().toString()) ? "0.00" : rechargeMoney.getText().toString());
                if (money > 0)
                    mPresenter.getRecharge(money);
                else
                    rechargeBtn.setFocusable(true);
                break;
        }
    }

    @Override
    public void showRecharge(Recharge recharge) {
        recharge(recharge.getSign());
    }

    @Override
    public void showUsableMoney(UsableMoney usableMoney) {
        intent = new Intent(mActivity, Recharge2Activity.class);
        intent.putExtra("money", usableMoney.getUsableMoney());
        startActivity(intent);
        finish();
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常,请稍后尝试");
    }
}
