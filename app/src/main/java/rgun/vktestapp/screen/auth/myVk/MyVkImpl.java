package rgun.vktestapp.screen.auth.myVk;

import android.app.Activity;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import rgun.vktestapp.screen.auth.ILoginActivityCommunicator;

/**
 * Created by rgun on 23.04.16.
 */
public class MyVkImpl implements MyVk {

    /**
     * Scope is set of required permissions for your application
     *
     * @see <a href="https://vk.com/dev/permissions">vk.com api permissions documentation</a>
     */
    public static final String[] mScope = new String[]{
            VKScope.PHOTOS,
    };

    private boolean mIsResumed = false;
    private Activity mActivity;
    private ILoginActivityCommunicator mLogin;
    private VkErrorListener mVkErrorListener;


    private VKCallback<VKAccessToken> callback = new VKCallback<VKAccessToken>() {
        @Override
        public void onResult(VKAccessToken res) {
            // User passed Authorization
            mLogin.startPhotoActivity();
        }

        @Override
        public void onError(VKError error) {
            // User didn't pass Authorization
            if (mVkErrorListener != null) {
                mVkErrorListener.onError(error);
            }
        }
    };

    public MyVkImpl(Activity activity, ILoginActivityCommunicator login) {
        mActivity = activity;
        mLogin = login;
    }

    @Override
    public void setVkErrorListener(VkErrorListener listener) {
        mVkErrorListener = listener;
    }

    @Override
    public void wakeUp() {
        VKSdk.wakeUpSession(mActivity, new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                if (mIsResumed) {
                    switch (res) {
                        case LoggedOut:
                            mLogin.showLogin();
                            break;
                        case LoggedIn:
                            mLogin.showLogout();
                            break;
                        case Pending:
                            break;
                        case Unknown:
                            break;
                    }
                }
            }

            @Override
            public void onError(VKError error) {
                if (mVkErrorListener != null) {
                    mVkErrorListener.onError(error);
                }
            }
        });
    }

    @Override
    public void onResume() {
        mIsResumed = true;
        if (VKSdk.isLoggedIn()) {
            mLogin.showLogout();
        } else {
            mLogin.showLogin();
        }
    }

    @Override
    public void onPause() {
        mIsResumed = false;
    }

    @Override
    public VKCallback<VKAccessToken> getCallbackForAccessToken() {
        return callback;
    }

    @Override
    public void login() {
        VKSdk.login(mActivity, MyVkImpl.mScope);
    }

    @Override
    public void logout() {
        VKSdk.logout();
    }

    @Override
    public boolean isLoggedIn() {
        return VKSdk.isLoggedIn();
    }
}
