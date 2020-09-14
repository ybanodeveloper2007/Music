package com.ritmoli.music.helpers;

import android.util.Log;

public class LogUtils {
    public static void printErrorMessage(String source, Exception e) {
        if (e.getMessage() == null) {
            Log.e(source, "Message is null");
        } else {
            Log.e(source, e.getMessage());
        }
    }

    public static void printErrorMessage (String source, String msg) {
        if (msg == null)
            Log.e(source, "Msg is null");
        else
            Log.e(source, msg);
    }
}
