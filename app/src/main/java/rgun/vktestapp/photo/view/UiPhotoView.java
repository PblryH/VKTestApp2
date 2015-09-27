package rgun.vktestapp.photo.view;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import rgun.vktestapp.R;
import rgun.vktestapp.photo.LoadImageToPhotoContainer;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by rgun on 27.09.15.
 */
public class UiPhotoView {

    private AppCompatActivity mActivity;

    UiPhotoView(AppCompatActivity activity){
        mActivity = activity;
        mActivity.setContentView(R.layout.activity_photo_view);
        mActivity.getSupportActionBar().hide();
    }

    public void loadImage(String url) {
        LoadImageToPhotoContainer loadImageToPhotoContainer = new LoadImageToPhotoContainer(
                new LoadImageToPhotoContainer.OnImageLoadListener() {
                    @Override
                    public void onLoad() {
                        ImageView image = (ImageView) mActivity.findViewById(R.id.photo);
                        PhotoViewAttacher attacher = new PhotoViewAttacher(image);
                        attacher.update();
                    }
                });
        loadImageToPhotoContainer.loadImage(mActivity, url, null, mActivity.findViewById(R.id.photo_container));
    }
}
