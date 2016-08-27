package rgun.vktestapp.ui.screen.friends_list.view;

import android.support.v7.app.AppCompatActivity;

import rgun.vktestapp.R;
import rgun.vktestapp.ui.extras.VHContentWithToolbar;
import rgun.vktestapp.ui.extras.VHRecyclerEmptyWithRefresh;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListVH extends VHContentWithToolbar {

    public static final int layout = R.layout.activity_friends_list;

    public VHRecyclerEmptyWithRefresh recycler;

    public FriendsListVH(AppCompatActivity activity) {
        super(activity);
        recycler = new VHRecyclerEmptyWithRefresh(activity);
    }

    @Override
    public int getLayoutRes() {
        return layout;
    }
}
