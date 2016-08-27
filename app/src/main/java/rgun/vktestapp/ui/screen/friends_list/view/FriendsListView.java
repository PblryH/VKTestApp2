package rgun.vktestapp.ui.screen.friends_list.view;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import rgun.vktestapp.ui.extras.BaseViewMvp;
import rgun.vktestapp.ui.screen.friends_list.model.FriendModel;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenter;

/**
 * Created by rgun on 25.08.16.
 */
public interface FriendsListView extends BaseViewMvp<FriendsListPresenter> {

    void setFriendsToList(ArrayList<FriendModel> friends);

    boolean onCreateOptionsMenu(Menu menu);

    boolean onOptionsItemSelected(MenuItem item);

    void showToast(String error);

    void clearList();

    void setPullToRefreshState(boolean b);

    void openAuthScreen();

    void showExitDialog(ExitDialogListener listener);

    void showClearCacheDialog(ClearCacheDialogListener listener);

    interface ExitDialogListener {

        void onExit();

    }

    interface ClearCacheDialogListener {

        void onClearCache();

        void onClearCacheAndList();

    }
}
