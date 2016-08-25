package rgun.vktestapp.ui.screen.friends_list.view;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListViewImpl implements FriendsListView {

    private AppCompatActivity mActivity;
    private FriendsListVH vh;

    public FriendsListViewImpl(AppCompatActivity activity) {
        mActivity = activity;
        vh = new FriendsListVH(mActivity);
    }

}
