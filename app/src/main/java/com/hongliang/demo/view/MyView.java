package com.hongliang.demo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by whl on 16/6/30.
 */
public class MyView extends View {

    private Paint mPaint;
    private Path mPath;
    //一个波的波长
    private int mItemWaveLength = 400;
    private int dx;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }


    private void initPath() {
        mPath.reset();
        int originY = 100;

        //起始位置向左移动有个波长
        mPath.moveTo(-mItemWaveLength + dx, originY);

        int halfWaveLen = mItemWaveLength / 2;
        //i<=getWidth()+mItemWaveLength   最后画的波长超过屏幕有个波长
        //Y坐标为—50，就是说以前一个点的Y坐标0为起始点，向上移动50

        for (int i = -mItemWaveLength; i <= getWidth() + mItemWaveLength; i += mItemWaveLength) {
            mPath.rQuadTo(halfWaveLen / 2, -50, halfWaveLen, 0);
            mPath.rQuadTo(halfWaveLen / 2, 50, halfWaveLen, 0);
        }

        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();
    }


    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //rQuadTo这个是以moveTo点的坐标为相对点
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawPath(mPath, mPaint);
    }


    ValueAnimator animator;

    public void startAnim() {

        animator = ValueAnimator.ofInt(0, mItemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);//设置循环次数
        animator.setInterpolator(new LinearInterpolator());//设置动画差值器
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                initPath();
                postInvalidate();
            }
        });
        animator.start();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.i("TAG", "event.getRawX()：" + event.getRawX() + "===" + event.getRawY());
        Log.i("TAG", "event.getX()：" + event.getX() + "===" + event.getY());

        Log.i("TAG", "getX：" + getX() + "===" + getY());
        Log.i("TAG", "getTop：" + getTop() + "==" + getBottom() + "===" + getLeft()+"===" + getRight());
        Log.i("TAG", "getTranslationX：" + getTranslationX() + "===" + getTranslationY());
        Log.i("TAG", "getScaleX：" + getScaleX() + "===" + getScaleY());

        return true;


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }
}
