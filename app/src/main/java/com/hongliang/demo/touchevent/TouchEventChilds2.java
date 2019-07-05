package com.hongliang.demo.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchEventChilds2 extends View {
    public TouchEventChilds2(Context context) {
        super(context);
    }

    public TouchEventChilds2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * false  当前不关心此次事件，让事件由此向上传递
     * true，事件会分发给当前 View 并由 dispatchTouchEvent 方法进行消费，同时事件会停止向下传递；
     * super 事件会自动的分发给当前 View 的 onTouchEvent 方法。
     */
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("sunzn", "===C2222=== dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
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


        Log.i("sunzn", "===C2222=== onTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.onTouchEvent(ev);
    }


}
