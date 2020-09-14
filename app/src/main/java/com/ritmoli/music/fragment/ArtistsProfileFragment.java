package com.ritmoli.music.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ritmoli.music.R;
import com.ritmoli.music.activity.Player;
import com.ritmoli.music.adapter.GenresAdapter1;
import com.ritmoli.music.helpers.PicassoHelper;
import com.ritmoli.music.model.Artist;
import com.ritmoli.music.model.ArtistResponse_Artist;
import com.ritmoli.music.response.ArtistResponse;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArtistsProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArtistsProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
  //  private static ArtistResponse_Artist artistResponseArtist;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArtistResponse_Artist artistResponseArtist;
    ArtistResponse_Artist artist;

    public ArtistsProfileFragment() {
        // Required empty public constructor
    }

    public static ArtistsProfileFragment newInstance(ArtistResponse_Artist artist) {
        ArtistsProfileFragment fragment = new ArtistsProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable("artist", artist);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          artist = getArguments().getParcelable("artist");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
       // if(savedInstanceState==null) {
            view = inflater.inflate(R.layout.artists_profile_layout, container, false);
      //  }
            ImageView cover_image = view.findViewById(R.id.cover_image);
            ImageView imageAvatar = view.findViewById(R.id.imageAvatar);
            TextView countFollowers = view.findViewById(R.id.count_followers);
            TextView CountFollowing = view.findViewById(R.id.count_following);
            TextView CountTracks = view.findViewById(R.id.count_tracks);
            Picasso.get().load(artist.getImageLarge())
                    .resize(600, 600)
                    .centerCrop()
                    .into(cover_image);
            Picasso.get().load(artist.getImageSmall())
                    .transform(new PicassoHelper.PicassoCircleTransformation())
                    .into(imageAvatar);
            imageAvatar.setVisibility(View.INVISIBLE);
           CountFollowing.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   ((FragmentActivity)getActivity()).getSupportFragmentManager()
                           .beginTransaction()
                           .replace(R.id.fragmentContainer, ContactsFragment.newInstance("Following",null))
                           .commit();
               }
           });
           countFollowers.setText(String.valueOf(artist.getSpotifyFollowers()));
           //CountFollowing.setText(artist.ge());
            CountTracks.setText(String.valueOf(artist.getAlbumsCount()));
            countFollowers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((FragmentActivity)getActivity()).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new ContactsFragment())
                            .commit();
                }
            });


        return view;
    }
}