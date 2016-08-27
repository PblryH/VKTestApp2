package rgun.vktestapp.ui.screen.auth.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import rgun.vktestapp.R;
import rgun.vktestapp.ui.screen.auth.inner_components.login.LoginFragment;
import rgun.vktestapp.ui.screen.friends_list.FriendsListActivity;

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
    public void showLogin() {
        mActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .commit();
    }

    @Override
    public void showFriendsListScreen() {
        mActivity.startActivity(new Intent(mActivity, FriendsListActivity.class));
        mActivity.finish();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(mActivity, s, Toast.LENGTH_LONG).show();
    }

}
