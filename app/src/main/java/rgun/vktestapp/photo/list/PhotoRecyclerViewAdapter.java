package rgun.vktestapp.photo.list;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rgun.vktestapp.R;
import rgun.vktestapp.photo.LoadImageToPhotoContainer;
import rgun.vktestapp.photo.PhotoPojo;

/**
 * Created by rgun on 24.09.15.
 */
public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoRecyclerViewAdapter.PhotosViewHolder> {

    public class PhotosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        private View itemView;

        public PhotosViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            name = (TextView)itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

        public View getItemView() {
            return itemView;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private Context mContext;
    private final List<PhotoPojo> mPhotos;
    private int mImageSideViewInDip;
    private OnItemClickListener mItemClickListener;

    public PhotoRecyclerViewAdapter(Context context, List<PhotoPojo> photos, int imageSideViewInDip){
        mContext = context;
        mPhotos = photos;
        mImageSideViewInDip = imageSideViewInDip;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mItemClickListener = onItemClickListener;
    }

    @Override
    public PhotoRecyclerViewAdapter.PhotosViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_photo, viewGroup, false);
        PhotosViewHolder pvh = new PhotosViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PhotoRecyclerViewAdapter.PhotosViewHolder viewHolder, int i) {
        viewHolder.name.setText(mPhotos.get(i).name);
        LoadImageToPhotoContainer loadImageToPhotoContainer = new LoadImageToPhotoContainer(null);
        loadImageToPhotoContainer.loadImage(mContext, mPhotos.get(i).url,
                new LoadImageToPhotoContainer.SquareImageTransformer((int) convertDpToPixel(mImageSideViewInDip, mContext)),
                viewHolder.getItemView());

    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }
}
