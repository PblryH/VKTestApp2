package rgun.vktestapp.screen.auth;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import rgun.vktestapp.R;
import rgun.vktestapp.screen.auth.myVk.MyVk;

/**
 * Created by rgun on 23.04.16.
 */
public class LoginFragment extends android.support.v4.app.Fragment {

    private ILoginActivityCommunicator mActivityCommunicator;
    private MyVk mMyVk;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        try {
            mActivityCommunicator = (ILoginActivityCommunicator) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context + " must implement " + ILoginActivityCommunicator.class);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyVk = mActivityCommunicator.getmMyVk();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        VH vh = new VH(v);
        vh.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyVk.login();
            }
        });
        return v;
    }


    /**
     * ViewHolder
     */
    private static class VH {

        Button buttonLogin;

        public VH(View v) {
            buttonLogin = (Button) v.findViewById(R.id.buttonLogin);
        }
    }
}
