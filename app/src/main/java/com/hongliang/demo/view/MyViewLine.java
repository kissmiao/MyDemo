package com.hongliang.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.hongliang.demo.R;

/**
 * @author: wanghongliang
 * @date: 2020-07-15
 * @description
 */
public class MyViewLine extends View {
    private Paint mLaserPaint;

    private DisplayMetrics dm;
    private int screenWidth;


    public MyViewLine(Context context) {
        super(context);
        init();
    }

    public MyViewLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyViewLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mLaserPaint = new Paint();
        mLaserPaint.setAntiAlias(true);
        //  mLaserPaint.setColor(getResources().getColor(R.color.mediumvioletred));
     //   mLaserPaint.setColor(R.drawable.gradient);

        dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        LinearGradient linearGradient = new LinearGradient(0, 0, screenWidth, 0,
                new int[]{Color.rgb(255, 189, 22),
                        Color.rgb(221, 43, 6),
                        Color.rgb(0, 25, 233),
                        Color.rgb(0, 232, 210)},
                new float[]{0, .3F, .6F, .9F}, Shader.TileMode.CLAMP);
        //new float[]{},中的数据表示相对位置，将150,50,150,300，划分10个单位，.3，.6，.9表示它的绝对位置。300到400，将直接画出rgb（0,232,210）
        mLaserPaint.setShader(linearGradient);




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLaser(canvas);
    }


    /**
     * 绘制激光线
     */
    private void drawLaser(Canvas canvas) {
        canvas.drawRect(0, 30, screenWidth, 40, mLaserPaint);
    }

}
