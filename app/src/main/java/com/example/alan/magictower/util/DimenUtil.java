package com.example.alan.magictower.util;


import android.content.Context;
import android.util.DisplayMetrics;


public class DimenUtil {

    public static int getScreenWidth(Context context) {

        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeight(Context context) {

        return getDisplayMetrics(context).heightPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {


        final DisplayMetrics dm = context.getResources().getDisplayMetrics();

        return dm;
    }
}
