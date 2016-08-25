package rgun.vktestapp.ui.screen.auth.model;

import android.content.Intent;

import com.vk.sdk.api.VKError;

/**
 * Created by rgun on 22.08.16.
 */
public interface AuthModel {

    void onResume();

    void onPause();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void setCallback(CallBack callback);

    interface CallBack {

        void mustShowLogin();

        void mustShowLogout();

        void onAuthorized();

        void onAuthorizationError(VKError error);
    }
}
