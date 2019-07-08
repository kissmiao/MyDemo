package com.hongliang.demo.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.hongliang.demo.R;


public class HLTextView extends TextView {


    @Override
    protected void onFinishInflate() {
        log("View onFinishInflate 子控件均被映射成xml");
        super.onFinishInflate();

    }

    @Override
    protected void onAttachedToWindow() {
        log("View onAttachedToWindow 当前View附加到Window");
        super.onAttachedToWindow();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        log("View onMeasure View测量");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        log("View onSizeChanged View尺寸发生变化");
        super.onSizeChanged(w, h, oldw, oldh);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        log("View onLayout 设置View的位置");
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        log("View onWindowFocusChanged View所在Window获得或失去焦点");
        super.onWindowFocusChanged(hasWindowFocus);
    }


    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        log("View onWindowVisibilityChanged View或其祖先的可见性改变");
        super.onWindowVisibilityChanged(visibility);

    }


    @Override
    protected void onDetachedFromWindow() {
        log("View onDetachedFromWindow View从Window上分离");
        super.onDetachedFromWindow();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        log("View onDraw Canvas上开始绘制View");
        super.onDraw(canvas);
    }

    public HLTextView(Context context) {
        this(context,null);
    }

    public HLTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.ZTV_def_style_arrt);
    }

    public HLTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parse(context, attrs, defStyleAttr);
        log("View TextView 调用构造方法");
    }

    private void parse(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ZTextViewStyle, defStyleAttr, R.style.ZTV_default_style);
        String one = typedArray.getString(R.styleable.ZTextViewStyle_attr_1);
        String two = typedArray.getString(R.styleable.ZTextViewStyle_attr_2);
        String three = typedArray.getString(R.styleable.ZTextViewStyle_attr_3);
        String four = typedArray.getString(R.styleable.ZTextViewStyle_attr_4);

        typedArray.recycle();
    }

    private void log(String msg) {
        Log.i("TAG", msg);
    }
}
