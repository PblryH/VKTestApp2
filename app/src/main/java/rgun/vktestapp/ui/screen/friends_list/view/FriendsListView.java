package rgun.vktestapp.ui.screen.friends_list.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import rgun.vktestapp.ui.extras.architecture.BaseView;
import rgun.vktestapp.ui.screen.friends_list.model.FriendModel;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenter;

/**
 * Created by rgun on 25.08.16.
 */
public interface FriendsListView extends BaseView<FriendsListPresenter> {

    /**
     * Заполнить список друзей
     * @param friends
     */
    void setFriendsToList(ArrayList<FriendModel> friends);

    /**
     * При вызове Fragment#onCreateOptionsMenu
     */
    boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater);

    /**
     * При вызове Fragment#onOptionsItemSelected
     */
    boolean onOptionsItemSelected(MenuItem item);

    /**
     * Показать тоаст
     * @param s сообщение
     */
    void showToast(String s);

    /**
     * Показать тоаст
     * @param messages сообщение
     */
    void showToast(FriendsListMessages messages);

    /**
     * Очистить список
     */
    void clearList();

    /**
     * Установить состояние индикатора обновления pull-to-refresh
     * @param b
     */
    void setPullToRefreshState(boolean b);

    /**
     * Открыть экран авторизации
     */
    void openAuthScreen();

    /**
     * Показать диалог выхода
     * @param listener {@link ExitDialogListener}
     */
    void showExitDialog(ExitDialogListener listener);

    /**
     * Показать диалог очистки кэша
     * @param listener {@link ClearCacheDialogListener}
     */
    void showClearCacheDialog(ClearCacheDialogListener listener);

    /**
     * Листнер диалога выхода
     */
    interface ExitDialogListener {

        /**
         * При выходе
         */
        void onExit();

    }

    /**
     * Листнер диалога очистки кэша
     */
    interface ClearCacheDialogListener {

        /**
         * При очистке только кэша
         */
        void onClearCache();

        /**
         * При очистке кэша и списка
         */
        void onClearCacheAndList();

    }
}
