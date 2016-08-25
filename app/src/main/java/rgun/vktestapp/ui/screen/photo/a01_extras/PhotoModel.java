package rgun.vktestapp.ui.screen.photo.a01_extras;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import rgun.vktestapp.Application;
import rgun.vktestapp.R;

/**
 * Created by rgun on 24.09.15.
 */
public class PhotoModel implements Serializable {

    private static final long serialVersionUID = -1097257131516796924L;

    public String name;
    public String url;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public PhotoModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    public static List getPhotosFromJson(JSONObject jsonObject) {
        List photos = new List();
        try {
            JSONArray items = jsonObject.getJSONObject("response").getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSONArray sizes = items.getJSONObject(i).getJSONArray("sizes");
                String src = sizes.getJSONObject(sizes.length() - 1).getString("src");
                String text = "";
                if (items.getJSONObject(i).has("text")) {
                    text = items.getJSONObject(i).getString("text");
                }
                if (text.isEmpty()) {
                    text = Application.context.getString(R.string.photo_empty_name);
                }
                photos.add(new PhotoModel(text, src));
            }
        } catch (JSONException e) {
            Log.d(Application.LOG_TAG, "photos src parse error", e);
        }
        photos.size();
        return photos;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Static classes
    ///////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("serial")
    public static class List extends ArrayList<PhotoModel> {
    }


}

