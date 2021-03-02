package com.example.squareviewlib;

import android.util.Log;

/**
 * @author: SuTs
 * @created at: 2021/3/2 15:37
 * @Describe:Log日志打印
 */
public class MyLog {
    private static final String TAG = "MyLog";

    public static void e(String msg) {
        if (isLog()) {
            Log.e(TAG, "e: " + msg);
        }
    }

    public static void w(String msg) {
        if (isLog()) {
            Log.w(TAG, "w: " + msg);
        }
    }

    public static void d(String msg) {
        if (isLog()) {
            Log.d(TAG, "d: " + msg);
        }
    }

    static boolean isLog() {
        return BuildConfig.DEBUG;
    }
}
