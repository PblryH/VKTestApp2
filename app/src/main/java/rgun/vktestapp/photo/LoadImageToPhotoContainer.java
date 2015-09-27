package rgun.vktestapp.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;

import rgun.vktestapp.R;

/**
 * Created by rgun on 27.09.15.
 */
public class LoadImageToPhotoContainer {

    /**
     * Трансформирует изображение в квадратное
     */
    public static class SquareImageTransformer implements Transformation {

        private int mViewSide;

        public SquareImageTransformer(int viewSide) {
            mViewSide = viewSide;
        }

        @Override
        public Bitmap transform(Bitmap source) {
            int x = 0, y = 0, side = 0;
            if (source.getWidth() == source.getHeight()) {
                side = source.getHeight();
            } else if (source.getWidth() < source.getHeight()) {
                // высокое изображение
                y = source.getHeight() / 2 - source.getWidth() / 2;
                side = source.getWidth();
            } else {
                // широкое изображение
                x = source.getWidth() / 2 - source.getHeight() / 2;
                side = source.getHeight();
            }
            float scale = ((float) mViewSide) / ((float) side);
            Matrix matrix = new Matrix();
            matrix.postScale(scale, scale);
            Bitmap result = Bitmap.createBitmap(source, x, y,
                    side, side, matrix, false);
            source.recycle();
            return result;
        }

        @Override
        public String key() {
            return "transform";
        }
    }

    public interface OnImageLoadListener{
        void onLoad();
    }

    private OnImageLoadListener mImageLoadListener;

    public LoadImageToPhotoContainer(OnImageLoadListener imageLoadListener){
        mImageLoadListener = imageLoadListener;
    }

    public void loadImage(Context context, String url, SquareImageTransformer transformer,
                          final View view) {
        ImageView photo = (ImageView) view.findViewById(R.id.photo);
        final TextView errorText = (TextView) view.findViewById(R.id.errorText);
        final ProgressBar progress = (ProgressBar) view.findViewById(R.id.progress);

        photo.setImageDrawable(null);
        errorText.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        RequestCreator requestCreator = Picasso.with(context).load(url).tag(context);
        if(transformer != null) requestCreator.transform(transformer);
        requestCreator.into(photo, new Callback() {
            @Override
            public void onSuccess() {
                errorText.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);
                if(mImageLoadListener != null){
                    mImageLoadListener.onLoad();
                }
            }

            @Override
            public void onError() {
                errorText.setVisibility(View.VISIBLE);
                errorText.setText(R.string.display_remote_image_error);
                progress.setVisibility(View.GONE);
            }
        });
    }
}
