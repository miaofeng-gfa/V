package com.veeca.ted.v.view.approve.card;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.AddressAdapter;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CardFragment extends MVPBaseFragment<CardContract.View, CardPresenter> implements CardContract.View {

    @BindView(R.id.card_name)
    EditText cardName;
    @BindView(R.id.card_id)
    EditText cardId;
    @BindView(R.id.card_address)
    EditText cardAddress;
    @BindView(R.id.card_check)
    CheckBox cardCheck;
    Unbinder unbinder;

    private Context context;
    private String provinces[] = {"北京", "天津", "上海", "重庆", "河北",
            "河南", "云南", "辽宁", "黑龙江", "湖南", "安徽", "山东", "新疆",
            "江苏", "浙江", "江西", "湖北", "广西", "甘肃", "山西", "内蒙", "陕西",
            "吉林", "福建", "贵州", "广东", "青海", "西藏", "四川", "宁夏", "海南", "台湾", "香港", "澳门"};
    private Intent intent;
    private String idCard, idName, address;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        mPresenter.getUserInfo();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.card_address, R.id.card_text, R.id.card_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_address:
                showAddress();
                break;
            case R.id.card_text:
                intent = new Intent(context, PrivacyActivity.class);
                startActivity(intent);
                break;
            case R.id.card_btn:
                idName = cardName.getText().toString();
                idCard = cardId.getText().toString();
                address = cardAddress.getText().toString();
                if (idName != null && !"".equals(idName) && !"".equals(idCard) && idCard != null && !"".equals(address) && address != null) {
                    if (cardCheck.isChecked()) {
                        LoadUtil.showLoad(getActivity());
                        mPresenter.upCard(idName, idCard);
                    } else {
                        ToastUtils.setToast("请点击阅读!");
                    }
                } else {
                    ToastUtils.setToast("请填写完整信息!");
                }
                break;
        }
    }

    /**
     * 选择地址
     *
     * @author TED
     * created at 2017/10/13 14:51
     */
    private void showAddress() {
        final Dialog addressDialog = new Dialog(context, R.style.BottomDialog);
        final View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_address, null);
        addressDialog.setContentView(contentView);

        RecyclerView recyclerView = contentView.findViewById(R.id.address_recycler);
        final AddressAdapter addressAdapter = new AddressAdapter(context);
        linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));//设置分割线
        addressAdapter.clear();
        addressAdapter.setDataBeans(provinces);
        recyclerView.setAdapter(addressAdapter);
        addressAdapter.setOnItemClickListener(new AddressAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String dataBean) {
                cardAddress.setText(dataBean);
                addressDialog.dismiss();
            }
        });
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(params);
        addressDialog.getWindow().setGravity(Gravity.BOTTOM);
        addressDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        addressDialog.show();
    }

    @Override
    public void showError() {
        LoadUtil.hideLoad();
        ToastUtils.setToast("网络异常");
    }

    @Override
    public void showUserError() {
        ToastUtils.setToast("网络异常");
        getActivity().finish();
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        idCard = userInfo.getData().getIdcard() == null ? null : userInfo.getData().getIdcard();
        idName = userInfo.getData().getIdcardname() == null ? null : userInfo.getData().getIdcardname();
        address = userInfo.getData().getProvince() == null ? null : userInfo.getData().getProvince();
        if (idName != null && idCard != null) {
            cardId.setText(idCard);
            cardName.setText(idName);
            cardName.setFocusable(false);
            cardId.setFocusable(false);
        }
        if (address != null)
            cardAddress.setText(address);
    }

    @Override
    public void showV(Results results) {
        LoadUtil.hideLoad();
        ToastUtils.setToast("提交成功");
    }

    @Override
    public void showCard(Results results) {
        mPresenter.upAddress(address);
    }

    @Override
    public void showAddress(Results results) {
        mPresenter.upV();
    }
}
