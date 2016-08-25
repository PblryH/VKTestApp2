package rgun.vktestapp.ui.screen.auth.inner_components.login;

import android.view.View;
import android.widget.Button;

import rgun.vktestapp.R;

/**
 * ViewHolder
 */
class LoginVH {

    public static final int layout = R.layout.fragment_login;

    public Button buttonLogin;

    public LoginVH(View v) {
        buttonLogin = (Button) v.findViewById(R.id.buttonLogin);
    }
}
