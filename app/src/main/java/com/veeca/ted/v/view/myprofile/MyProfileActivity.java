package com.veeca.ted.v.view.myprofile;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.AddressAdapter;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.mian.Circle;
import com.veeca.ted.v.bean.mian.Like;
import com.veeca.ted.v.bean.mian.UserCircle;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.bean.mian.UserLike;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseActivity;
import com.veeca.ted.v.widget.CircleImageView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyProfileActivity extends MVPBaseActivity<MyProfileContract.View, MyProfilePresenter> implements MyProfileContract.View {

    @BindView(R.id.profile_avatar)
    CircleImageView profileAvatar;
    @BindView(R.id.profile_name)
    EditText profileName;
    @BindView(R.id.profile_address)
    TextView profileAddress;
    @BindView(R.id.flow_like)
    TagFlowLayout flowLike;
    @BindView(R.id.flow_circle)
    TagFlowLayout flowCircle;
    private Context context;
    private Activity mActivity;
    private String image_url, user_name, user_address, labelIds, circleIds;
    private String[] my_like, my_circle, flow_like, flow_circle;
    private String provinces[] = {"北京", "天津", "上海", "重庆", "河北",
            "河南", "云南", "辽宁", "黑龙江", "湖南", "安徽", "山东", "新疆", "江苏",
            "浙江", "江西", "湖北", "广西", "甘肃", "山西", "内蒙", "陕西", "吉林", "福建",
            "贵州", "广东", "青海", "西藏", "四川", "宁夏", "海南", "台湾", "香港", "澳门"};
    private LinearLayoutManager linearLayoutManager;
    private Like like;
    private Circle circle;
    private TagFlowLayout flowLayout;
    private Set<Integer> select;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);
        context = getContext();
        mActivity = this;
        LoadUtil.showLoad(mActivity);
        profileName.setFocusable(false);
        profileName.setFocusableInTouchMode(false);
        mPresenter.getUserInfo();
        mPresenter.getUserLike();
        mPresenter.getUserCircle();
    }

    @OnClick({R.id.top_return, R.id.top_success, R.id.profile_avatar, R.id.profile_linear, R.id.profile_like, R.id.profile_circle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_return:
                finish();
                break;
            case R.id.top_success:
                LoadUtil.showLoad(mActivity);
                if (labelIds != "" && circleIds != "")
                    mPresenter.getMyProfile(image_url, user_name, user_address, labelIds, circleIds);
                else ToastUtils.setToast("请填写完整资料");
                break;
            case R.id.profile_avatar:
                break;
            case R.id.profile_linear:
                showAddress();
                break;
            case R.id.profile_like:
                mPresenter.getApproveLike();
                break;
            case R.id.profile_circle:
                mPresenter.getApproveCircle();
                break;
        }
    }


    @Override
    public void showUserInfo(UserInfo userInfo) {
        LoadUtil.hideLoad();
        image_url = userInfo.getData().getHeadimgurl();
        Glide.with(context).load(image_url).into(profileAvatar);
        user_name = userInfo.getData().getNickname();
        profileName.setText(user_name);
        user_address = userInfo.getData().getProvince();
        profileAddress.setText(user_address);
    }

    @Override
    public void showLike(UserLike userLike) {
        LogUtils.e(userLike.toString());
        labelIds = "";
        my_like = new String[userLike.getData().size()];
        for (int i = 0; i < userLike.getData().size(); i++) {
            labelIds = labelIds + userLike.getData().get(i).getId() + ",";
            my_like[i] = userLike.getData().get(i).getLabelname();
        }
        flowLike.setAdapter(new TagAdapter<String>(my_like) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_like_tag,
                        flowLike, false);
                tv.setText(s);
                return tv;
            }
        });
    }

    @Override
    public void showCircle(UserCircle userCircle) {
        LogUtils.e(userCircle.toString());
        circleIds = "";
        my_circle = new String[userCircle.getData().size()];
        for (int i = 0; i < userCircle.getData().size(); i++) {
            circleIds = circleIds + userCircle.getData().get(i).getId() + ",";
            my_circle[i] = userCircle.getData().get(i).getCirclename();
        }
        flowCircle.setAdapter(new TagAdapter<String>(my_circle) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_like_tag,
                        flowCircle, false);
                tv.setText(s);
                return tv;
            }
        });
    }

    @Override
    public void showMyProfile(Results results) {
        LoadUtil.hideLoad();
        if (results.isSuccess()) ToastUtils.setToast("保存成功");
        else ToastUtils.setToast("网络异常");
    }

    @Override
    public void showApproveLike(Like like) {
        this.like = like;
        showLikeCircle(1);
    }

    @Override
    public void showApproveCircle(Circle circle) {
        this.circle = circle;
        showLikeCircle(2);
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
                user_address = dataBean;
                profileAddress.setText(dataBean);
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

    private void showLikeCircle(final int state) {
        final Dialog likeCircleDialog = new Dialog(context, R.style.BottomDialog);
        final View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_like, null);
        select = new HashSet<>();
        likeCircleDialog.setContentView(contentView);
        TextView textView = contentView.findViewById(R.id.title);
        textView.setText("最多选择5个");
        flowLayout = contentView.findViewById(R.id.flow_layout);
        if (state == 1) {
            flow_like = new String[like.getData().size()];
            for (int i = 0; i < like.getData().size(); i++) {
                flow_like[i] = like.getData().get(i).getLabelname();
            }
            flowLayout.setAdapter(new TagAdapter<String>(flow_like) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_like_tag_n,
                            flowLayout, false);
                    tv.setText(s);
                    return tv;
                }
            });
        } else {
            flow_circle = new String[circle.getData().size()];
            for (int i = 0; i < circle.getData().size(); i++) {
                flow_circle[i] = circle.getData().get(i).getCirclename();
            }
            flowLayout.setAdapter(new TagAdapter<String>(flow_circle) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_like_tag_n,
                            flowLayout, false);
                    tv.setText(s);
                    return tv;
                }
            });
        }
        flowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                select = selectPosSet;
            }
        });
        contentView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (select.size() > 1) {
                    if (state == 1) {
                        labelIds = "";
                        my_like = new String[select.size()];
                        int j = 0;
                        for (int i : select) {
                            my_like[j] = like.getData().get(i).getLabelname();
                            labelIds = labelIds + like.getData().get(i).getId() + ",";
                            j++;
                        }
                        labelIds = labelIds.substring(0, labelIds.length() - 1);
                        flowLike.setAdapter(new TagAdapter<String>(my_like) {
                            @Override
                            public View getView(FlowLayout parent, int position, String s) {
                                TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_like_tag,
                                        flowLike, false);
                                tv.setText(s);
                                return tv;
                            }
                        });
                    } else {
                        circleIds = "";
                        my_circle = new String[select.size()];
                        int j = 0;
                        for (int i : select) {
                            circleIds = circleIds + circle.getData().get(i).getId() + ",";
                            my_circle[j] = circle.getData().get(i).getCirclename();
                            j++;
                        }
                        circleIds = circleIds.substring(0, circleIds.length() - 1);
                        flowCircle.setAdapter(new TagAdapter<String>(my_circle) {
                            @Override
                            public View getView(FlowLayout parent, int position, String s) {
                                TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_like_tag,
                                        flowCircle, false);
                                tv.setText(s);
                                return tv;
                            }
                        });
                    }
                    likeCircleDialog.dismiss();
                } else ToastUtils.setToast("最少选择2项");
            }
        });
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(params);
        likeCircleDialog.getWindow().setGravity(Gravity.BOTTOM);
        likeCircleDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        likeCircleDialog.show();
    }

}
