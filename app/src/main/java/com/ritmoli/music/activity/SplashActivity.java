package com.ritmoli.music.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.ritmoli.music.R;
import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView  imgSplash;
    GifImageView gifImageView;
        Handler handler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            imgSplash=(ImageView)findViewById(R.id.text_home);
            gifImageView=(GifImageView)findViewById(R.id.imageView);
            startSplash();

          /*  handler=new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            },3000);*/
        }

    public void startSplash() {

        Animation fadeout = new AlphaAnimation(1.f, 1.f);
        fadeout.setDuration(5000);
        final View viewToAnimate = gifImageView;
        fadeout.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                gifImageView.setBackgroundResource(R.drawable.webp);//splash_screen is your .gif file
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent=new Intent(SplashActivity.this,FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });
        gifImageView.startAnimation(fadeout);
    }
}


