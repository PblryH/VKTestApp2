package rgun.vktestapp.ui.screen.friends_list.view.recycler_view;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rgun.vktestapp.R;

/**
 * ViewHolder
 */
public class ContainerPhotoVH {

    @BindView(R.id.photo)
    public ImageView photo;

    @BindView(R.id.errorText)
    public TextView errorText;

    @BindView(R.id.progress)
    public ProgressBar progress;

    public ContainerPhotoVH(View v) {
        ButterKnife.bind(this, v);
    }
}
