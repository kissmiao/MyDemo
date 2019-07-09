package com.hongliang.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


//https://blog.csdn.net/qq_37918409/article/details/81560446
public class PathView extends View {

    /*Paint.Style.FILL：填充内部
    Paint.Style.FILL_AND_STROKE ：填充内部和描边
    Paint.Style.STROKE ：描边*/

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


    }


    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint mPaint = new Paint();             // 创建画笔
        mPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - ：填充内部
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10



        Path mPath = new Path();
        mPath.moveTo(100, 300);
       // mPath.rCubicTo(100, -300, 200, 300, 300, 0);

     //   mPath.cubicTo(100, 300,300, 0, 500, 300);
     //   mPath.cubicTo(500, 300,700, 600, 900, 300);

        mPath.rQuadTo(100,-300,200,0);
        mPath.rQuadTo(100,300,200,0);
        canvas.drawPath(mPath, mPaint);

        mPaint.reset();
        mPaint.setColor(Color.GREEN);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - ：填充内部
        mPaint.setStrokeWidth(10);

        mPath.reset();
        mPath.moveTo(100, 300);
        mPath.rCubicTo(100, -300, 200, 0, 300, 300);
        //    mPath.rCubicTo(100, -200, 200, 0, 300, 200);
      //  mPath.rCubicTo(100, 0, 200, -200, 300, 200);
        canvas.drawPath(mPath, mPaint);


    }
}
