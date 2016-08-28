package rgun.vktestapp.ui.screen.friends_list.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import rgun.vktestapp.R;
import rgun.vktestapp.ui.extras.recycler.RecyclerViewAdapter;
import rgun.vktestapp.ui.screen.friends_list.model.FriendModel;

/**
 * Created by rgun on 03.12.15.
 */
public class FriendsListAdapter extends RecyclerViewAdapter<FriendModel, FriendsListAdapter.FriendsViewHolder> {

    private AppCompatActivity mActivity;
    private int mImageSideViewInDip;

    public FriendsListAdapter(AppCompatActivity activity, int imageSideViewInDip) {
        super(new ArrayList<FriendModel>());
        mActivity = activity;
        mImageSideViewInDip = imageSideViewInDip;
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    @Override
    protected FriendsViewHolder createNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(FriendsViewHolder.layout, null);
        return new FriendsViewHolder(view);
    }

    @Override
    protected void bindNormalViewHolder(FriendsViewHolder vh, int position) {

        vh.name.setText(String.format("%s %s", mDataList.get(position).firstName, mDataList.get(position).lastName));

        LoadImageToPhotoContainer loadImageToPhotoContainer = new LoadImageToPhotoContainer(null);
        loadImageToPhotoContainer.loadImage(mActivity, mDataList.get(position).photoUrl,
                new LoadImageToPhotoContainer.SquareImageTransformer((int) convertDpToPixel(mImageSideViewInDip, mActivity)),
                vh.itemView);

    }

    ///////////////////////////////////////////////////////////////////////////
    // Static classes
    ///////////////////////////////////////////////////////////////////////////

    public static class FriendsViewHolder extends RecyclerView.ViewHolder {

        private static final int layout = R.layout.list_item_friend;

        public TextView name;

        public FriendsViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
        }

    }
}
