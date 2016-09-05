package rgun.vktestapp.ui.screen.friends_list.presenter;

import com.vk.sdk.VKSdk;

import rgun.vktestapp.ui.screen.friends_list.model.FriendModel;
import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModel;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListMessages;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListView;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListPresenterImpl implements FriendsListPresenter {

    private final FriendsListView mView;
    private final FriendsListModel mModel;

    private FriendsListModel.GetFriendsCallBack mGetFriendsCallBack = new FriendsListModel.GetFriendsCallBack() {
        @Override
        public void onSuccess(FriendModel.List friends) {
            mView.setFriendsToList(friends);
            mView.setPullToRefreshState(false);
        }

        @Override
        public void onError(String error) {
            mView.showToast(error);
            mView.setPullToRefreshState(false);
        }
    };

    public FriendsListPresenterImpl(FriendsListView view, FriendsListModel model) {
        mView = view;
        mView.setPresenter(this);
        mModel = model;
    }

    @Override
    public void onExitClick() {
        mView.showExitDialog(new FriendsListView.ExitDialogListener() {
            @Override
            public void onExit() {
                mModel.clearCache();
                VKSdk.logout();
                mView.openAuthScreen();
            }
        });
    }

    @Override
    public void onClearCacheClick() {
        mView.showClearCacheDialog(new FriendsListView.ClearCacheDialogListener() {
            @Override
            public void onClearCache() {
                mModel.clearCache();
                mView.showToast(FriendsListMessages.CACHE_CLEARED);
            }

            @Override
            public void onClearCacheAndList() {
                mModel.clearCache();
                mView.clearList();
                mView.showToast(FriendsListMessages.CACHE_CLEARED);
            }
        });
    }

    @Override
    public void onPullToRefresh() {
        getFriends();
    }

    @Override
    public void getFriends() {
        mModel.getFriends(mGetFriendsCallBack);
    }
}
