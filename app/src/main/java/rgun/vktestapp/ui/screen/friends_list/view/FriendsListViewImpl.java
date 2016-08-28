package rgun.vktestapp.ui.screen.friends_list.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import rgun.vktestapp.R;
import rgun.vktestapp.ui.extras.DividerItemDecoration;
import rgun.vktestapp.ui.screen.auth.AuthActivity;
import rgun.vktestapp.ui.screen.friends_list.model.FriendModel;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenter;

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
    private FriendsListPresenter mPresenter;
    private boolean firstInit = true;

    private void initToolbar() {
        // настраиваем action bar
        mActivity.setSupportActionBar(vh.toolbar);
        mActivity.getSupportActionBar().setTitle(mActivity.getString(R.string.friends));
    }

    private void initAdapter() {
        mAdapter = new FriendsListAdapter(mActivity, IMAGE_SIDE_VIEW_IN_DIP);
    }

    private void initRecyclerView(){
        mLayoutManager = new LinearLayoutManager(mActivity);
        vh.recycler.recyclerView.setEmptyView(vh.recycler.empty);
        vh.recycler.recyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
        vh.recycler.recyclerView.setLayoutManager(mLayoutManager);
        vh.recycler.recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setFriendsToList(ArrayList<FriendModel> friends) {
        vh.recycler.recyclerView.scrollToPosition(0);
        mAdapter.clear();
        mAdapter.addAll(friends);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.clearCache) {
            mPresenter.onClearCacheClick();
            return true;
        }
        if (id == R.id.exit) {
            mPresenter.onExitClick();
            return true;
        }
        return false;
    }

    @Override
    public void showToast(String error) {
        Toast.makeText(mActivity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearList() {
        vh.recycler.recyclerView.scrollToPosition(0);
        mAdapter.clear();
    }

    @Override
    public void setPullToRefreshState(boolean b) {
        vh.recycler.swipeRefreshLayout.setRefreshing(b);
    }

    @Override
    public void openAuthScreen() {
        mActivity.startActivity(new Intent(mActivity, AuthActivity.class));
        mActivity.finish();
    }

    @Override
    public void showExitDialog(final ExitDialogListener listener) {
        AlertDialog.Builder adb = new AlertDialog.Builder(mActivity)
                .setTitle(mActivity.getString(R.string.exitDialogTitle))
                .setMessage(mActivity.getString(R.string.exitDialogMessage))
                .setPositiveButton(mActivity.getString(R.string.btnYes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onExit();
                    }
                })
                .setNegativeButton(mActivity.getString(R.string.btnNo), null);
        adb.create().show();
    }

    @Override
    public void showClearCacheDialog(final ClearCacheDialogListener listener) {
        AlertDialog.Builder adb = new AlertDialog.Builder(mActivity)
                .setTitle(mActivity.getString(R.string.clearCacheDialogTitle))
                .setMessage(mActivity.getString(R.string.clearCacheDialogMessage))
                .setPositiveButton(mActivity.getString(R.string.btnOnlyCache), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onClearCache();
                    }
                })
                .setNeutralButton(mActivity.getString(R.string.btnCacheAndList), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onClearCacheAndList();
                    }
                })
                .setNegativeButton(mActivity.getString(R.string.btnCancel), null);
        adb.create().show();
    }

    @Override
    public void onRefresh() {
        mPresenter.onPullToRefresh();
    }

    @Override
    public void setPresenter(FriendsListPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void bindActivity(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void unbindActivity() {
        vh.unbind();
    }

    @Override
    public void initView(LayoutInflater inflater, ViewGroup view) {
        vh = new FriendsListVH(inflater, view);
        initToolbar();
        if (firstInit) {
            initAdapter();
        }
        initRecyclerView();
        vh.recycler.swipeRefreshLayout.setOnRefreshListener(this);
        if (firstInit){
            mPresenter.getFriends();
        }
        firstInit = false;
    }

    @Override
    public View getView() {
        return vh.getView();
    }
}
