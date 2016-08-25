package rgun.vktestapp.ui.screen.photo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import rgun.vktestapp.ui.screen.photo.a01_extras.PhotoModel;

public class ActivityPhotoView extends AppCompatActivity {

    public static final String INTENT_EXTRA_PHOTO = "photo";
    private UiPhotoView uiPhotoView;

    ///////////////////////////////////////////////////////////////////////////
    // Activity Lifecycle
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        super.onCreate(savedInstanceState);
        uiPhotoView = new UiPhotoView(this);
        loadPhotoFromIntent();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    private void setFullScreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void loadPhotoFromIntent(){
        PhotoModel photo = (PhotoModel) getIntent().getSerializableExtra(INTENT_EXTRA_PHOTO);
        uiPhotoView.loadImage(photo.url);
    }
}
