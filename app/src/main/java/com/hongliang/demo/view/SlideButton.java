package com.hongliang.demo.view;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.Scroller;


public class SlideButton extends AppCompatButton {

    Scroller mscroller;

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
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mscroller.computeScrollOffset()) {
            //    ((View) getParent()).scrollTo(mscroller.getCurrX(), mscroller.getCurrY());
            scrollTo(mscroller.getCurrX(), mscroller.getCurrY());
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
        int moveDistY = destX - scrollY;
        mscroller.startScroll(scrollX, scrollY, moveDistX, moveDistY, duration);
        invalidate();
    }


    public void onScroll() {

    }


    int lastX = 0;
    int lastY = 0;

  /*  @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;
                break;

            case MotionEvent.ACTION_MOVE:

                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                lastX = rawX;
                lastY = rawY;

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }*/


   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.i("LOG", "x:" + x + " y" + y);


        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        Log.i("LOG", "rawX:" + rawX + " rawY" + rawY);
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;

            case MotionEvent.ACTION_MOVE:

                int offsetX = x - lastX;
                int offsetY = y - lastY;
                Log.i("LOG", "offsetX:" + offsetX + " offsetY" + offsetY);
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }*/
}
