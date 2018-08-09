package com.veeca.ted.v.utils;

import android.util.Log;

import com.veeca.ted.v.BuildConfig;

/**
 * Created by Ted on 2017/7/21.
 */

public class LogUtils {
    public static final boolean isDebug = BuildConfig.DEBUG;

    /**
     * 打印一个debug等级的 log
     */
    public static void d(String msg) {
        if (isDebug) {
            Log.d("ted_", msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(String msg) {
        if (isDebug) {
            Log.e("ted_", msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(Class cls, String msg) {
        if (isDebug) {
            Log.e("ted_" + cls.getSimpleName(), msg);
        }
    }
}
