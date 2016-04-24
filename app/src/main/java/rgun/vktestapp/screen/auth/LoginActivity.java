package rgun.vktestapp.screen.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import rgun.vktestapp.R;
import rgun.vktestapp.screen.auth.myVk.MyVk;
import rgun.vktestapp.screen.auth.myVk.MyVkImpl;
import rgun.vktestapp.screen.auth.myVk.VkErrorListener;
import rgun.vktestapp.screen.photo.list.ActivityPhotoList;


/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends FragmentActivity implements ILoginActivityCommunicator, VkErrorListener {

    private MyVk mMyVk;

    ///////////////////////////////////////////////////////////////////////////
    // Activity Lifecycle
    ///////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mMyVk = new MyVkImpl(this, this);
        mMyVk.setVkErrorListener(this);
        mMyVk.wakeUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMyVk.onResume();

    }

    @Override
    protected void onPause() {
        mMyVk.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, mMyVk.getCallbackForAccessToken())) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // ILoginActivityCommunicatorImpl
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void showLogout() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LogoutFragment())
                .commit();
    }

    @Override
    public void showLogin() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .commit();
    }

    @Override
    public void startPhotoActivity() {
        startActivity(new Intent(this, ActivityPhotoList.class));
    }

    @Override
    public MyVk getMyVk() {
        return mMyVk;
    }

    ///////////////////////////////////////////////////////////////////////////
    // VkErrorListenerImpl
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void onError(VKError error) {
        if (error.errorMessage != null && !error.errorMessage.isEmpty()) {
            Toast.makeText(LoginActivity.this, error.errorMessage, Toast.LENGTH_LONG).show();
        }
    }
}