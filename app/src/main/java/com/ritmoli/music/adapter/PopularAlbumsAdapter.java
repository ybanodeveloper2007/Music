package com.ritmoli.music.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ritmoli.music.R;
import com.ritmoli.music.fragment.YoutubePlayer;
import com.ritmoli.music.helpers.PicassoHelper;
import com.ritmoli.music.model.CategoryInformation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularAlbumsAdapter extends RecyclerView.Adapter {
    Context context;


    List<CategoryInformation> arrayList;


    public void setArrayList(List<CategoryInformation> arrayList) {
        this.arrayList = arrayList;
    }

    public List<CategoryInformation> getArrayList() {
        return arrayList;
    }

    public PopularAlbumsAdapter(Context context, List<CategoryInformation> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.style_horizontal_sound_view, viewGroup, false);
        return new PopularAlbumsAdapter.viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        try {
            ((PopularAlbumsAdapter.viewHolderArtist) holder).artistname.setText(arrayList.get(position).getName());
            ((PopularAlbumsAdapter.viewHolderArtist) holder).albumName.setText(arrayList.get(position).getArtist().getName());
            Picasso.get().load(arrayList.get(position).getImage())
                    .transform(new PicassoHelper.RoundedCornersTransform())
                    .into(((PopularAlbumsAdapter.viewHolderArtist) holder).artistlogo);

            ((PopularAlbumsAdapter.viewHolderArtist) holder).artistlogo.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                   /* ((FragmentActivity)context).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new Player())
                            .commit();*/

//                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=fEYUoBgYKzw"));
//                    context.startActivity(browserIntent);
                    Intent intent1 = new Intent(context,YoutubePlayer.class);
                    Bundle bundle = new Bundle();
                  //  bundle.putString("youtubeid",arrayList.get(position).getYoutubeId().toString());
                    context.startActivity(new Intent(context, YoutubePlayer.class));
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
        TextView albumName;


        public viewHolderArtist(View itemView) {
            super(itemView);
            artistlogo = itemView.findViewById(R.id.imageSound);
            artistname = itemView.findViewById(R.id.titleTextView);
            albumName = itemView.findViewById(R.id.seconderyText);
        }
    }
}