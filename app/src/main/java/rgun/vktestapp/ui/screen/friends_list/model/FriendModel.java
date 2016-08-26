package rgun.vktestapp.ui.screen.friends_list.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by railkamalov on 26.08.16.
 */
public class FriendModel {

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("photo_200_orig")
    public String photoUrl;

    @SuppressWarnings("serial")
    public static class List extends ArrayList<FriendModel> {}
}
