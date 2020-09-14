package com.ritmoli.music.adapter;

import android.app.Activity;
import android.provider.Settings;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.ritmoli.model.PlayListModel;
import com.ritmoli.music.R;
import com.ritmoli.preference.MyPreference;
import com.ritmoli.preference.PaperConstant;
import java.util.List;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.PlayListItemVH> implements AdapterView.OnItemSelectedListener {

    private List<PlayListModel> categoryWiseProductModelList;
    private Activity activity;
    String deviceiduserid,user_type,device_id;

    public PlayListAdapter(Activity activity, List<PlayListModel> categoryWiseProductModelList) {

        this.activity = activity;
        this.categoryWiseProductModelList = categoryWiseProductModelList;
    }

    @Override
    public PlayListItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.style_playlistview, parent, false);
        return new PlayListItemVH(itemView);

    }

    @Override
    public void onBindViewHolder(final PlayListItemVH holder, final int position) {

        device_id = Settings.Secure.getString(activity.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        if (MyPreference.myPref.read(PaperConstant.USER_ID) != null) {
            deviceiduserid = MyPreference.myPref.read(PaperConstant.USER_ID);
            user_type = MyPreference.myPref.read(PaperConstant.USER_TYPE);
        }

        else {

            deviceiduserid = device_id;
            user_type = "";

        }

        final PlayListModel model = categoryWiseProductModelList.get(position);

        Glide.with(activity).load(model.getImage())
                .transition(DrawableTransitionOptions.withCrossFade(activity.getResources().getInteger(R.integer.GLIDE_ELAPSED_TIME)))
                .into(holder.ivItem).clearOnDetach().waitForLayout();

        holder.tvName.setText(Html.fromHtml(model.getName()));
        holder.tvCount.setText(Html.fromHtml(model.getTracks_count())+ " Songs ");

        }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class PlayListItemVH extends RecyclerView.ViewHolder {

        public ImageView ivItem;
        public TextView tvCount,tvName;

        public PlayListItemVH(View itemView) {
            super(itemView);

            ivItem = (ImageView) itemView.findViewById(R.id.image);
            tvName = (TextView) itemView.findViewById(R.id.name);
            tvCount = (TextView) itemView.findViewById(R.id.count);

        }
    }
}
