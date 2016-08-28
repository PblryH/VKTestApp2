package rgun.vktestapp.ui.extras.recycler;

import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import rgun.vktestapp.R;


/**
 * Common View Holder for RecyclerViewEmptySupport
 * Created by rgun on 22.06.16.
 */
public class VHRecyclerEmpty {

    @BindView(R.id.list)
    public RecyclerViewEmptySupport recyclerView;

    @BindView(R.id.list_empty)
    public View empty;


    public VHRecyclerEmpty(View v) {
        ButterKnife.bind(this, v);
    }
}
