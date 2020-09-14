package com.ritmoli.music.activity;

import android.annotation.SuppressLint;
import android.app.UiAutomation;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ritmoli.music.R;
import com.ritmoli.music.adapter.GenresAdapter1;
import com.ritmoli.music.adapter.SongsByGenresAdapter;
import com.ritmoli.music.helpers.PicassoHelper;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;


public class Player extends Fragment  {

    private PlayerView playerView;
    private SimpleExoPlayer player;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;
    private boolean playing = false;
    ImageView playIcon;
    private ImageButton btnForward;
    private ImageButton btnBackward;
    private ImageButton btnNext;
    private AppCompatSeekBar seekSongProgressbar;
    private long seekForwardTime = 10000; // 5000 milliseconds
    private long seekBackwardTime = 10000; // 5000 milliseconds;
    Handler mHandler;
    Runnable updateTask;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fullscreen_player_layout, container, false);
        playerView = view.findViewById(R.id.video_view);
       ImageView image_Cover = view.findViewById(R.id.image_Cover);
       final ImageView image = view.findViewById(R.id.image);
       btnForward  = view.findViewById(R.id.btn_Forward);
       btnBackward = view.findViewById(R.id.btn_Backward);
       btnNext = view.findViewById(R.id.bt_next);
       seekSongProgressbar = view.findViewById(R.id.seek_song_progressbar);
       seekSongProgressbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
               mHandler.removeCallbacks(updateTask);
           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
               mHandler.removeCallbacks(updateTask);
               long totalDuration = player.getDuration();
               long currentDuration = 0;
               totalDuration =  (totalDuration / 1000);
               currentDuration = (long)((((double)seekBar.getProgress()) / 100) * totalDuration);
               long currentPosition = currentDuration;

               // forward or backward to certain seconds
               player.seekTo(currentWindow,currentPosition);
              updateProgressBar();
               // update timer progress again
               // updateProgressBar();
           }
       });
       playIcon = view.findViewById(R.id.bt_play);
       mHandler = new Handler();
        Picasso.get().load(R.drawable.loginimage)
                .transform(new PicassoHelper.PicassoCircleTransformation())
                .into(image);
        final RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotate.setDuration(900);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(Animation.INFINITE);
        image.startAnimation(rotate);
        FloatingActionButton bt_play = view.findViewById(R.id.bt_play);
        Picasso.get().load(R.drawable.loginimage)
                .transform(new PicassoHelper.PicassoCircleTransformation()).into(image_Cover);

        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing) {
                    playing = false;
                    playIcon.setImageResource(R.drawable.icon_player_play);
                    player.setPlayWhenReady(false);
                    image.clearAnimation();

                }else{
                    playing = true;
                    boolean playing = false;
                    playIcon.setImageResource(R.drawable.icon_player_pause);
                    player.setPlayWhenReady(playWhenReady);
                    image.startAnimation(rotate);

                }
            }
        });
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentPosition = player.getCurrentPosition();
                // check if seekForward time is lesser than song duration
                if(currentPosition + seekForwardTime <= player.getDuration()){
                    // forward song
                    long position = currentPosition + seekForwardTime;
                    player.seekTo(currentWindow, position);
                  //  player.seekTo(currentPosition + seekForwardTime);
                }else{
                    // forward to end position
                    player.seekTo(player.getDuration());
                }
               // player.seekTo(currentWindow, playbackPosition);
            }
        });
        btnBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentPosition = player.getCurrentPosition();
                // check if seekBackward time is greater than 0 sec
                if(currentPosition - seekBackwardTime >= 0){
                    // forward song
                    long position = currentPosition - seekBackwardTime;
                    player.seekTo(currentWindow, position);
                }else{
                    // backward to starting position
                    player.seekTo(currentWindow, playbackPosition);
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaSource mediaSource = playNextSong();
                player.setPlayWhenReady(playWhenReady);
                player.seekTo(currentWindow, playbackPosition);
                player.prepare(mediaSource, false, false);
                playIcon.setImageResource(R.drawable.icon_player_pause);
                seekSongProgressbar.setProgress(0);
                seekSongProgressbar.setMax(100);

                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        // task to run goes here
                        updateProgressBar();
                    }
                };
                Timer timer = new Timer();
                long delay = 0;
                long intevalPeriod = 1 * 1000;
                // schedules the task to be run in an interval
                timer.scheduleAtFixedRate(task, delay,
                        intevalPeriod);
            }
        });
     //   int progress = (int)(utils.getProgressPercentage(player.getCurrentPosition(), player.getDuration()));

      /*  Runnable percentagUpdate = new Runnable() {
            @Override
            public void run() {

            }
        };*/
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
          //  initializePlayer();

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

        Uri uri = Uri.parse(getString(R.string.media_url_mp4_old2));
        MediaSource mediaSource = buildMediaSource(uri);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playbackPosition);
        player.prepare(mediaSource, false, false);
        playIcon.setImageResource(R.drawable.icon_player_pause);
        seekSongProgressbar.setProgress(0);
        seekSongProgressbar.setMax(100);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                updateProgressBar();
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay,
                intevalPeriod);
        player.addListener(new com.google.android.exoplayer2.Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

            }
            @Override
            public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {

            }

            @Override
            public void onIsPlayingChanged(boolean isPlaying) {

            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {
            //    updateProgressBar();
            }
        });



    }

    private void updateProgressBar(){

        updateTask = new Runnable() {
            @Override
            public void run() {
                Double percentage = (double) 0;
                long currentSeconds = (int) (player.getCurrentPosition() / 1000);
                long totalSeconds = (int) (player.getDuration() / 1000);
                // calculating percentage
                percentage =(((double)currentSeconds)/totalSeconds)*100;

                // return percentage

                seekSongProgressbar.setProgress(percentage.intValue());
            }
        };
        mHandler.postDelayed(updateTask ,100);
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
        Uri audioUri = Uri.parse(getString(R.string.media_url_mp4_old));
        MediaSource mediaSource2 = mediaSourceFactory.createMediaSource(audioUri);

        return new ConcatenatingMediaSource(mediaSource1, mediaSource2);
    }

    private MediaSource playNextSong(){
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(getActivity(), "exoplayer-codelab");
        ProgressiveMediaSource.Factory mediaSourceFactory =
                new ProgressiveMediaSource.Factory(dataSourceFactory);
        Uri audioUri = Uri.parse(getString(R.string.media_url_mp4_old));
        MediaSource mediaSource1 = mediaSourceFactory.createMediaSource(audioUri);
        return  mediaSource1;
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