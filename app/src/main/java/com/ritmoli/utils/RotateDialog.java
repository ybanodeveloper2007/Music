package com.ritmoli.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.ritmoli.music.R;
import com.victor.loading.rotate.RotateLoading;


/**
 * Created by dell on 01-12-2017.
 */

public class RotateDialog extends Dialog {

    private static RotateDialog f;
    private static Activity preActivity;

    public static RotateDialog newInstance(Activity activity) {
        if (f == null || preActivity != activity) {
            f = new RotateDialog(activity);
            preActivity = activity;
        }

        f.show();
        f.show();

        return f;

    }

    private RotateDialog(Activity activity) {
        super(activity);
    }

    private RotateLoading rotateLoading;
   // private GifView rotateLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setContentView(R.layout.dialog_rotate);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        rotateLoading = (RotateLoading) findViewById(R.id.rotateloading);

    }

    public void startLoading() {
        rotateLoading.start();
    }

    public void stopLoading() {
        if (rotateLoading.isStart())
            rotateLoading.stop();

        dismiss();
    }
}
