package rgun.vktestapp.screen.auth;

import rgun.vktestapp.screen.auth.myVk.MyVk;

/**
 * Created by rgun on 23.04.16.
 */
public interface ILoginActivityCommunicator {
    void showLogin();
    void showLogout();
    void startPhotoActivity();
    MyVk getmMyVk();
}
