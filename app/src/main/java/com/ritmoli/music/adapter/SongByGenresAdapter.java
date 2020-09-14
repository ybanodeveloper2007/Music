package com.ritmoli.music.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ritmoli.model.Datum;
import com.ritmoli.music.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongByGenresAdapter extends RecyclerView.Adapter {

    Context context;
    List<Datum> arrayList;
    String genres;


    public void setArrayList(List<Datum> arrayList) {
        this.arrayList = arrayList;
    }
    public List<Datum> getArrayList() {
        return arrayList;
    }
    public SongByGenresAdapter(Context context, String genres) {
        this.context = context;
        this.genres = genres;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.style_songview, viewGroup, false);
        return new SongByGenresAdapter.viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            Picasso.get().load(arrayList.get(position).getImage())
                    .transform(new PicassoHelper.PicassoCircleTransformation()).into(((viewHolderArtist) holder).songList);
           /* ((viewHolderArtist)holder).catName.setText(arrayList.get(position).());
            ((viewHolderArtist)holder).catName.setText(arrayList.get(position).());
            ((viewHolderArtist)holder).catName.setText(arrayList.get(position).());
            ((viewHolderArtist)holder).catName.setText(arrayList.get(position).());
            ((GenresAdapter.viewHolderArtist) holder).artistlogo.setOnClickListener(new View.OnClickListener() {
                private FragmentActivity context;
                public FragmentActivity getContext() {
                    return context;
                }
                @Override
                public void onClick(View v) {
                    getContext().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new ArtistsProfileFragment())
                            .commit();
                }
            });*/
        }catch (Exception ex){
            Log.d("Sri","ex"+ex);
        }
    }


    @Override
    public int getItemCount() {
        if(arrayList!=null) {
            return arrayList.size();
        }
        return 0;
    }



    class viewHolderArtist extends RecyclerView.ViewHolder {
        ImageView songList;
        TextView songName;
        TextView catName;
        TextView songDuration;
        ImageView more;
        ImageView like;


        public viewHolderArtist(View itemView) {
            super(itemView);
            songList = itemView.findViewById(R.id.imageview_songlist);
            songName =  itemView.findViewById(R.id.textview_songname);
            catName =  itemView.findViewById(R.id.textview_catname);
            songDuration =  itemView.findViewById(R.id.textView_songduration);
            more =  itemView.findViewById(R.id.more);
            like =  itemView.findViewById(R.id.likeImageview);
        }
    }

}
