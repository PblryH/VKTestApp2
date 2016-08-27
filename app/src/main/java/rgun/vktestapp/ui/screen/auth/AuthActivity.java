package rgun.vktestapp.ui.screen.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rgun.vktestapp.ui.screen.auth.model.AuthModel;
import rgun.vktestapp.ui.screen.auth.model.AuthModelImpl;
import rgun.vktestapp.ui.screen.auth.presenter.AuthPresenterImpl;
import rgun.vktestapp.ui.screen.auth.view.AuthView;
import rgun.vktestapp.ui.screen.auth.view.AuthViewImpl;


/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class AuthActivity extends AppCompatActivity {

    private AuthModel mModel;
    private AuthView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new AuthViewImpl(this);
        mModel = new AuthModelImpl(this);
        new AuthPresenterImpl(mView, mModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mModel.onResume();

    }

    @Override
    protected void onPause() {
        mModel.onPause();
        super.onPause();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mModel.onActivityResult(requestCode, resultCode, data);
    }

}