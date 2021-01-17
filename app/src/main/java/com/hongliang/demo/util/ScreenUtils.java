package com.hongliang.demo.util;

import android.content.res.Resources;

public class ScreenUtils {


    public static int  getPxFromDp(Resources resources, int size) {
        final float scale = resources.getDisplayMetrics().density;
        return (int) (size / scale + 0.5f);
    }
}
