package rgun.vktestapp.screen.photo.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import rgun.vktestapp.R;
import rgun.vktestapp.screen.photo.a01_extras.photo_container.ContainerPhotoVH;
import rgun.vktestapp.screen.photo.a01_extras.photo_container.LoadImageToPhotoContainer;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by rgun on 27.09.15.
 */
public class UiPhotoView {

    private AppCompatActivity mActivity;
    private VH vh;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    UiPhotoView(AppCompatActivity activity){
        mActivity = activity;
        mActivity.setContentView(R.layout.activity_photo_view);
        vh = new VH(mActivity);
        mActivity.getSupportActionBar().hide();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    public void loadImage(String url) {
        LoadImageToPhotoContainer loadImageToPhotoContainer = new LoadImageToPhotoContainer(
                new LoadImageToPhotoContainer.OnImageLoadListener() {
                    @Override
                    public void onLoad() {
                        PhotoViewAttacher attacher = new PhotoViewAttacher(vh.photoVH.photo);
                        attacher.update();
                    }
                });
        loadImageToPhotoContainer.loadImage(mActivity, url, null, vh.photoContainer);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Static classes
    ///////////////////////////////////////////////////////////////////////////

    /**
     * ViewHolder
     */
    private static class VH {

        private View photoContainer;
        private ContainerPhotoVH photoVH;

        public VH(Activity activity) {
            photoContainer = activity.findViewById(R.id.photoContainer);
            photoVH = new ContainerPhotoVH(photoContainer);
        }
    }
}
