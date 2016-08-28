package rgun.vktestapp.ui.screen.friends_list.dagger;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import rgun.vktestapp.ui.extras.architecture.PerActivity;
import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModel;
import rgun.vktestapp.ui.screen.friends_list.model.FriendsListModelImpl;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenter;
import rgun.vktestapp.ui.screen.friends_list.presenter.FriendsListPresenterImpl;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListView;
import rgun.vktestapp.ui.screen.friends_list.view.FriendsListViewImpl;

/**
 * Created by rgun on 27.07.16.
 */
@Module
public class FriendsListModule {

    @PerActivity
    @Provides
    FriendsListPresenter provideFriendsListPresenter(FriendsListView view, FriendsListModel model){
        return new FriendsListPresenterImpl(view, model);
    }

    @PerActivity
    @Provides
    @Inject
    FriendsListModel provideFriendsListModel(){
        return new FriendsListModelImpl();
    }

    @PerActivity
    @Provides
    FriendsListView provideFriendsListView(){
        return new FriendsListViewImpl();
    }
}
