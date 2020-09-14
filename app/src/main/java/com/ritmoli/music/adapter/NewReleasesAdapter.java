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
import com.ritmoli.music.model.CategoryInformation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewReleasesAdapter extends RecyclerView.Adapter {
    Context context;


    List<CategoryInformation> arrayList;


    public void setArrayList(List<CategoryInformation> arrayList) {
        this.arrayList = arrayList;
    }

    public List<CategoryInformation> getArrayList() {
        return arrayList;
    }

    public NewReleasesAdapter(Context context, List<CategoryInformation> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.style_horizontal_sound_view, viewGroup, false);
        return new NewReleasesAdapter.viewHolderArtist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            ((NewReleasesAdapter.viewHolderArtist) holder).artistname.setText(arrayList.get(position).getName());
            ((NewReleasesAdapter.viewHolderArtist) holder).albumName.setText(arrayList.get(position).getArtist().getName());
            Picasso.get().load(arrayList.get(position).getImage())
                    .transform(new PicassoHelper.RoundedCornersTransform())
                    .into(((NewReleasesAdapter.viewHolderArtist) holder).artistlogo);
            ((NewReleasesAdapter.viewHolderArtist) holder).artistlogo.setOnClickListener(new View.OnClickListener() {


                private FragmentActivity context;

                public FragmentActivity getContext() {
                    return context;
                }

                @Override
                public void onClick(View v) {
                    context.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new ArtistsProfileFragment())
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
        TextView albumName;


        public viewHolderArtist(View itemView) {
            super(itemView);
            artistlogo = itemView.findViewById(R.id.imageSound);
            artistname = itemView.findViewById(R.id.titleTextView);
            albumName = itemView.findViewById(R.id.seconderyText);
        }
    }
}