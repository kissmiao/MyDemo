package com.hongliang.demo.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import android.widget.ViewAnimator;

import com.hongliang.demo.util.ScreenUtils;


public class SlideButton extends AppCompatButton {

    Scroller mscroller;
    private int mScreenWidth, mScreenHeight;//屏幕宽高

    private int left, right, top, bottom;

    public SlideButton(Context context) {
        super(context);
        initScroll(context);
    }

    public SlideButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScroll(context);
    }

    public SlideButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initScroll(context);
    }

    private void initScroll(Context context) {
        mscroller = new Scroller(context);
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mscroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mscroller.getCurrX(), mscroller.getCurrY());
            // scrollTo(mscroller.getCurrX(), mscroller.getCurrY());
            invalidate();
        }
    }

    /**
     * 第四步：对外调用接口，可以封装成接口
     *
     * @param destX：滑动Dest  X
     * @param destY：滑动Dest  Y
     * @param duration：滑动时间
     */
    public void scrollerMove(int destX, int destY, int duration) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int moveDistX = destX - scrollX;
        int moveDistY = destY - scrollY;
        mscroller.startScroll(scrollX, scrollY, moveDistX, moveDistY, duration);
        invalidate();
    }


    public void onScroll() {

    }


    int lastX = 0;
    int lastY = 0;

    int touchX = 0;
    int touchY = 0;


    int mLastX;
    int mLastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //解决 和父View ScrollView的滑动冲突
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltax = x - mLastX;
                int deltay = y - mLastY;

//                if (父View需要此点击事件) {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();

                touchX = (int) (event.getRawX() - getLeft());
                touchY = (int) (event.getRawY() - getTop());

                break;

            case MotionEvent.ACTION_MOVE:

                left = (int) (event.getRawX() - touchX);
                right = left + getWidth();
                top = (int) (event.getRawY() - touchY);
                bottom = top + getHeight();

                layout(left, top, right, bottom);
                Log.i("Log", "===");
                break;
            case MotionEvent.ACTION_UP:

                if (Math.abs(event.getRawX() - lastX) <
                        ScreenUtils.getPxFromDp(getResources(), 2) &&
                        Math.abs(event.getRawY() - lastY) <
                                ScreenUtils.getPxFromDp(getResources(), 2)) {
                    if (mClickListener != null) {
                        mClickListener.onClick(this);
                    }
                }
                onmove();


                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("Log", "=========");
                onmove();
                break;

        }
        return true;
    }


    private void onmove() {
        //当用户拖拽完后，让控件根据远近距离回到最近的边缘
        float end = 0;
        //true  在右边
        // false 左边
        ValueAnimator animator;
        if ((left + getWidth() / 2) >= mScreenWidth / 2) {
            int size = mScreenWidth - right;
            animator = ValueAnimator.ofFloat(end, size); // right a-最大
        } else {
            animator = ValueAnimator.ofFloat(end, -left);//left a-0
        }


        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int leftMargin = (int) ((float) animation.getAnimatedValue());

                layout(left + leftMargin, top, right + leftMargin, bottom);
            }
        });

        animator.setDuration(400);
        animator.start();
    }

    View.OnClickListener mClickListener;


    public void setOnClickListener(View.OnClickListener clickListener) {
        mClickListener = clickListener;

    }


}
