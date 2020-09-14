package com.ritmoli.music.adapter;

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
import com.ritmoli.music.fragment.ArtistsProfileFragment;
import com.ritmoli.music.helpers.PicassoHelper;
import com.ritmoli.music.model.Artist;
import com.ritmoli.music.model.ArtistResponse_Artist;
import com.ritmoli.music.networkservice.ApiClient;
import com.ritmoli.music.networkservice.ApiInterface;
import com.ritmoli.music.response.ArtistInfoResponse;
import com.ritmoli.music.response.FollowersResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistAdapter extends RecyclerView.Adapter {

    Context context;

    public List<ArtistResponse_Artist> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<ArtistResponse_Artist> arrayList) {
        this.arrayList = arrayList;
    }

    List<ArtistResponse_Artist> arrayList;

    public ArtistAdapter(Context context, List<ArtistResponse_Artist> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.style_artists_view, viewGroup, false);
        return new viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        try {
            ((ArtistAdapter.viewHolderArtist) holder).artistname.setText(arrayList.get(position).getName());
           // ((ArtistAdapter.viewHolderArtist) holder).albumName.setText(arrayList.get(position).getName());
            Picasso.get().load(arrayList.get(position).getImageSmall())
                     .transform(new PicassoHelper.PicassoCircleTransformation())
                    .into(((ArtistAdapter.viewHolderArtist) holder).artistlogo);
            ((viewHolderArtist) holder).artistlogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  ApiInterface  apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                    Call<ArtistInfoResponse> callFollowers = apiInterface.getArtistInfo(String.valueOf(arrayList.get(position).getId()),"true");
                    callFollowers.enqueue(new Callback<ArtistInfoResponse>() {
                        @Override
                        public void onResponse(Call<ArtistInfoResponse> call, Response<ArtistInfoResponse> response) {
                            Log.d("Sri",""+response);
                            /*followers = response.body().getPagination().getData();
                            contactsAdapter.setArrayList(followers);
                            contactsAdapter.notifyDataSetChanged();*/
                        }

                        @Override
                        public void onFailure(Call<ArtistInfoResponse> call, Throwable t) {

                        }
                    });
                    ((FragmentActivity)context).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, ArtistsProfileFragment.newInstance(arrayList.get(position)))
                            .commit();
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
        ImageView artistlogo;
        TextView artistname;
       // TextView albumName;



        public viewHolderArtist(View itemView) {
            super(itemView);
            artistlogo = itemView.findViewById(R.id.people_profile_sos);
            artistname = itemView.findViewById(R.id.people_profile_name);
           // albumName = itemView.findViewById(R.id.seconderyText);
        }
    }
}
