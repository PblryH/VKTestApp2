package rgun.vktestapp.screen.auth.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import rgun.vktestapp.R;
import rgun.vktestapp.screen.auth.inner_components.login.LoginFragment;
import rgun.vktestapp.screen.auth.inner_components.logout.LogoutFragment;
import rgun.vktestapp.screen.photo.list.ActivityPhotoList;

/**
 * Created by rgun on 22.08.16.
 */
public class AuthViewImpl implements AuthView {

    private AppCompatActivity mActivity;

    public AuthViewImpl(AppCompatActivity activity) {
        mActivity = activity;
        mActivity.setContentView(R.layout.activity_start);
    }


    @Override
    public void showLogout() {
        mActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LogoutFragment())
                .commit();
    }

    @Override
    public void showLogin() {
        mActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .commit();
    }

    @Override
    public void showPhotoScreen() {
        mActivity.startActivity(new Intent(mActivity, ActivityPhotoList.class));
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(mActivity, s, Toast.LENGTH_LONG).show();
    }
}
