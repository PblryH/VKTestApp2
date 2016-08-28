package rgun.vktestapp.ui.screen.friends_list.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import rgun.vktestapp.R;
import rgun.vktestapp.ui.extras.VHContentWithToolbar;
import rgun.vktestapp.ui.extras.VHRecyclerEmptyWithRefresh;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListVH extends VHContentWithToolbar {

    public static final int layout = R.layout.fragment_friends_list;

    public VHRecyclerEmptyWithRefresh recycler;

    public FriendsListVH(LayoutInflater inflater, ViewGroup view) {
        super(inflater, view);
        recycler = new VHRecyclerEmptyWithRefresh(getView());
    }

    @Override
    public int getLayoutRes() {
        return layout;
    }
}
