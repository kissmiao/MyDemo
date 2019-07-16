package com.hongliang.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup {


    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int widthModel = MeasureSpec.getMode(widthMeasureSpec);
        int heightModel = MeasureSpec.getMode(heightMeasureSpec);


        /**
         * 宽度是取最宽的
         */
        int lineWidth = 0;
        /**
         * 高度是相加
         */
        int lineHeight = 0;

        int size = getChildCount();

        for (int i = 0; i < size; i++) {
            View child = getChildAt(i);
            // 测量每一个child的宽和高
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            // 得到child的lp
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            lineHeight += child.getMeasuredHeight() + lp.topMargin
                    + lp.bottomMargin;
            lineWidth = Math.max(lineWidth, child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
        }

        setMeasuredDimension((widthModel == MeasureSpec.EXACTLY) ? widthSize
                : lineWidth, (heightModel == MeasureSpec.EXACTLY) ? heightSize
                : lineHeight);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int top = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);

            MarginLayoutParams lp = (MarginLayoutParams) childView
                    .getLayoutParams();
            int cl = 0 + lp.leftMargin;
            int ct = top + lp.topMargin;   //50
            int cr = childView.getMeasuredWidth() + cl;
            int cb = childView.getMeasuredHeight() + ct;
            childView.layout(cl, ct, cr, cb);

            top += childView.getMeasuredHeight() + lp.topMargin;
        }

    }


    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }


}
