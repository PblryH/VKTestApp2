package rgun.vktestapp.ui.screen.auth.view;

/**
 * Created by rgun on 22.08.16.
 */
public interface AuthView {

    void showLogin();

    void showLogout();

    void showFriendsListScreen();

    void showToast(String s);

    void startVkAuth();
}
