package rgun.vktestapp;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

import java.io.File;
import java.io.IOException;

import rgun.vktestapp.ui.screen.auth.AuthActivity;
import rgun.vktestapp.utils.SimpleDiskCache;

/**
 * Created by rgun on 23.09.15.
 */
public class Application extends android.app.Application {

    public static final String LOG_TAG = "VK_TEST_APP";
    public static final int CACHE_APP_VERSION = 1;
    public static final int CACHE_MAX_SIZE = 1024 * 1024;

    public static Context context;
    public static SimpleDiskCache cache;

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
        context = getApplicationContext();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
        initCache();
    }

    private void initCache(){
        File dir = new File(context.getCacheDir(), "friendslist.cache");
        try {
            cache = SimpleDiskCache.open(dir, CACHE_APP_VERSION, CACHE_MAX_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
