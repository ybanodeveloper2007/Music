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
import com.ritmoli.music.helpers.PicassoHelper;
import com.ritmoli.music.model.CategoryInformation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GenresAdapter1 extends RecyclerView.Adapter {
    Activity context;
    List<CategoryInformation> arrayList;


    public void setArrayList(List<CategoryInformation> arrayList) {
        this.arrayList = arrayList;
    }
    public List<CategoryInformation> getArrayList() {
        return arrayList;
    }
    public GenresAdapter1(Context context, List<CategoryInformation> arrayList) {
        this.context = (Activity) context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.artist_layout, viewGroup, false);
        return new GenresAdapter1.viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            ((GenresAdapter1.viewHolderArtist)holder).artistname.setText(arrayList.get(position).getName());
            Picasso.get().load(arrayList.get(position).getImage())
                    .transform(new PicassoHelper.PicassoCircleTransformation())
                    .resize(300,300)
                    .into(((GenresAdapter1.viewHolderArtist) holder).artistlogo);

            ((GenresAdapter1.viewHolderArtist) holder).artistlogo.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(View v) {
                    ((FragmentActivity)context).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new Player())
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
