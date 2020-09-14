package com.ritmoli.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.ritmoli.music.R;
import com.ritmoli.music.fragment.EditProfileFragment;
import com.ritmoli.music.fragment.SettingFragment;

public class CustomDialog {

    public static void showDialog(String header, String message, final Context mcontext, String chek){
        final Dialog dialog = new Dialog(mcontext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialogue);

        // Typeface typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "HindGuntur-Regular.ttf"));
        // Typeface tf = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "HindGuntur-Light.ttf"));
        //  TextView customTextView = (TextView) dialog.findViewById(R.id.dialog_header);

        TextView  tvImageCover = (TextView) dialog.findViewById(R.id.label_popup_one);
        TextView  tvSetting = (TextView) dialog.findViewById(R.id.label_popup_two);
        TextView  tvInfo = (TextView) dialog.findViewById(R.id.label_popup_three);
        TextView  tvClose = (TextView) dialog.findViewById(R.id.label_close);

        if(chek.equalsIgnoreCase("1")){

            //dialog.show();
            tvImageCover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                }
            });

            tvSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

/*
                    SettingFragment termsConditionFragment = new SettingFragment();
                    FragmentTransaction fragmentTransaction =v.getContext().beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, termsConditionFragment);
                    fragmentTransaction.commit();*/

                }

            });

            tvInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                }
            });

            tvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();

                }
            });
        }

        dialog.show();
    }
}
