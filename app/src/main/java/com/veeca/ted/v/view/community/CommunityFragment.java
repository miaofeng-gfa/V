package com.veeca.ted.v.view.community;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.QunAdapter;
import com.veeca.ted.v.adapter.VAdapter;
import com.veeca.ted.v.bean.QunList;
import com.veeca.ted.v.bean.QunTags;
import com.veeca.ted.v.bean.Results;
import com.veeca.ted.v.bean.UsableMoney;
import com.veeca.ted.v.bean.VLists;
import com.veeca.ted.v.constant.Constant;
import com.veeca.ted.v.myclass.SelectDialog;
import com.veeca.ted.v.utils.CustomLinearGridLayoutManager;
import com.veeca.ted.v.utils.LoadUtil;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.SharedPrefenencesUtils;
import com.veeca.ted.v.utils.SimplePaddingDecoration;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.utils.VSpaceItemDecoration;
import com.veeca.ted.v.view.login.LoginActivity;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;
import com.veeca.ted.v.view.recharge.RechargeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CommunityFragment extends MVPBaseFragment<CommunityContract.View, CommunityPresenter> implements CommunityContract.View, QunAdapter.IControl {

    @BindView(R.id.v_recycler)
    RecyclerView vRecycler;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.list_recycler)
    RecyclerView listRecycler;
    @BindView(R.id.list_swipe_refresh)
    SwipeRefreshLayout listSwipeRefresh;
    EditText etPayMoney;
    EditText etWeiXin;
    Unbinder unbinder;
    private Context context;
    private VAdapter vAdapter;
    private List<QunList.DataBean> qunList = new ArrayList<>();
    private SharedPrefenencesUtils utils;
    private Intent intent;
    private int qunSign, page;
    private int userState, isV;
    private String id;
    private int lastVisibleItem;
    private LinearLayoutManager layoutManager;
    private CustomLinearGridLayoutManager listLayoutManager;
    private QunAdapter qunAdapter;
    private List<QunList.DataBean> qunLists = new ArrayList<>();
    private SelectDialog dialog_login, dialog_approve, dialog_free, dialog_recharge,dialog_paymoney;
    private Dialog dialog_join, dialog_join_v;
    private Activity mActivity;
    private QunList.DataBean qunBean;
    private QunList.DataBean.MemberListBean memberListBean;
    private String  payMoney = null;
    private String  weinXin = null ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, null);
        etPayMoney  = view.findViewById(R.id.et_paymoney);
        etWeiXin  = view.findViewById(R.id.et_weixin);
        context = getContext();
        mActivity = getActivity();
        LoadUtil.showLoad(mActivity);
        unbinder = ButterKnife.bind(this, view);
        utils = SharedPrefenencesUtils.getInstance();
        userState = Constant.getUserState();
        isV = Constant.getIsV();
        initData();
        setListener();
        mPresenter.getV();
        return view;
    }

    private void initData() {
        page = 0;
        id = (int) utils.getData("state", 0) == 0 ? null : Constant.getUserId();
        qunAdapter = new QunAdapter(context);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listRecycler.setLayoutManager(layoutManager);
        listRecycler.addItemDecoration(new SimplePaddingDecoration(context));//设置分割线
        qunAdapter.setLists(qunLists);
        qunAdapter.setControl(this);
        listRecycler.setAdapter(qunAdapter);
        listSwipeRefresh.setColorSchemeResources(R.color.yellow);
        listSwipeRefresh.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
    }

    private void setListener() {
        listSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                qunList.clear();
                listSwipeRefresh.setRefreshing(true);
                mPresenter.getQun(id, page, qunSign);
            }
        });


        listRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                0：当前屏幕停止滚动；1时：屏幕在滚动 且 用户仍在触碰或手指还在屏幕上；2时：随用户的操作，屏幕上产生的惯性滑动；
                //               滑动状态停止并且剩余两个item时自动加载
