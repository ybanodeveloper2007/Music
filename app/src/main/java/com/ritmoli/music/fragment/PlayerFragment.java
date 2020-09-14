package com.ritmoli.music.fragment;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ritmoli.music.R;

public class PlayerFragment extends Fragment {

    private PlayerView playerView;
    private SimpleExoPlayer player;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;
    private boolean playing = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fullscreenplayerlayout, container, false);
        playerView = view.findViewById(R.id.video_view);
        ImageView image_Cover = view.findViewById(R.id.image_Cover);
        ImageView image = view.findViewById(R.id.image);
        final ImageView playIcon = view.findViewById(R.id.bt_play);


        Glide.with(getActivity()).load(R.drawable.loginimage).into(image);

        RotateAnimation rotate = new RotateAnimation(
                0, 359,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotate.setDuration(900);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(Animation.INFINITE);
        image.startAnimation(rotate);
        FloatingActionButton bt_play = view.findViewById(R.id.bt_play);

        Glide.with(getActivity()).load(R.drawable.loginimage).into(image_Cover);


        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing) {
                    player.release();
                    playing = false;
                    playIcon.setImageResource(R.drawable.icon_player_play);

                }else{
                    playing = true;
                    boolean playing = false;
                    playIcon.setImageResource(R.drawable.icon_player_pause);
                }
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideSystemUi();
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }

    private void initializePlayer() {
        player = new SimpleExoPlayer.Builder(getActivity()).build();

        playerView.setPlayer(player);

        Uri uri = Uri.parse(getString(R.string.media_url_mp4));
        MediaSource mediaSource = buildMediaSource(uri);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playbackPosition);
        player.prepare(mediaSource, false, false);
    }

    private void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
            player.release();
            player = null;
        }
    }

    private MediaSource buildMediaSource(Uri uri) {
        // These factories are used to construct two media sources below
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(getActivity(), "exoplayer-codelab");
        ProgressiveMediaSource.Factory mediaSourceFactory =
                new ProgressiveMediaSource.Factory(dataSourceFactory);

        // Create a media source using the supplied URI
        MediaSource mediaSource1 = mediaSourceFactory.createMediaSource(uri);

        // Additionally create a media source using an MP3
        Uri audioUri = Uri.parse(getString(R.string.media_url_mp4));
        MediaSource mediaSource2 = mediaSourceFactory.createMediaSource(audioUri);

        return new ConcatenatingMediaSource(mediaSource1, mediaSource2);
    }

    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

    }
}
