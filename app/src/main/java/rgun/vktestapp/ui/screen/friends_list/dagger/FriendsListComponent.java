package rgun.vktestapp.ui.screen.friends_list.dagger;


import dagger.Component;
import rgun.vktestapp.ui.extras.architecture.PerActivity;
import rgun.vktestapp.ui.screen.friends_list.FriendsListFragment;

/**
 * Created by rgun on 27.07.16.
 */
@PerActivity
@Component(modules = FriendsListModule.class)
public interface FriendsListComponent {
    void inject(FriendsListFragment fragment);
}
