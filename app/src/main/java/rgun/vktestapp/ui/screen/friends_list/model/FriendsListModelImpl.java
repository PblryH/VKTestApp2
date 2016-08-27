package rgun.vktestapp.ui.screen.friends_list.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import org.json.JSONException;

import java.io.IOException;

import rgun.vktestapp.Application;
import rgun.vktestapp.utils.SimpleDiskCache;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListModelImpl implements FriendsListModel {

    public static final String METHOD_PHOTOS_GET = "friends.get";
    public static final String ADDITIONAL_FIELD_PHOTO = "photo_200_orig";
    public static final String CACHE_KEY = "friendslist";

    private GetFriendsCallBack mCallBack;
    private SimpleDiskCache mCache = Application.cache;

    @Override
    public void getFriends(GetFriendsCallBack callBack) {
        mCallBack = callBack;
        try {
            if (mCache != null && mCache.contains(CACHE_KEY)) {
                String items = mCache.getString(CACHE_KEY).getString();
                mCallBack.onSuccess(getFriendsFromJson(items));
                Log.d(Application.LOG_TAG, "from cache");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        executeVKRequestPhotos();
    }

    @Override
    public void clearCache() {
        try {
            if (mCache != null) {
                mCache.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeVKRequestPhotos() {

        VKRequest request = new VKRequest(
                METHOD_PHOTOS_GET,
                VKParameters.from(VKApiConst.FIELDS, ADDITIONAL_FIELD_PHOTO));

        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                String items = null;
                try {
                    items = response.json.getJSONObject("response").getJSONArray("items").toString();
                    Log.d(Application.LOG_TAG, "from network");
                    try {
                        if (mCache != null) {
                            mCache.put(CACHE_KEY, items);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    mCallBack.onError("Parse error");
                }
                mCallBack.onSuccess(getFriendsFromJson(items));
            }

            @Override
            public void onError(VKError error) {
                mCallBack.onError(error.errorMessage);
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                Log.d(Application.LOG_TAG, "attemptFailed " + String.valueOf(attemptNumber));
            }
        });
    }

    private FriendModel.List getFriendsFromJson(String json) {
        Gson gson = new GsonBuilder().create();
        FriendModel.List friends = new FriendModel.List();
        if (json != null) {
            friends = gson.fromJson(json, FriendModel.List.class);
        }
        return friends;
    }
}
