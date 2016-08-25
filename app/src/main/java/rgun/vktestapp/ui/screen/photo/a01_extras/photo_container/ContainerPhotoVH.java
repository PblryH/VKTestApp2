package rgun.vktestapp.ui.screen.photo.a01_extras.photo_container;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import rgun.vktestapp.R;

/**
 * ViewHolder
 */
public class ContainerPhotoVH {

    public ImageView photo;
    public TextView errorText;
    public ProgressBar progress;

    public ContainerPhotoVH(View v) {
        photo = (ImageView) v.findViewById(R.id.photo);
        errorText = (TextView) v.findViewById(R.id.errorText);
        progress = (ProgressBar) v.findViewById(R.id.progress);
    }
}
