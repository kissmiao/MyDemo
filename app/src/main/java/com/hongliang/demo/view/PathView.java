package com.hongliang.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


//https://blog.csdn.net/qq_37918409/article/details/81560446
public class PathView extends View {

    /*Paint.Style.FILL：填充内部
    Paint.Style.FILL_AND_STROKE ：填充内部和描边
    Paint.Style.STROKE ：描边*/


    private Path mPath1;


    private Paint mPaint;
    private Paint mPaint1;
    private Paint mPaint2;
    private Paint mPaint3;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setDither(true);//防抖动
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setStrokeWidth(10);
    }


    private void initPaint1() {
        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setAntiAlias(true);//抗锯齿
        mPaint1.setDither(true);//防抖动
    }

    private void initPaint2() {
        mPaint2 = new Paint();
        mPaint2.setColor(Color.BLUE);
        mPaint2.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint2.setAntiAlias(true);//抗锯齿
        mPaint2.setDither(true);//防抖动
        mPaint2.setStrokeCap(Paint.Cap.ROUND);
        mPaint2.setStrokeJoin(Paint.Join.MITER);
        mPaint2.setTextAlign(Paint.Align.LEFT);
    }

    private void initPaint3() {
        mPaint3 = new Paint();
        mPaint3.setColor(Color.BLUE);
        mPaint3.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint3.setAntiAlias(true);//抗锯齿
        mPaint3.setDither(true);//防抖动
        mPaint3.setStrokeCap(Paint.Cap.SQUARE);
        mPaint3.setStrokeJoin(Paint.Join.ROUND);
        mPaint3.setTextAlign(Paint.Align.RIGHT);
    }


    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPath1 = new Path();
        initPaint();
        initPaint1();
        initPaint2();
        initPaint3();
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       /* mPaint.setColor(Color.BLUE);
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
        canvas.drawPath(path2, mPaint);*/


/*
        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(300, 100);
        path.lineTo(100, 300);
        canvas.drawPath(path, mPaint1);*/


        Paint mPaint = new Paint();             // 创建画笔
        mPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10

        Path path3 = new Path();
        path3.moveTo(100, 100);
        path3.lineTo(100, 200);
        canvas.drawPath(path3, mPaint);

        mPaint.reset();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

        Path path4 = new Path();
        path4.moveTo(100, 100);
        path4.rLineTo(100, 200);
        canvas.drawPath(path4, mPaint);

        mPaint.reset();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);    // 填充模; // 填充模式 - 填充内部
        mPaint.setStrokeWidth(10);

        Path path5 = new Path();
        path5.moveTo(200,100);
        path5.lineTo(400,100);
        path5.lineTo(400,300);
        path5.close();
        canvas.drawPath(path5,mPaint);

    }
}
