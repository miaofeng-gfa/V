package com.veeca.ted.v.utils;

import android.app.Activity;
import android.widget.Toast;

import com.veeca.ted.v.constant.MyApplication;


/**
 * Created by Ted on 2017/7/21.
 */

public class ToastUtils {
    public static Toast toast;

    public static void setToast(String str) {

        if (toast == null) {
            toast = Toast.makeText(MyApplication.getAppContext(), str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
        }
        toast.show();
    }

    /**
     * 显示toast
     *
     * @param ctx
     * @param msg
     */
    public static void showToast(final Activity ctx, final String msg) {
        // 判断是在子线程，还是主线程
        if ("main".equals(Thread.currentThread().getName())) {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        } else {
            // 子线程
            ctx.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
