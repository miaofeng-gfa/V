package com.veeca.ted.v.utils;

import android.app.Activity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.veeca.ted.v.R;
import com.veeca.ted.v.myclass.SelectDialog;

/**
 * Created by Ted on 2017/10/19.
 */

public class LoadUtil {

    private static SelectDialog dialog;


    /**
     * 加载动画
     *
     * @author TED
     * created at 2017/10/19 10:58
     */
    public static void showLoad(Activity activity) {
        dialog = new SelectDialog(activity, R.style.load);
        LayoutInflater inflater = LayoutInflater.from(activity);
        final View viewDialog = inflater.inflate(R.layout.dialog_load, null);
        Glide.with(activity).load(R.drawable.loading).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into((ImageView) viewDialog.findViewById(R.id.load_img));
        Display display = activity.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //设置dialog的宽高为屏幕的宽高
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        dialog.setContentView(viewDialog, layoutParams);
        dialog.show();
    }

    public static void hideLoad() {
        dialog.cancel();
        dialog = null;
    }
}
