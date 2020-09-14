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
import com.ritmoli.music.model.Content;
import com.ritmoli.music.model.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GenresAdapter  extends RecyclerView.Adapter{

    Context context;
    List<Datum> arrayList;


    public void setArrayList(List<Datum> arrayList) {
        this.arrayList = arrayList;
    }
    public List<Datum> getArrayList() {
        return arrayList;
    }
    public GenresAdapter(Context context, List<Datum> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.artist_layout, viewGroup, false);
        return new viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            ((viewHolderArtist)holder).artistname.setText(arrayList.get(position).getName());
            Picasso.get().load(arrayList.get(position).getImage())
                    .transform(new PicassoHelper.PicassoCircleTransformation()).into(((viewHolderArtist) holder).artistlogo);

            ((viewHolderArtist) holder).artistlogo.setOnClickListener(new View.OnClickListener() {


                private FragmentActivity context;

                public FragmentActivity getContext() {
                    return context;
                }

                @Override
                public void onClick(View v) {
                    getContext().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new ArtistsProfileFragment())
                            .commit();
                }
            });
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
        ImageView artistlogo;
        TextView artistname;


        public viewHolderArtist(View itemView) {
            super(itemView);
            artistlogo = itemView.findViewById(R.id.iconImge1);
            artistname =  itemView.findViewById(R.id.iconText1);
        }
    }

}
