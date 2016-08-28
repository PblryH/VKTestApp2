package rgun.vktestapp.ui.extras;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import rgun.vktestapp.R;

/**
 * Common View Holder with toolbar
 * Created by rgun on 22.06.16.
 */
abstract public class VHContentWithToolbar extends BaseVH {

    public static final int layout = R.layout.template_content_with_toolbar;
    private FrameLayout content;
    public Toolbar toolbar;
    private LayoutInflater mInflater;

    public VHContentWithToolbar(LayoutInflater inflater, ViewGroup view){
        this(inflater, view, true);
    }

    public VHContentWithToolbar(LayoutInflater inflater, ViewGroup view, boolean isElevated) {
        super(inflater, view, layout);
        mInflater = inflater;
        content = (FrameLayout) getView().findViewById(R.id.content);
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        if (!isElevated && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(0);
        }
        inflateLayoutIntoContent();
    }

    private void inflateLayoutIntoContent() {
        mInflater.inflate(getLayoutRes(), content);
    }

    abstract public int getLayoutRes();
}
