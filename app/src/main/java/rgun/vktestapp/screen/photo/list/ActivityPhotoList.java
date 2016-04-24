package rgun.vktestapp.screen.photo.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import rgun.vktestapp.Application;
import rgun.vktestapp.screen.photo.PhotoModel;
import rgun.vktestapp.screen.photo.list.recycler_view.PhotoRecyclerViewAdapter;
import rgun.vktestapp.screen.photo.view.ActivityPhotoView;

public class ActivityPhotoList extends AppCompatActivity {

    public static final String METHOD_PHOTOS_GET = "photos.getAll";
    public static final String PARAM_SKIP_HIDDEN = "skip_hidden";

    public static final String VALUE_PHOTO_COUNT = "20";
    public static final String VALUE_PHOTO_SIZES = "1";
    public static final int VALUE_SKIP_HIDDEN = 1;

    private UiPhotoList uiPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiPhotoList = new UiPhotoList(this);
        executeVKRequestPhotos();
    }


    private void executeVKRequestPhotos() {

        VKRequest request = new VKRequest(
                METHOD_PHOTOS_GET,
                VKParameters.from(
                        VKApiConst.COUNT,
                        VALUE_PHOTO_COUNT,
                        VKApiConst.PHOTO_SIZES,
                        VALUE_PHOTO_SIZES,
                        PARAM_SKIP_HIDDEN,
                        VALUE_SKIP_HIDDEN));

        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                final PhotoModel.List photos = PhotoModel.getPhotosFromJson(response.json);
                Log.d(Application.LOG_TAG, "photos number " + photos.size());
                fillPhoto(photos);
            }

            @Override
            public void onError(VKError error) {
                if(error != null && !error.errorMessage.isEmpty())
                Toast.makeText(ActivityPhotoList.this, error.errorMessage, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                Log.d(Application.LOG_TAG, "attemptFailed " + String.valueOf(attemptNumber));
            }
        });
    }

    private void fillPhoto(final PhotoModel.List photos){
        uiPhotoList.fillPhotos(photos, new PhotoRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivityPhotoView(photos.get(position));
            }
        });
    }


    private void startActivityPhotoView(PhotoModel photo) {
        Intent intent = new Intent(ActivityPhotoList.this, ActivityPhotoView.class);
        intent.putExtra(ActivityPhotoView.INTENT_EXTRA_PHOTO, photo);
        startActivity(intent);
        Toast.makeText(ActivityPhotoList.this, photo.name, Toast.LENGTH_SHORT).show();
    }
}
