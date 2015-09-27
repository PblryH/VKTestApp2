package rgun.vktestapp.photo.list;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import rgun.vktestapp.R;
import rgun.vktestapp.photo.PhotoPojo;

/**
 * Created by rgun on 26.09.15.
 */
public class UiPhotoList {

    public static final int IMAGE_SIDE_VIEW_IN_DIP = 96;

    private AppCompatActivity mActivity;
    private RecyclerView recyclerView;

    UiPhotoList(AppCompatActivity activity){
        mActivity = activity;
        activity.setContentView(R.layout.activity_photo_list);
        recyclerView = (RecyclerView) activity.findViewById(R.id.list);
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
    }

    public void initPhotoRecyclerViewAdapter(final List<PhotoPojo> photos, PhotoRecyclerViewAdapter.OnItemClickListener onItemClickListener){
        PhotoRecyclerViewAdapter adapter = new PhotoRecyclerViewAdapter(mActivity,photos, IMAGE_SIDE_VIEW_IN_DIP);
        adapter.setOnItemClickListener(onItemClickListener);
        recyclerView.setAdapter(adapter);
    }
}

