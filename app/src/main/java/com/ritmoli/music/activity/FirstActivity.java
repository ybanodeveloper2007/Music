package com.ritmoli.music.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ritmoli.music.R;
import com.ritmoli.music.fragment.UserSessionManager;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnRegister,btnSignIn;
    private UserSessionManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);

        btnSignIn=(Button)findViewById(R.id.LoginButton);
        btnRegister=(Button)findViewById(R.id.RegisterButton);
        btnSkip=(Button)findViewById(R.id.SkipButton);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FirstActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FirstActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

}