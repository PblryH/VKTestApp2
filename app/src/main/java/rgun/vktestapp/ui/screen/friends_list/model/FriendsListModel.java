package rgun.vktestapp.ui.screen.friends_list.model;

/**
 * Created by rgun on 25.08.16.
 */
public interface FriendsListModel {

    /**
     * Получить друзей
     * @param callBack {@link GetFriendsCallBack}
     */
    void getFriends(GetFriendsCallBack callBack);

    /**
     * Очистить кэш
     */
    void clearCache();


    /**
     * Колбэк при запросе списка друзей
     */
    interface GetFriendsCallBack{

        /**
         * При успешном ответе
         * @param friends {@link FriendModel.List} список друзей
         */
        void onSuccess(FriendModel.List friends);

        /**
         * При ошибке
         * @param error сообщение об ошибке
         */
        void onError(String error);
    }
}
