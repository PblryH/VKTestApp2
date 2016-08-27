package rgun.vktestapp.ui.extras;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import rgun.vktestapp.R;

/**
 * Created by rgun on 22.06.16.
 */
abstract public class VHContentWithToolbar {

    public static final int layout = R.layout.template_content_with_toolbar;
    private AppCompatActivity mActivity;
    private FrameLayout content;
    public Toolbar toolbar;

    public VHContentWithToolbar(AppCompatActivity activity){
        this(activity, true);
    }

    public VHContentWithToolbar(AppCompatActivity activity, boolean isElevated) {
        mActivity = activity;
        mActivity.setContentView(layout);
        content = (FrameLayout) mActivity.findViewById(R.id.content);
        toolbar = (Toolbar) mActivity.findViewById(R.id.toolbar);
        if (!isElevated && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(0);
        }
        inflateLayoutIntoContent();
    }

    private void inflateLayoutIntoContent() {
        mActivity.getLayoutInflater().inflate(getLayoutRes(), content);
    }

    abstract public int getLayoutRes();
}
