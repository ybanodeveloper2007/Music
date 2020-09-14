package com.ritmoli.ritmoli;

import android.app.Application;

import com.facebook.FacebookSdk;

public class RitmoliApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());

    }
}
