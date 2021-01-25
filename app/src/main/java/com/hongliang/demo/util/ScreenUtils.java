package com.hongliang.demo.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class ScreenUtils {


    public static int  getPxFromDp(Resources resources, int size) {
        final float scale = resources.getDisplayMetrics().density;
        return (int) (size / scale + 0.5f);
    }

    public static int getScreenWidth(Context context){
        WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm= new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
    public static int getScreenHeight(Context context){
        WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm= new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
}
