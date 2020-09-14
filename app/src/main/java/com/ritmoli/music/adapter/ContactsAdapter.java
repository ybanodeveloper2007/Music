package com.ritmoli.music.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ritmoli.music.R;
import com.ritmoli.music.activity.Player;
import com.ritmoli.music.helpers.PicassoHelper;
import com.ritmoli.music.model.CategoryInformation;
import com.ritmoli.music.model.Followers;
import com.ritmoli.music.networkservice.ApiClient;
import com.ritmoli.music.networkservice.ApiInterface;
import com.ritmoli.music.response.FollowResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactsAdapter extends RecyclerView.Adapter {
    Activity context;
    List<Followers> arrayList;
    private ApiInterface apiInterface;
    private boolean follow ;
    Call<FollowResponse> callFollow;



    public void setArrayList(List<Followers> arrayList) {
        this.arrayList = arrayList;
    }

    public List<Followers> getArrayList() {
        return arrayList;
    }

    public ContactsAdapter(Context context, List<Followers> arrayList) {
        this.context = (Activity) context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.style_contact_view, viewGroup, false);
        return new ContactsAdapter.viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        try {
            ((viewHolderArtist) holder).cardName.setText(arrayList.get(position).getFirstName());
            ((viewHolderArtist) holder).cardDist.setText(arrayList.get(position).getCreatedAt());
            Picasso.get().load(arrayList.get(position).getAvatar())
                    .transform(new PicassoHelper.PicassoCircleTransformation())
                    .resize(300, 300)
                    .placeholder(R.drawable.no_profile_image_circle)
                    .into(((viewHolderArtist) holder).cardPro);
           // ((viewHolderArtist) holder).cont.setTextColor(context.getColor(R.color.white));
            ((viewHolderArtist)holder).cont.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                    if(follow) {
                        callFollow = apiInterface.unfollow("6");
                        follow =false;
                    }else {
                        callFollow = apiInterface.follow("5");
                        follow = true;
                    }
                    callFollow.enqueue(new Callback<FollowResponse>() {
                        @Override
                        public void onResponse(Call<FollowResponse> call, Response<FollowResponse> response) {
                            boolean success = response.body().isStatus();
                            if(success){
                                ((viewHolderArtist) holder).cont.setText("Following");
                            }
                        }

                        @Override
                        public void onFailure(Call<FollowResponse> call, Throwable t) {
                            if(follow) {
                                ((viewHolderArtist) holder).cont.setText("Following");
                                ((viewHolderArtist) holder).cont.setBackground(context.getDrawable(R.drawable.follow_button_profile_friends_pressed));
                                ((viewHolderArtist) holder).cont.setTextColor(context.getColor(R.color.white));
                                Log.d("Sri", "" + t);
                            }else{
                                ((viewHolderArtist) holder).cont.setText("Follow");
                                ((viewHolderArtist) holder).cont.setBackground(context.getDrawable(R.drawable.follow_button_profile_friends));
                                ((viewHolderArtist) holder).cont.setTextColor(context.getColor(R.color.accent));
                            }
                        }
                    });
                }
            });


            ((viewHolderArtist) holder).cardPro.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    ((FragmentActivity) context).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new Player())
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
        ImageView cardPro;
        TextView cardName;
        TextView cardDist;
        Button cont;

        public viewHolderArtist(View itemView) {
            super(itemView);
            cardPro = itemView.findViewById(R.id.card_pro_pic);
            cardName = itemView.findViewById(R.id.card_name);
            cardDist = itemView.findViewById(R.id.card_dist);
            cont = itemView.findViewById(R.id.cont);
        }
    }
}