package com.hongliang.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;


/**
 * Created by Administrator on 2016/8/5.
 * <p/>
 * 用几个点生成二阶贝塞尔曲线
 * <p/>
 * 获取贝塞尔曲线上的点
 */
public class MView3 extends View {


    private Context mContext;
    Scroller scroller;
    // 辅助点
    private Paint mPaint;
    private Path mPath;

    public MView3(Context context) {

        this(context, null);
    }

    public MView3(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getHeightSize(getSuggestedMinimumHeight(), heightMeasureSpec));

    }


    public int getHeightSize(int size, int measureSpec) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case MeasureSpec.AT_MOST:
                result = 200;
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }

    private void init() {
        scroller = new Scroller(mContext);
        mPaint = new Paint();
        mPath = new Path();
        // 抗锯齿
        mPaint.setAntiAlias(true);
        // 防抖动
        mPaint.setDither(true);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        // 重置路径
        mPath.reset();

        mPath.moveTo(100, 100);
        mPath.rQuadTo(100, -100, 200, 0);
        mPath.rQuadTo(100, 100, 200, 0);


        canvas.drawPath(mPath, mPaint);

    }


    public void smoothScrollTo(int desX, int desY) {
        int scrollX = getScrollX();
        int deltaX = desX - scrollX;

        int scrollY = getScrollY();
        int deltaY = desY - scrollY;
        scroller.startScroll(scrollX, scrollY, deltaX, deltaY, 5000);
        invalidate();


    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            // ((View) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            //   scrollBy(scroller.getCurrX(), scroller.getCurrY());
              scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();//重绘，在重绘调用draw（）方法中，内部会调用View的computeScroll()方法
        }
    }
}