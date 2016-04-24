package rgun.vktestapp.screen.photo.list;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import rgun.vktestapp.R;
import rgun.vktestapp.screen.photo.a01_extras.PhotoModel;
import rgun.vktestapp.screen.photo.list.recycler_view.PhotoRecyclerViewAdapter;

/**
 * Created by rgun on 26.09.15.
 */
public class UiPhotoList {

    public static final int IMAGE_SIDE_VIEW_IN_DIP = 96;

    private AppCompatActivity mActivity;
    private VH vh;

    UiPhotoList(AppCompatActivity activity) {
        mActivity = activity;
        activity.setContentView(R.layout.activity_photo_list);
        vh = new VH(activity);
        initRecyclerView();
    }

    private void initRecyclerView(){
        LinearLayoutManager llm = new LinearLayoutManager(mActivity);
        vh.recyclerView.setLayoutManager(llm);
        vh.recyclerView.setHasFixedSize(true);
    }

    public void fillPhotos(
            final List<PhotoModel> photos,
            PhotoRecyclerViewAdapter.OnItemClickListener onItemClickListener) {

        PhotoRecyclerViewAdapter adapter
                = new PhotoRecyclerViewAdapter(mActivity, photos, IMAGE_SIDE_VIEW_IN_DIP);
        adapter.setOnItemClickListener(onItemClickListener);
        vh.recyclerView.setAdapter(adapter);
    }

    /**
     * ViewHolder
     */
    private static class VH {

        private RecyclerView recyclerView;

        public VH(Activity activity) {
            recyclerView = (RecyclerView) activity.findViewById(R.id.list);
        }
    }
}

