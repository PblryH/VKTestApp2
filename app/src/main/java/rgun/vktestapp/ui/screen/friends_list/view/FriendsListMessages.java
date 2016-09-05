package rgun.vktestapp.ui.screen.friends_list.view;

import rgun.vktestapp.R;

/**
 * Created by railkamalov on 05.09.16.
 */
public enum FriendsListMessages {

    CACHE_CLEARED(R.string.cacheCleared);

    private int mStringRes;

    FriendsListMessages(int stringRes) {
        mStringRes = stringRes;
    }

    public int getStringRes(){
        return mStringRes;
    }
}
