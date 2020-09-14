package com.ritmoli.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.gdacciaro.iOSDialog.iOSDialog;
import com.ritmoli.music.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by user on 1/11/2018.
 */

public class StaticUtil {
    private static int i = 0;

    public static View.OnClickListener udListener(final Activity activity) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                StaticUtil.showToast(activity, activity.getString(R.string.ud_toast));
//                Toast.makeText(activity, activity.getString(R.string.ud_toast), Toast.LENGTH_SHORT).show();
               // showIOSLikeDialog(activity,activity.getString(R.string.ud_toast));
            }
        };
    }

    public static void noInternetToast(final Activity activity) {
        StaticUtil.showToast(activity, activity.getString(R.string.noInternet));
//        Toast.makeText(activity, activity.getString(R.string.noInternet), Toast.LENGTH_SHORT).show();
    }

    public static void showToast(final Activity activity, final String toastBody) {
        Toast.makeText(activity, toastBody, Toast.LENGTH_SHORT).show();
    }

    public static boolean isConnectedToInternet(final Activity activity) {
        try {
            ConnectivityManager cm =
                    (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            return isConnected;
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

   /* public static final RequestOptions getRequestOptions(Activity activity) {

        RequestOptions requestOptions = new RequestOptions().disallowHardwareConfig();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        requestOptions.skipMemoryCache(false);
        requestOptions.format(DecodeFormat.PREFER_ARGB_8888);

        if (i == 0) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight1)));
            i++;
        } else if (i == 1) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight2)));
            i++;
        } else if (i == 2) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight3)));
            i++;
        } else if (i == 3) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight4)));
            i++;
        } else if (i == 4) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight5)));
            i++;
        } else if (i == 5) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight6)));
            i++;
        } else if (i == 6) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight7)));
            i++;
        } else if (i == 7) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight8)));
            i++;
        } else if (i == 8) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight9)));
            i++;
        } else if (i == 9) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight10)));
            i++;
        } else if (i == 10) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight11)));
            i++;
        } else if (i == 11) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight12)));
            i++;
        } else if (i == 12) {
            requestOptions.placeholder(new ColorDrawable(activity.getResources().getColor(R.color.colorLight13)));
            i = 0;
        }

        return requestOptions;
    }*/

    public static void expand(final View v) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void showIOSLikeDialog(Activity activity,String messgeBody){
        final iOSDialog iOSDialog = new iOSDialog(activity);
        iOSDialog.setTitle(activity.getString(R.string.app_name));
        iOSDialog.setSubtitle(messgeBody);
        iOSDialog.setPositiveLabel("Ok");
        iOSDialog.setBoldPositiveLabel(true);
        iOSDialog.setNegativeListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOSDialog.dismiss();
            }
        });
        iOSDialog.setPositiveListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOSDialog.dismiss();
            }
        });
        iOSDialog.show();
    }

    public static final String loadJSONFromAsset(Activity activity) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open("myHome.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
