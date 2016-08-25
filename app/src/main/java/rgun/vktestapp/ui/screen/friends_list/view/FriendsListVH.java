package rgun.vktestapp.ui.screen.friends_list.view;

import android.support.v7.app.AppCompatActivity;

import rgun.vktestapp.R;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListVH {

    public static final int layout = R.layout.activity_friends_list;

    private AppCompatActivity mActivity;

    public FriendsListVH(AppCompatActivity activity) {
        mActivity = activity;
        mActivity.setContentView(layout);
    }
}
