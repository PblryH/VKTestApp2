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
public class LogoutFragment extends android.support.v4.app.Fragment {

    private ILoginActivityCommunicator mActivity;
    private MyVk mMyVk;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        try {
            mActivity = (ILoginActivityCommunicator) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context + " must implement " + ILoginActivityCommunicator.class);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyVk = mActivity.getmMyVk();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_logout, container, false);
        VH vh = new VH(v);
        vh.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.startPhotoActivity();
            }
        });
        vh.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyVk.logout();
                if (!mMyVk.isLoggedIn()) {
                    mActivity.showLogin();
                }
            }
        });
        return v;
    }


    /**
     * ViewHolder
     */
    private static class VH {

        Button buttonContinue;
        Button buttonLogout;

        public VH(View v) {
            buttonContinue = (Button) v.findViewById(R.id.buttonContinue);
            buttonLogout = (Button) v.findViewById(R.id.buttonLogout);
        }
    }
}
