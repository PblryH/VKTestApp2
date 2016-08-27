package rgun.vktestapp.ui.screen.friends_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModel;
import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModelImpl;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenterImpl;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListView;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListViewImpl;

public class FriendsListActivity extends AppCompatActivity {

    private FriendsListView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FriendsListModel model = new FriendsListModelImpl();
        mView = new FriendsListViewImpl(this);
        new FriendsListPresenterImpl(mView, model);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return mView.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mView.onOptionsItemSelected(item);
    }
}
