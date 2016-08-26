package rgun.vktestapp.ui.screen.friends_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModel;
import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModelImpl;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenterImpl;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListView;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListViewImpl;

public class FriendsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FriendsListModel model = new FriendsListModelImpl(this);
        FriendsListView view = new FriendsListViewImpl(this);
        new FriendsListPresenterImpl(view, model);

    }
}
