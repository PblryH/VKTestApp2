package rgun.vktestapp.ui.screen.friends_list.presenter;

import rgun.vktestapp.ui.screen.friends_list.model.FriendModel;
import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModel;
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
        }

        @Override
        public void onError(String error) {

        }
    };

    public FriendsListPresenterImpl(FriendsListView view, FriendsListModel model) {
        mView = view;
        mModel = model;
        mModel.getFriends(mGetFriendsCallBack);
    }
}
