package com.hongliang.demo.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.hongliang.demo.R;
import com.hongliang.demo.util.UIHelper;

public class MyDialog2 extends Dialog {
    private Context mContext;

    public MyDialog2(@NonNull Context context) {
        super(context, R.style.dialog_style);
        this.mContext = context;
    }

    public MyDialog2(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MyDialog2(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * todo 在布局中是否居中没有关系，在show中设置后自己会居中
         */
        setContentView(R.layout.dialog_view);
    }

    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        getWindow().getDecorView().setPadding(UIHelper.Dp2Px(mContext, 30), 0, UIHelper.Dp2Px(mContext, 30), 0);

        getWindow().setAttributes(layoutParams);

    }
}
