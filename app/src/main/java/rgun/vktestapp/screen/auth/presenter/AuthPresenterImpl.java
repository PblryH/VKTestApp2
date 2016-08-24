package rgun.vktestapp.screen.auth.presenter;

import com.vk.sdk.api.VKError;

import rgun.vktestapp.screen.auth.model.AuthModel;
import rgun.vktestapp.screen.auth.view.AuthView;

/**
 * Created by rgun on 22.08.16.
 */
public class AuthPresenterImpl implements AuthPresenter{

    private final AuthView mView;
    private final AuthModel mModel;

    private AuthModel.CallBack  mCallBack = new AuthModel.CallBack() {
        @Override
        public void mustShowLogin() {
            mView.showLogin();
        }

        @Override
        public void mustShowLogout() {
            mView.showLogout();
        }

        @Override
        public void onAuthorized() {
            mView.showPhotoScreen();
        }

        @Override
        public void onAuthorizationError(VKError error) {
            if(error != null && error.errorMessage != null && !error.errorMessage.isEmpty()) {
                mView.showToast(error.errorMessage);
            }
        }
    };

    public AuthPresenterImpl(AuthView view, AuthModel model) {
        mView = view;
        mModel = model;
        mModel.setCallback(mCallBack);
    }
}
