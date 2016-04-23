package rgun.vktestapp.screen.auth.myVk;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;

/**
 * Created by rgun on 23.04.16.
 */
public interface MyVk {

    void setVkErrorListener(VkErrorListener listener);

    void wakeUp();

    void onResume();

    void onPause();

    VKCallback<VKAccessToken> getCallbackForAccessToken();

    void login();

    void logout();

    boolean isLoggedIn();
}
