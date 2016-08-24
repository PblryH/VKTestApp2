package rgun.vktestapp.screen.auth.inner_components.logout;

import android.view.View;
import android.widget.Button;

import rgun.vktestapp.R;

/**
 * ViewHolder
 */
class LogoutVH {

    public static final int layout = R.layout.fragment_logout;

    public Button buttonContinue;
    public Button buttonLogout;

    public LogoutVH(View v) {
        buttonContinue = (Button) v.findViewById(R.id.buttonContinue);
        buttonLogout = (Button) v.findViewById(R.id.buttonLogout);
    }
}
