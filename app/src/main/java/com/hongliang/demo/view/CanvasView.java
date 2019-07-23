package com.hongliang.demo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class CanvasView extends View {


    private Paint mPaint;
    private int mViewWidth, mViewHeight;// 控件宽高

    private int curValue = 0;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initAnimator();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        /*
         * 获取控件宽高
         */
        mViewWidth = w;
        mViewHeight = h;
    }

    private void init() {

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
/*
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        // 实例化路径
        Path    mPath = new Path();
        // 移动起点至[50,50]
        mPath.moveTo(50, 50);
        mPath.lineTo(75, 23);
        mPath.lineTo(150, 100);
        mPath.lineTo(80, 110);
        // 闭合路径
        mPath.close();

        // 在原始画布上绘制蓝色
        canvas.drawColor(Color.BLUE);
        // 按照路径进行裁剪
        canvas.clipPath(mPath);
        // 在裁剪后剩余的画布上绘制红色
        canvas.drawColor(Color.RED);*/


       /* canvas.drawColor(Color.BLUE);
        canvas.drawRect(new Rect(100, 100, 300, 200), mPaint);

        Path path = new Path();
        path.moveTo(100, 0);
        path.lineTo(100, mViewHeight);
        canvas.clipPath(path);
        canvas.drawColor(Color.RED);*/





        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        canvas.drawColor(Color.BLUE);
        canvas.drawRect(new RectF(20, 20, 120, 120), mPaint);
        canvas.drawCircle(120, 70, 50, mPaint);
        canvas.clipRect(new RectF(20, 20, 120, 120));
        Path path = new Path();
      //  path.addCircle(120, 70, 50, Path.Direction.CCW);
        path.addRect(new RectF(20, 20, 120, 120),Path.Direction.CCW);

        canvas.clipPath(path, Region.Op.INTERSECT);
        canvas.drawColor(Color.GREEN);

    }


    private void initAnimator() {

        ValueAnimator animator = ValueAnimator.ofInt(0, 30);
        animator.setDuration(1000);
        animator.setStartDelay(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                curValue = (int) animation.getAnimatedValue();
                invalidate();

            }
        });
        animator.start();
    }


}
