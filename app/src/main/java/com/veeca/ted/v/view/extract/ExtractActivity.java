package com.veeca.ted.v.view.extract;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.bean.IsFirstMoney;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.UserAllCard;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.bindalipay.BindALiPayActivity;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ExtractActivity extends MVPBaseActivity<ExtractContract.View, ExtractPresenter> implements ExtractContract.View {

    @BindView(R.id.alipay_account)
    TextView alipayAccount;
    @BindView(R.id.alipay_money)
    EditText alipayMoney;
    @BindView(R.id.extract_text)
    TextView extractText;
    @BindView(R.id.alipay_btn)
    Button alipayBtn;
    @BindView(R.id.ll_getcash_fubao)
    LinearLayout llFuBao;
    private Intent intent;
    private Context context;
    private int userRep;
    private double myMoney;
    private  String getcashtype;
    private  Boolean wxFcash;
    private   Boolean aliFcash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract);
        ButterKnife.bind(this);
        context = getContext();
        userRep = Constant.getUserRep();
        mPresenter.getIsTxAll();
        Intent intent =getIntent();
                /*取出Intent中附加的数据*/
         getcashtype = intent.getStringExtra("getcashtype");
         if (getcashtype.equals("1")){
             llFuBao.setVisibility(View.VISIBLE);
         }else if(getcashtype.equals("0")){
             llFuBao.setVisibility(View.GONE);
         }

        alipayMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().contains(".")) {
                    if (charSequence.length() - 1 - charSequence.toString().indexOf(".") > 2) {
                        charSequence = charSequence.toString().subSequence(0,
                                charSequence.toString().indexOf(".") + 3);
                        alipayMoney.setText(charSequence);
                        alipayMoney.setSelection(charSequence.length());
                    }
                }
                if (charSequence.toString().trim().substring(0).equals(".")) {
                    charSequence = "0" + charSequence;
                    alipayMoney.setText(charSequence);
                    alipayMoney.setSelection(2);
                }

                if (charSequence.toString().startsWith("0")
                        && charSequence.toString().trim().length() > 1) {
                    if (!charSequence.toString().substring(1, 2).equals(".")) {
                        alipayMoney.setText(charSequence.subSequence(0, 1));
                        alipayMoney.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mPresenter.getUsableMoney();
        mPresenter.getAllCard();
    }

    @OnClick({R.id.top_return, R.id.alipay_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.alipay_btn:
                alipayBtn.setFocusable(false);
                if (getcashtype.equals("1")){
                    if (!alipayMoney.getText().toString().isEmpty()) {

                        Double mMoney = Double.parseDouble(alipayMoney.getText().toString());
                        if (mMoney > myMoney) {
                            ToastUtils.setToast("超出可提现金额");
                        } else if (mMoney <= 1000) {
                            mPresenter.getExtract(alipayMoney.getText().toString());
                            if (userRep > 0) {
                                if (mMoney >= 100) {

                                    mPresenter.getExtract(alipayMoney.getText().toString());
                                } else ToastUtils.setToast("最小金额为100元");
                            } else {
                                if (mMoney >= 10) {
                                    mPresenter.getExtract(alipayMoney.getText().toString());
                                } else ToastUtils.setToast("最小金额为10元");
                            }
                        } else ToastUtils.setToast("每次提现最大金额为1000元");
                    } else {
                        ToastUtils.setToast("金额不能为空");
                    }
                }else if(getcashtype.equals("0")){
                    if (!alipayMoney.getText().toString().isEmpty()) {
                        Double mMoney = Double.parseDouble(alipayMoney.getText().toString());
                        if (mMoney > myMoney) {
                            ToastUtils.setToast("超出可提现金额");
                        } else if (mMoney <= 1000) {
                            if (wxFcash){
                                if (userRep > 0) {
                                    if (mMoney >=1) {

                                        mPresenter.getCashWeiXin(alipayMoney.getText().toString());
                                    } else ToastUtils.setToast("最小金额为大于1元");
                                }else {
                                    if (mMoney >=1) {
                                        mPresenter.getCashWeiXin(alipayMoney.getText().toString());
                                    } else ToastUtils.setToast("最小金额为大于1元");
                                }

                            }else {

                                if (userRep > 0) {
                                    if (mMoney >= 10) {

                                        mPresenter.getCashWeiXin(alipayMoney.getText().toString());
                                    } else ToastUtils.setToast("最小金额为10元");
                                }else {
                                    if (mMoney >=10) {
                                        mPresenter.getCashWeiXin(alipayMoney.getText().toString());
                                    } else ToastUtils.setToast("最小金额为10元");
                                }

                            }

                        } else ToastUtils.setToast("每次提现最大金额为1000元");
                    } else {
                        ToastUtils.setToast("金额不能为空");
                    }
                }

                break;
        }
    }

    @Override
    public void showAllCard(UserAllCard userAllCard) {
        if (userAllCard.getZhifubao() == null) {
            intent = new Intent(context, BindALiPayActivity.class);
            startActivity(intent);
            finish();
        } else {
            alipayAccount.setText(userAllCard.getZhifubao());
        }
    }

    @Override
    public void showUsableMoney(UsableMoney usableMoney) {
        myMoney = usableMoney.getUsableMoney();
        /*if (userRep > 0)
            extractText.setText("可提现金额为" + myMoney + "元,最低提现金额为100元");
        else
            extractText.setText("可提现金额为" + myMoney + "元,最低提现金额为10元");*/
    }

    @Override
    public void showExtract(Results results) {
        intent = new Intent(context, ExtractEndActivity.class);
        startActivity(intent);
        finish();
    }


    public void showExtractWX(Results results) {
        intent = new Intent(context, ExtractEndActivity.class);
        startActivity(intent);
        finish();
    }

    public void showIsTxAll(IsFirstMoney isfirstmoney) {
        wxFcash = isfirstmoney.isWx();
        aliFcash = isfirstmoney.isAli();
        String  mesFcash = isfirstmoney.getMsg();
        LogUtils.e("bbbbbbbb========="+isfirstmoney.toString());
       /* intent = new Intent(context, ExtractEndActivity.class);
        startActivity(intent);
        finish();*/


        if (getcashtype.equals("1")){
            if (aliFcash)
                extractText.setText("可提现金额为" + myMoney + "元,最低提现金额为10元");
            else
                extractText.setText("可提现金额为" + myMoney + "元,最低提现金额为100元");
        }else if(getcashtype.equals("0")){
            if (wxFcash){
                extractText.setText("可提现金额为" + myMoney + "元");
            }else {
                extractText.setText("可提现金额为" + myMoney + "元,最低提现金额为10元");
            }

        }
    }

    @Override
    public void showError() {
        ToastUtils.setToast("网络异常");
    }
}
