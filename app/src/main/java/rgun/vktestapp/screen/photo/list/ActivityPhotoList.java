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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rgun.vktestapp.Application;
import rgun.vktestapp.R;
import rgun.vktestapp.screen.photo.PhotoModel;
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


    private void executeVKRequestPhotos(){
        VKRequest request = new VKRequest(METHOD_PHOTOS_GET, VKParameters.from(
                VKApiConst.COUNT, VALUE_PHOTO_COUNT,
                VKApiConst.PHOTO_SIZES, VALUE_PHOTO_SIZES,
                PARAM_SKIP_HIDDEN, VALUE_SKIP_HIDDEN));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                final ArrayList<PhotoModel> photos = getPhotosFromJson(response.json);
                Log.d(Application.LOG_TAG, "photos number " + photos.size());
                uiPhotoList.initPhotoRecyclerViewAdapter(photos, new PhotoRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        startActivityPhotoView(photos.get(position));
                    }
                });
            }

            @Override
            public void onError(VKError error) {
                Log.d(Application.LOG_TAG, "VKError " + error.errorMessage);
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                Log.d(Application.LOG_TAG, "attemptFailed " + String.valueOf(attemptNumber));
            }
        });
    }

    private ArrayList<PhotoModel> getPhotosFromJson(JSONObject jsonObject){
        ArrayList<PhotoModel> photos = new ArrayList<>();
        try {
            JSONArray items = jsonObject.getJSONObject("response").getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSONArray sizes = items.getJSONObject(i).getJSONArray("sizes");
                String src = sizes.getJSONObject(sizes.length()-1).getString("src");
                String text = "";
                if (items.getJSONObject(i).has("text")) {
                    text = items.getJSONObject(i).getString("text");
                }
                if(text.isEmpty()){
                    text = getString(R.string.photo_empty_name);
                }
                photos.add(new PhotoModel(text, src));
            }
        } catch (JSONException e) {
            Log.d(Application.LOG_TAG, "photos src parse error", e);
        }
        photos.size();
        return photos;
    }
    
    private void startActivityPhotoView(PhotoModel photo){
        Intent intent = new Intent(ActivityPhotoList.this,ActivityPhotoView.class);
        intent.putExtra(ActivityPhotoView.INTENT_EXTRA_PHOTO, photo);
        startActivity(intent);
        Toast.makeText(ActivityPhotoList.this, photo.name, Toast.LENGTH_SHORT).show();
    }
}
