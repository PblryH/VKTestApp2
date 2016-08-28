package rgun.vktestapp.ui.screen.friends_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import rgun.vktestapp.ui.extras.architecture.BaseRetainFragment;
import rgun.vktestapp.ui.screen.friends_list.dagger.DaggerFriendsListComponent;
import rgun.vktestapp.ui.screen.friends_list.dagger.FriendsListComponent;
import rgun.vktestapp.ui.screen.friends_list.dagger.FriendsListModule;
import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModel;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenter;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListView;

/**
 * Created by rgun on 27.08.16.
 */
public class FriendsListFragment extends BaseRetainFragment<FriendsListView> {

    @Inject
    protected FriendsListModel mModel;

    @Inject
    protected FriendsListPresenter mPresenter;

    @Inject
    protected FriendsListView mView;

    @Override
    protected void initInjection() {
        FriendsListComponent component = DaggerFriendsListComponent.builder()
                .friendsListModule(new FriendsListModule())
                .build();
        component.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        mView.initView(inflater, container);
        return mView.getView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mView.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mView.onOptionsItemSelected(item);
    }
}
