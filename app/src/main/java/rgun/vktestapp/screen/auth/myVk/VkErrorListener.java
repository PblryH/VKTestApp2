package rgun.vktestapp.screen.auth.myVk;

import com.vk.sdk.api.VKError;

/**
 * Created by rgun on 23.04.16.
 */
public interface VkErrorListener {
    void onError(VKError error);
}
