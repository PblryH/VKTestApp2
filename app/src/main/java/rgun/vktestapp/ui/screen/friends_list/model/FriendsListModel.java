package rgun.vktestapp.ui.screen.friends_list.model;

/**
 * Created by rgun on 25.08.16.
 */
public interface FriendsListModel {

    void getFriends(GetFriendsCallBack callBack);


    interface GetFriendsCallBack{

        void onSuccess(FriendModel.List friends);

        void onError(String error);
    }
}
