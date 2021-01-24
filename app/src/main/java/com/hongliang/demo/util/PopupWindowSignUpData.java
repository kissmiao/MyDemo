package com.hongliang.demo.util;

import android.app.Activity;
import android.view.Gravity;

import com.hongliang.demo.R;


/**
 * Created by whl on 16/9/25.
 */
public class PopupWindowSignUpData {

    private CommonPopupWindow mApplayPopupWindow;
    private Activity mActivity;

    public PopupWindowSignUpData(Activity activity) {
        this.mActivity = activity;
    }

    public void showPopupWindow() {

        if (mApplayPopupWindow == null) {
            // 实例化SelectPicPopupWindow
            mApplayPopupWindow = new CommonPopupWindow(mActivity, R.layout.dd_sign_up_popupwindow, R.style._AnimBottom);
        }
        // 显示窗口
        mApplayPopupWindow.showAtLocation(mActivity.findViewById(R.id.ll_popw), Gravity.BOTTOM | Gravity.CENTER, 0,
                0); // 设置layout在PopupWindow中显示的位置

    }

}
