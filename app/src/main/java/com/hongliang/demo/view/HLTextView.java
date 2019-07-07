package com.hongliang.demo.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.hongliang.demo.R;


public class HLTextView extends TextView {


    public HLTextView(Context context) {
        super(context);
    }

    public HLTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.ZTV_def_style_arrt);
    }

    public HLTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parse(context, attrs, defStyleAttr);
    }

    private void parse(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ZTextViewStyle, defStyleAttr, R.style.ZTV_default_style);
        String one = typedArray.getString(R.styleable.ZTextViewStyle_attr_1);
        String two = typedArray.getString(R.styleable.ZTextViewStyle_attr_2);
        String three = typedArray.getString(R.styleable.ZTextViewStyle_attr_3);
        String four = typedArray.getString(R.styleable.ZTextViewStyle_attr_4);

        log("one = " + one);
        log("two = " + two);
        log("three = " + three);
        log("four = " + four);

        typedArray.recycle();
    }

    private void log(String msg) {
        Log.i("ZDL", msg);
    }
}
