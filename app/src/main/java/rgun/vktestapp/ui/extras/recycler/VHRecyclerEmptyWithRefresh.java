package rgun.vktestapp.ui.extras.recycler;

import android.view.View;

import butterknife.BindView;
import rgun.vktestapp.R;

/**
 * Common View Holder for RecyclerViewEmptySupport  with pull-to-refresh
 * Created by rgun on 25.05.16.
 */
public class VHRecyclerEmptyWithRefresh extends VHRecyclerEmpty {

    @BindView(R.id.swipeRefreshLayout)
    public FrameSwipeRefreshLayout swipeRefreshLayout;

    public VHRecyclerEmptyWithRefresh(View v) {
        super(v);
        swipeRefreshLayout.setListView(recyclerView);
    }
}
