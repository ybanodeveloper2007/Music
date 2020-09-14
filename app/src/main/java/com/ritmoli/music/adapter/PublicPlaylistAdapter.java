package com.ritmoli.music.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ritmoli.music.R;
import com.ritmoli.music.activity.Player;
import com.ritmoli.music.fragment.ArtistsProfileFragment;
import com.ritmoli.music.helpers.PicassoHelper;
import com.ritmoli.music.model.ArtistResponse_Artist;
import com.ritmoli.music.model.CategoryInformation;
import com.ritmoli.music.model.PublicPlayList;
import com.ritmoli.music.networkservice.ApiClient;
import com.ritmoli.music.networkservice.ApiInterface;
import com.ritmoli.music.response.ArtistInfoResponse;
import com.ritmoli.music.response.PublicPlaylistResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PublicPlaylistAdapter extends RecyclerView.Adapter {

    Context context;

    public List<PublicPlayList> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<PublicPlayList> arrayList) {
        this.arrayList = arrayList;
    }

    List<PublicPlayList> arrayList;

    public PublicPlaylistAdapter(Context context, List<PublicPlayList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.style_playlist_view, viewGroup, false);
        return new PublicPlaylistAdapter.viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        try {
            ((PublicPlaylistAdapter.viewHolderArtist) holder).name.setText(arrayList.get(position).getName());
           ((viewHolderArtist) holder).count.setText(String.valueOf(arrayList.get(position).getTracksCount()));
           Picasso.get().load(String.valueOf(arrayList.get(position).getImage()))
                    .into(((viewHolderArtist) holder).image);
            ((viewHolderArtist) holder).image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                }
            });

        } catch (Exception ex) {
            Log.d("Sri", "ex" + ex);
        }
    }


    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }


    class viewHolderArtist extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView count;
        // TextView albumName;



        public viewHolderArtist(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            count = itemView.findViewById(R.id.count);
            // albumName = itemView.findViewById(R.id.seconderyText);
        }
    }
}
