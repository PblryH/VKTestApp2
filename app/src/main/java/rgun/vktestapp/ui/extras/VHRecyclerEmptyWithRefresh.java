package rgun.vktestapp.ui.extras;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import rgun.vktestapp.R;

/**
 * Created by rgun on 25.05.16.
 */
public class VHRecyclerEmptyWithRefresh extends VHRecyclerEmpty{

    public FrameSwipeRefreshLayout swipeRefreshLayout;

    public VHRecyclerEmptyWithRefresh(AppCompatActivity activity){
        this(activity.findViewById(android.R.id.content));
    }

    public VHRecyclerEmptyWithRefresh(View v) {
        super(v);
        swipeRefreshLayout = (FrameSwipeRefreshLayout) v.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setListView(recyclerView);
    }
}
