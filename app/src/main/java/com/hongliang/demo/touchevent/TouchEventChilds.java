package com.hongliang.demo.touchevent;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Toast;

public class TouchEventChilds extends View {

    public TouchEventChilds(Context context) {
        this(context,null);
    }

    public TouchEventChilds(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TouchEventChilds(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TouchEventChilds(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * false  当前不关心此次事件，让事件由此向上传递
     * true，事件会分发给当前 View 并由 dispatchTouchEvent 方法进行消费，同时事件会停止向下传递；
     * super 事件会自动的分发给当前 View 的 onTouchEvent 方法。
     */
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("sunzn", "===C=== dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
	//	return false;
    }


    /**
     * 回了 false，那么这个事件会从当前 View 向上传递，并且都是由上层 View 的 onTouchEvent 来接收，如果传递到上面的 onTouchEvent 也返回 false，这个事件就会“消失”，而且接收不到下一次事件。
     * 如果返回了 true 则会接收并消费该事件。
     * 如果返回 super.onTouchEvent(ev) 默认处理事件的逻辑和返回 false 时相同。
     *
     * @param ev
     * @return
     */
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i("sunzn", "===C=== onTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
        Toast.makeText(getContext(),"ChildView onTouchEvent", Toast.LENGTH_SHORT).show();
        //   return super.onTouchEvent(ev);

        ViewConfiguration.get(getContext()).getScaledTouchSlop();


        VelocityTracker velocityTracker = VelocityTracker.obtain();
        //监听移动时间
        velocityTracker.addMovement(ev);
        //设置时间间隔为1秒
        velocityTracker.computeCurrentVelocity(1000);

        //速度=（终点位置-起点位置）/时间段,注意当从右往左滑动时速度会出现负数

        //横行的每秒滑动的速度
        int xVelocity = (int) velocityTracker.getXVelocity();
        //竖向每秒滑动的速度
        int yVelocity = (int) velocityTracker.getYVelocity();
    //    System.out.println("X每秒滑动的速度:" + xVelocity);
     //   System.out.println("Y每秒滑动的速度:" + yVelocity);

        //不需要的时候重置并且回收内存
        velocityTracker.clear();
        velocityTracker.recycle();

        return true;
    }

}
