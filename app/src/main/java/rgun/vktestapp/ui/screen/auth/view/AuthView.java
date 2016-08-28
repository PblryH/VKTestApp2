package rgun.vktestapp.ui.screen.auth.view;

/**
 * Created by rgun on 22.08.16.
 */
public interface AuthView {

    /**
     * Перейти на экран авторизации
     */
    void showLogin();

    /**
     * Перейти на экран списка друзей
     */
    void showFriendsListScreen();

    /**
     * Показать тоаст
     * @param s сообщение
     */
    void showToast(String s);
}
