package com.hongliang.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hongliang.demo.util.UIHelper;


public class PaintView extends View {
    private Context mContext;

    public PaintView(Context context) {
        this(context, null);
    }


    public PaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = 200;
        int textSize = UIHelper.Dp2Px(mContext, 14);
        TextPaint FontPaint = new TextPaint();
        FontPaint.setTextSize(textSize);

        String text = "我爱中国";

        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(textSize);
        mPaint.setTextAlign(Paint.Align.LEFT);

        mPaint.setStrikeThruText(true);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText(text, left, 100, mPaint);

        Log.i("bqt", "ascent()的值为" + mPaint.ascent() + "，descent()的值为" + mPaint.descent());//
        Log.i("bqt", "字符的高度为" + (-mPaint.ascent() + mPaint.descent()) + "，字符的长度为" + mPaint.measureText(text) + "字符的长度为" + UIHelper.getTextWidth(text, textSize));//4
        //   Log.i("bqt", "测量的高度为" + tv_info.getMeasuredHeight() + "，测量的宽度为" + tv_info.getMeasuredWidth());//49，190
        Rect mRect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), mRect);
        Log.i("bqt", "字符的边界为" + mRect.left + "，" + mRect.top + "，" + mRect.right + "，" + mRect.bottom);//
        Log.i("bqt", "字符的高度为" + (mRect.bottom - mRect.top) + "，字符的长度为" + (mRect.right - mRect.left));//


    }

    private void log(String message) {
        Log.i("TAG", message);
    }

}
