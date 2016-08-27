package rgun.vktestapp.ui.extras;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import rgun.vktestapp.R;


/**
 * Created by rgun on 22.06.16.
 */
public class VHRecyclerEmpty {

    public RecyclerViewEmptySupport recyclerView;
    public View empty;

    public VHRecyclerEmpty(AppCompatActivity activity){
        this(activity.findViewById(android.R.id.content));
    }

    public VHRecyclerEmpty(View v) {
        recyclerView = (RecyclerViewEmptySupport) v.findViewById(R.id.list);
        empty = v.findViewById(R.id.list_empty);
    }
}