//                if (newState == RecyclerView.SCROLL_STATE_IDLE)
                if (lastVisibleItem + 2 >= layoutManager.getItemCount()) {
                    page++;
                    LogUtils.e("加载");
                    mPresenter.getQun(id, page, qunSign);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //                获取加载的最后一个可见视图在适配器的位置。
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showV(VLists vLists) {
        mPresenter.getQunTags();
        vAdapter = new VAdapter(context);
        listLayoutManager = new CustomLinearGridLayoutManager(context, vLists.getData().size(),
                LinearLayoutManager.VERTICAL, false);
        listLayoutManager.setScrollEnabled(false);
        vRecycler.setLayoutManager(listLayoutManager);
        vRecycler.setHasFixedSize(true);
        vAdapter.setDataBeans(vLists.getData());
        VSpaceItemDecoration vSpaceItemDecoration = new VSpaceItemDecoration(16);
        vRecycler.addItemDecoration(vSpaceItemDecoration);
        vRecycler.setAdapter(vAdapter);
        vAdapter.setOnItemClickListener(new VAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, VLists.DataBean dataBean) {
                //todo 每日大咖点击
            }
        });
    }

    @Override
    public void showQun(QunList qunList) {
        listSwipeRefresh.setRefreshing(false);
        if (qunList.isSuccess()) {
            if (qunList.getData().size() == 0) {
                ToastUtils.setToast("没有更多记录了!");
            }
            if (page == 0) {
                qunLists.clear();
                qunAdapter.clear();
            }
            qunLists.addAll(qunList.getData());
            qunAdapter.setLists(qunLists);
            qunAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showQunTags(final QunTags tags) {
        LoadUtil.hideLoad();

        for (int i = 0; i < 3; i++)
            tabLayout.addTab(tabLayout.newTab().setText(tags.getData().get(i).getName()));
        qunSign = tags.getData().get(0).getSign();
        listSwipeRefresh.setRefreshing(true);
        mPresenter.getQun(id, page, qunSign);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中的tab
                for (int i = 0; i < tags.getData().size(); i++) {
                    if (i == tab.getPosition()) {
                        page = 0;
                        qunSign = tags.getData().get(i).getSign();
                        listSwipeRefresh.setRefreshing(true);
                        mPresenter.getQun(id, page, qunSign);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showError() {
        LogUtils.e("没有更多数据了");
        ToastUtils.setToast("没有更多数据了");
        page--;
    }

    @Override
    public void showJoinQun(int state, Results results) {
        if (results.isSuccess()) ToastUtils.setToast("申请成功");
        else ToastUtils.setToast("网络异常");
        if (state == 1) dialog_free.dismiss();
        if (state == 2) dialog_join.dismiss();
        if (state == 3) dialog_join_v.dismiss();
    }

    @Override
    public void showUsableMoney(int i, UsableMoney usableMoney) {
        if (usableMoney.isSuccess())
            if (i == 0) joinQunDialog(qunBean, usableMoney.getUsableMoney());
            else joinVDialog(memberListBean.getMid(), usableMoney.getUsableMoney());
        else ToastUtils.setToast("网络异常");
    }

    @Override
    public void chkClick(QunList.DataBean dataBean) {
        qunBean = dataBean;
        if (userState == 1) {
            if (isV == 2) {
                if (dataBean.getIsState() != 0) {
                    if (dataBean.getIsfree() == 0) {
                        //免费
                        freeDialog(dataBean.getFid());
                    } else {
                        //收费
                        mPresenter.getUsableMoney(0);
                    }
                }
            } else {
//                approveDialog();
                payMoney();
            }
        } else {
            loginDialog();
        }
    }

    @Override
    public void itemClick(QunList.DataBean.MemberListBean dataBean) {
        memberListBean = dataBean;
        if (userState == 1) {
            if (isV == 2) {
                mPresenter.getUsableMoney(1);
            } else {
//                approveDialog();
                payMoney();
            }
        } else {
            loginDialog();
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
        Display display = mActivity.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_login.setContentView(viewDialog, layoutParams);
        dialog_login.show();
    }

    private void joinVDialog(final int fid, final double money) {
        dialog_join_v = new Dialog(context, R.style.BottomDialog);
        final View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_join_v, null);
        dialog_join_v.setContentView(contentView);
        ((TextView) contentView.findViewById(R.id.join_all_money)).setText("可用余额: " + money + "元");
        ((EditText) contentView.findViewById(R.id.join_shang)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().contains(".")) {
                    if (charSequence.length() - 1 - charSequence.toString().indexOf(".") > 2) {
                        charSequence = charSequence.toString().subSequence(0,
                                charSequence.toString().indexOf(".") + 3);
                        ((EditText) contentView.findViewById(R.id.join_shang)).setText(charSequence);
                        ((EditText) contentView.findViewById(R.id.join_shang)).setSelection(charSequence.length());
                    }
                }
                if (charSequence.toString().trim().substring(0).equals(".")) {
                    charSequence = "0" + charSequence;
                    ((EditText) contentView.findViewById(R.id.join_shang)).setText(charSequence);
                    ((EditText) contentView.findViewById(R.id.join_shang)).setSelection(2);
                }

                if (charSequence.toString().startsWith("0")
                        && charSequence.toString().trim().length() > 1) {
                    if (!charSequence.toString().substring(1, 2).equals(".")) {
                        ((EditText) contentView.findViewById(R.id.join_shang)).setText(charSequence.subSequence(0, 1));
                        ((EditText) contentView.findViewById(R.id.join_shang)).setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        contentView.findViewById(R.id.join_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_join_v.dismiss();
            }
        });
        contentView.findViewById(R.id.join_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentView.findViewById(R.id.join_btn).setFocusable(false);
                double shang = Double.parseDouble("".equals(((EditText) contentView.findViewById(R.id.join_shang)).getText().toString()) ? "0.00" : ((EditText) contentView.findViewById(R.id.join_shang)).getText().toString());
                String wx = "".equals(((EditText) contentView.findViewById(R.id.join_wx)).getText().toString()) ? null : ((EditText) contentView.findViewById(R.id.join_wx)).getText().toString();
                if (wx != null && shang > 0) {
                    if (shang > money) {
                        dialog_join_v.dismiss();
                        rechargeDialog();
                    } else {
                        mPresenter.getJoinQun(3, fid, shang, wx, 3, 1);
                        contentView.findViewById(R.id.join_btn).setFocusable(true);
                    }
                }
            }
        });
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(params);
        dialog_join_v.getWindow().setGravity(Gravity.BOTTOM);
        dialog_join_v.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        dialog_join_v.show();
    }
    private void payMoney(){
      /*  payMoney = etPayMoney.getText().toString().trim() ;
        weinXin = etWeiXin.getText().toString().trim() ;*/

        dialog_paymoney = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDialog = inflater.inflate(R.layout.dialog_paymoney, null);
        viewDialog.findViewById(R.id.paymoney_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*intent = new Intent(context, ApproveActivity.class);
                startActivity(intent);*/
                dialog_paymoney.dismiss();
                /*if (!weinXin.isEmpty()){

                    if(!payMoney.isEmpty()&&payMoney.equals("0")){


                    }else{
                        ToastUtils.setToast("打赏金额不能为空");
                    }
                }else{
                    ToastUtils.setToast("请输入微信名");
                }*/
            }
        });
        Display display = mActivity.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_paymoney.setContentView(viewDialog, layoutParams);
        dialog_paymoney.show();
    }
   /* private void approveDialog() {
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
        Display display = mActivity.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_approve.setContentView(viewDialog, layoutParams);
        dialog_approve.show();
    }*/

    private void joinQunDialog(final QunList.DataBean dataBean, final double money) {
        dialog_join = new Dialog(context, R.style.BottomDialog);
        final View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_join, null);
        dialog_join.setContentView(contentView);
        ((TextView) contentView.findViewById(R.id.join_money)).setText("¥" + dataBean.getFmoney());
        ((TextView) contentView.findViewById(R.id.join_all_money)).setText("可用余额: " + money + "元");
        contentView.findViewById(R.id.join_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_join.dismiss();
            }
        });
        contentView.findViewById(R.id.join_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentView.findViewById(R.id.join_btn).setFocusable(false);
                String wx = "".equals(((EditText) contentView.findViewById(R.id.join_wx)).getText().toString()) ? null : ((EditText) contentView.findViewById(R.id.join_wx)).getText().toString();
                if (wx != null) {
                    if (dataBean.getFmoney() > money) {
                        dialog_join.dismiss();
                        rechargeDialog();
                    } else
                        mPresenter.getJoinQun(2, dataBean.getFid(), dataBean.getFmoney(), wx, 1, 0);
                }
            }
        });
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(params);
        dialog_join.getWindow().setGravity(Gravity.BOTTOM);
        dialog_join.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        dialog_join.show();
    }

    private void rechargeDialog() {
        dialog_recharge = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View viewDialog = inflater.inflate(R.layout.dialog_recharge, null);
        viewDialog.findViewById(R.id.service_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_recharge.dismiss();
            }
        });
        viewDialog.findViewById(R.id.service_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, RechargeActivity.class);
                startActivity(intent);
                dialog_recharge.dismiss();
            }
        });
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_recharge.setContentView(viewDialog, layoutParams);
        dialog_recharge.show();
    }

    private void freeDialog(final int i) {
        dialog_free = new SelectDialog(context, R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View viewDialog = inflater.inflate(R.layout.dialog_free, null);
        viewDialog.findViewById(R.id.free_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_free.dismiss();
            }
        });
        viewDialog.findViewById(R.id.free_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wx = "".equals(((EditText) viewDialog.findViewById(R.id.free_edit)).getText().toString()) ? null : ((EditText) viewDialog.findViewById(R.id.free_edit)).getText().toString();
                if (wx != null) mPresenter.getJoinQun(1, i, 0, wx, 1, 0);
            }
        });
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog_free.setContentView(viewDialog, layoutParams);
        dialog_free.show();
    }
}
