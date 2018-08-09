package com.veeca.ted.v.myclass;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Ted on 2017/9/29.
 */

public class SelectDialog extends Dialog {
    public SelectDialog(@NonNull Context context) {
        super(context);
    }

    public SelectDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SelectDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
