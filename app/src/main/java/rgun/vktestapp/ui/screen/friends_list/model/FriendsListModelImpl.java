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

import rgun.vktestapp.Application;

/**
 * Created by rgun on 25.08.16.
 */
public class FriendsListModelImpl implements FriendsListModel {


    public static final String METHOD_PHOTOS_GET = "friends.get";
    public static final String ADDITIONAL_FIELD_PHOTO = "photo_200_orig";

    private GetFriendsCallBack mCallBack;

    @Override
    public void getFriends(GetFriendsCallBack callBack) {
        mCallBack = callBack;
        executeVKRequestPhotos();
    }

    private void executeVKRequestPhotos() {

        VKRequest request = new VKRequest(
                METHOD_PHOTOS_GET,
                VKParameters.from(VKApiConst.FIELDS, ADDITIONAL_FIELD_PHOTO));

        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                Gson gson = new GsonBuilder().create();
                FriendModel.List friends = new FriendModel.List();
                try {
                    friends = gson.fromJson(response.json.getJSONObject("response").getJSONArray("items").toString(), FriendModel.List.class);
                } catch (JSONException e) {
                    mCallBack.onError("Parse error");
                }
                if (friends != null) {
                    friends.size();
                }
                mCallBack.onSuccess(friends);
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
}
