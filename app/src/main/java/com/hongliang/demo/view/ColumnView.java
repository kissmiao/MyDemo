package com.hongliang.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;


import com.hongliang.demo.R;
import com.hongliang.demo.util.UIHelper;

import java.math.BigDecimal;

public class ColumnView extends View {
    private Context context;
    private DisplayMetrics dm;
    private int screenWidth;
    private int maxWidth;

    private int maxSize;
    private int currentSize;
    private int color;

    public ColumnView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }


    private void init() {
        dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        maxWidth = screenWidth / 2;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        double unit = deciMal(maxWidth, maxSize);
        double sizeWidth = unit * currentSize;
        setMeasuredDimension((int) sizeWidth, UIHelper.dp2px(context, 20));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(context.getColor(R.color.darkorchid));
    }


    public void setData(@NonNull int maxSize, @NonNull int currentSize, int color) {
        this.maxSize = maxSize;
        this.currentSize = currentSize;
        this.color = color;
        invalidate();
    }

    private double deciMal(int top, int below) {
        double result = new BigDecimal((float) top / below).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }
}
