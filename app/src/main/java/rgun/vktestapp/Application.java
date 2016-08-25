package rgun.vktestapp;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

import rgun.vktestapp.ui.screen.auth.AuthActivity;

/**
 * Created by rgun on 23.09.15.
 */
public class Application extends android.app.Application {

    public static final String LOG_TAG = "VK_TEST_APP";

    public static Context context;

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Toast.makeText(Application.this, "AccessToken invalidated", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Application.this, AuthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    };

    ///////////////////////////////////////////////////////////////////////////
    // Application lifecycle
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate() {
        super.onCreate();
        Application.context = getApplicationContext();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
    }

}
