package com.yy.android.myapplicationaaq;

import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {
    public static int dipToPx(Context context, int dip) {
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (displayMetrics.density * dip + 0.5f);
    }

    public static void te(){
        // BitmapFactory.decodeFile()
    }
}
