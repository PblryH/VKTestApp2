package rgun.vktestapp.screen.auth.inner_components.logout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vk.sdk.VKSdk;

import rgun.vktestapp.screen.auth.AuthActivityInteractor;

/**
 * Created by rgun on 23.04.16.
 */
public class LogoutFragment extends android.support.v4.app.Fragment {

    private AuthActivityInteractor mActivityInteractor;

    ///////////////////////////////////////////////////////////////////////////
    // Fragment lifecycle
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        try {
            mActivityInteractor = (AuthActivityInteractor) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context + " must implement " + AuthActivityInteractor.class);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(LogoutVH.layout, container, false);
        LogoutVH vh = new LogoutVH(v);
        vh.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivityInteractor.startPhotoScreen();
            }
        });
        vh.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VKSdk.logout();
                if (!VKSdk.isLoggedIn()) {
                    mActivityInteractor.showLogin();
                }
            }
        });
        return v;
    }

}
