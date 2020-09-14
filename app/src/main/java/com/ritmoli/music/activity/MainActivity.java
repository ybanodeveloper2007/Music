package com.ritmoli.music.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.view.View;
import com.ritmoli.music.R;
import com.ritmoli.music.fragment.HomeFragment;
import com.ritmoli.music.fragment.LibraryFragment;
import com.ritmoli.music.fragment.PlaylistFragment;
import com.ritmoli.music.fragment.PlaylistFragment;
import com.ritmoli.music.fragment.ProfileFragment;
import com.ritmoli.music.fragment.UserSessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FrameLayout fm0,fm1,fm2,fm3,fm4;
    Fragment fragment = null;
    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_navigationbar);

        // Session class instance
        session = new UserSessionManager(getApplicationContext());

        if(session.isFirstTimeLaunch()){
            session.setFirstTimeLaunch(false);
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            finish();
        }

        if(session.checkLogin())
            finish();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        String id = user.get(UserSessionManager.KEY_ID);

        fm0=(FrameLayout)findViewById(R.id.llcustom0);
        fm1=(FrameLayout)findViewById(R.id.llcustom2);
        fm2=(FrameLayout)findViewById(R.id.llcustom3);
        fm3=(FrameLayout)findViewById(R.id.llcustom4);
        fm4=(FrameLayout)findViewById(R.id.llcustom5);

        fm0.setOnClickListener(this);
        fm1.setOnClickListener(this);
        fm2.setOnClickListener(this);
        fm3.setOnClickListener(this);
        fm4.setOnClickListener(this);

        loadFragment(new HomeFragment());

      /*  HomeFragment termsConditionFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, termsConditionFragment, "termsConditionFragment").addToBackStack("termsConditionFragment");
        fragmentTransaction.commit();*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.llcustom0:

                loadFragment(new HomeFragment());

            case R.id.llcustom2:
                loadFragment(new PlaylistFragment());
                break;

            case R.id.llcustom3:

                loadFragment(new PlaylistFragment());
                break;

            case R.id.llcustom4:

                loadFragment(new LibraryFragment());
                break;

            case R.id.llcustom5:

                loadFragment(new ProfileFragment());
                break;
        }
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack("ProfileFragment")
                    .commit();

            return true;

        }
        return false;
    }

    private void register (){

        Intent intent =new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);

    }

}