package com.ritmoli.music.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.ritmoli.music.R;

/**

 * create an instance of this fragment.
 */
public class YoutubePlayer extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private YouTubePlayerView youTubeView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String youtubeId;
    public YoutubePlayer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     */
    // TODO: Rename and change types and number of parameters
   /* public static YoutubePlayer newInstance(String param1, String param2) {
        YoutubePlayer fragment = new YoutubePlayer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
         youtubeId = getIntent().getExtras().get("youtubeid").toString();
        setContentView(R.layout.fragment_youtube_player);
        youTubeView = findViewById(R.id.youtube_view);
        youTubeView.initialize("AIzaSyBxXqRDx5Xwywt4MrR62hlq8rmQO_yoU3w", (YouTubePlayer.OnInitializedListener)this);

    }



    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
       /* if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }*/
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.loadVideo("fEYUoBgYKzw");
          //  player.loadVideo("youtubeId");
            // Hiding player controls
          //  player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      //  if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize("AIzaSyBxXqRDx5Xwywt4MrR62hlq8rmQO_yoU3w", this);
       // }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
}