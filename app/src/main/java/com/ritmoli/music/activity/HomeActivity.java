package com.ritmoli.music.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenuItemView;
import com.ritmoli.music.R;
import com.ritmoli.music.fragment.HomeFragment;
import com.ritmoli.music.fragment.PlaylistFragment;
import com.ritmoli.music.fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity  {
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_navigationbar);

        //loading the default fragment
        loadFragment(new HomeFragment());
        FrameLayout llcustom0 = findViewById(R.id.llcustom0);
        FrameLayout llcustom2 = findViewById(R.id.llcustom2);
        FrameLayout llcustom3 = findViewById(R.id.llcustom3);
        FrameLayout llcustom5 = findViewById(R.id.llcustom5);
        llcustom0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());

            }
        });
        llcustom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new PlaylistFragment());
            }
        });
        llcustom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ProfileFragment());
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }



}

