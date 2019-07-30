package com.hongliang.demo.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;

public class FloatingManager {
    private WindowManager mWindowManager;
    private volatile static FloatingManager mInstance;
    private Context mContext;

    //单例模式，其实这里可以不用DLC形式的
    public static FloatingManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (FloatingManager.class) {
                mInstance = new FloatingManager(context);
            }
        }
        return mInstance;
    }

    private FloatingManager(Context context) {
        mContext = context;
        //初始化获取WindowManager对象
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    }

    /**
     * 添加悬浮窗的View
     *
     * @param view
     * @param params
     * @return
     */
    public boolean addView(View view, WindowManager.LayoutParams params) {

        try {
            mWindowManager.addView(view, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 移除悬浮窗View
     *
     * @param view
     * @return
     */
    public boolean removeView(View view) {
        try {
            mWindowManager.removeView(view);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新悬浮窗参数
     *
     * @param view
     * @param params
     * @return
     */
    public boolean updateView(View view, WindowManager.LayoutParams params) {
        try {
            mWindowManager.updateViewLayout(view, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
