package rgun.vktestapp.ui.screen.friends_list.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import rgun.vktestapp.ui.extras.DividerItemDecoration;
import rgun.vktestapp.ui.screen.friends_list.model.FriendModel;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListViewImpl implements
        FriendsListView,
        SwipeRefreshLayout.OnRefreshListener {


    public static final int IMAGE_SIDE_VIEW_IN_DIP = 96;

    private AppCompatActivity mActivity;
    private FriendsListVH vh;
    private LinearLayoutManager mLayoutManager;
    private FriendsListAdapter mAdapter;

    public FriendsListViewImpl(AppCompatActivity activity) {
        mActivity = activity;
        mActivity.setContentView(FriendsListVH.layout);
        vh = new FriendsListVH(mActivity);
        initAdapter();
        vh.swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initAdapter() {
        vh.recyclerView.setEmptyView(vh.empty);
        vh.recyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
        mLayoutManager = new LinearLayoutManager(mActivity);
        vh.recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FriendsListAdapter(mActivity,IMAGE_SIDE_VIEW_IN_DIP);
        vh.recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setFriendsToList(ArrayList<FriendModel> friends) {
        mAdapter.addAll(friends);
    }

    @Override
    public void onRefresh() {

    }
}
