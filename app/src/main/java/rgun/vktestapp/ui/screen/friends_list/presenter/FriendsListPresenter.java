package rgun.vktestapp.ui.screen.friends_list.presenter;

/**
 * Created by rgun on 25.08.16.
 */
public interface FriendsListPresenter {

    /**
     * При нажатии на кнопку выход
     */
    void onExitClick();

    /**
     * При нажатии на кнопку очистить кэш
     */
    void onClearCacheClick();

    /**
     * При обновлении списка
     */
    void onPullToRefresh();

    /**
     * Запрашивается получение друзей
     */
    void getFriends();
}
