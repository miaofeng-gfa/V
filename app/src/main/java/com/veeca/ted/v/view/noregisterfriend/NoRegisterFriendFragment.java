package com.veeca.ted.v.view.noregisterfriend;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.veeca.ted.v.R;
import com.veeca.ted.v.adapter.NoRegisterFriendAdapter;
import com.veeca.ted.v.bean.NoRegisterFriend;
import com.veeca.ted.v.bean.mian.UserInfo;
import com.veeca.ted.v.utils.LogUtils;
import com.veeca.ted.v.utils.MediaHelper;
import com.veeca.ted.v.utils.ToastUtils;
import com.veeca.ted.v.view.mvp.MVPBaseFragment;
import com.veeca.ted.v.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class NoRegisterFriendFragment extends MVPBaseFragment<NoRegisterFriendContract.View, NoRegisterFriendPresenter> implements NoRegisterFriendContract.View {

    @BindView(R.id.layout_null)
    LinearLayout layoutNull;
    @BindView(R.id.list_recycler)
    RecyclerView listRecycler;
    @BindView(R.id.list_swipe_refresh)
    SwipeRefreshLayout listSwipeRefresh;
    Unbinder unbinder;
    private Context context;
    private int page ;
    private Intent intent;
    private List<NoRegisterFriend.DataBean> registerFriendLists = new ArrayList<>();
    private int lastVisibleItem;
    private LinearLayoutManager layoutManager;
    private NoRegisterFriendAdapter noRegisterFriendAdapter;
    private String qrcode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friendregister_list, null);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        page = 0;
        initData();
        getTask(page);
        setListener();
        return view;
    }

    private void initData() {
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listRecycler.setLayoutManager(layoutManager);

        listSwipeRefresh.setColorSchemeResources(R.color.yellow);
        listSwipeRefresh.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
        listRecycler.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.HORIZONTAL, 1, context.getResources().getColor(R.color.font_gray_d1)));
        noRegisterFriendAdapter = new NoRegisterFriendAdapter(context);

        listRecycler.setAdapter(noRegisterFriendAdapter);
    }

    private void getTask(int page) {
        mPresenter.getNotRegisterFriend(page);
        mPresenter.getUserInfo();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setListener() {
        listSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               /* page = 0;
                taskLists.clear();
                taskListAdapter.clear();*/
                getTask(page);
            }
        });
        listRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 0：当前屏幕停止滚动；1时：屏幕在滚动 且 用户仍在触碰或手指还在屏幕上；2时：随用户的操作，屏幕上产生的惯性滑动；
                // 滑动状态停止并且剩余两个item时自动加载
                if (newState == RecyclerView.SCROLL_STATE_IDLE || newState == RecyclerView.SCROLL_STATE_DRAGGING)
                    if (lastVisibleItem + 2 >= layoutManager.getItemCount()) {
                        page++;
                        getTask(page);
//                        listSwipeRefresh.setRefreshing(true);
                    }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                //获取播放条目的下标
                int currentPosition = noRegisterFriendAdapter.currentPosition;
                // 获取加载的最后一个可见视图在适配器的位置。
//                lastVisibleItem = layoutManager.findLastVisibleItemPosition();

                if ((firstVisibleItemPosition > currentPosition || lastVisibleItemPosition < currentPosition) && currentPosition > -1) {
                    //让播放隐藏的条目停止
                    MediaHelper.release();
                    noRegisterFriendAdapter.currentPosition = -1;
                    noRegisterFriendAdapter.notifyDataSetChanged();
                }
            }

        });
    }

    @Override
    public void showError() {
        listSwipeRefresh.setRefreshing(false);
        if (page > 0)
            page--;
        ToastUtils.setToast("没有更多的任务了");
    }



    public void  showNotRegisterFriend(NoRegisterFriend noRegisterFriend){
        LogUtils.e("jjjjjjjjjjjj==="+noRegisterFriend.toString());


        listSwipeRefresh.setRefreshing(false);
        if (page == 0 && noRegisterFriend.getData().size() == 0) {
            listSwipeRefresh.setVisibility(View.VISIBLE);
        } else if (page != 0 && noRegisterFriend.getData().size() == 0) {
            layoutNull.setVisibility(View.GONE);
            listSwipeRefresh.setVisibility(View.VISIBLE);
        }
        this.registerFriendLists.addAll(noRegisterFriend.getData());
        noRegisterFriendAdapter.setTaskLists(this.registerFriendLists);
        noRegisterFriendAdapter.notifyDataSetChanged();
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        qrcode = userInfo.getData().getQrCode();
        LogUtils.e("ooooooooooooooooppppp==="+qrcode);
        noRegisterFriendAdapter.setQrcode(qrcode);
    }

}
