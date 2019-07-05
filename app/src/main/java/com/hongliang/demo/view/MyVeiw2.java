package com.hongliang.demo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyVeiw2 extends View {

    private Paint mPaint;

    public MyVeiw2(Context context) {
        this(context, null);
    }

    public MyVeiw2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setStrokeWidth(50);
    }


    //rQuadTo这个是以moveTo点的坐标为相对点
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mPaint.setColor(Color.BLUE);
        mPaint.setAlpha(255);


        mPaint.setColor(Color.BLUE);
        mPaint.setAlpha(255);
        mPaint.setStyle(Paint.Style.STROKE);//设置画笔的样式
        mPaint.setStrokeWidth(50);//画笔的宽度
        mPaint.setStrokeCap(Paint.Cap.BUTT);//线帽
        mPaint.setStrokeJoin(Paint.Join.BEVEL);

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(300, 100);
        path.lineTo(100, 300);
        path.close();
        canvas.drawPath(path, mPaint);

        mPaint.reset();//重置
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.BUTT);//圆形
        mPaint.setStrokeJoin(Paint.Join.ROUND);//圆弧

        Path path1 = new Path();
        path1.moveTo(100, 400);


        path1.lineTo(getWidth(), 400);
        path1.lineTo(getWidth(), 700);
        path1.lineTo(100, 700);
        path1.close();
        canvas.drawPath(path1, mPaint);

        mPaint.reset();//重置
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.BUTT);//没有
        mPaint.setStrokeJoin(Paint.Join.MITER);//锐角

        Path path2 = new Path();
        path2.moveTo(100, 800);
        path2.lineTo(300, 800);
        path2.lineTo(100, 1100);
        path2.close();
        canvas.drawPath(path2, mPaint);
    }


}
