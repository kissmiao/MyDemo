package com.hongliang.demo.source.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.hongliang.demo.R;
import com.hongliang.demo.source.touchevent.TouchEventUtil;


public class TouchEventActivity extends Activity {

    private Button button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_touchevent);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sunzn", "onClick****************");
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("sunzn", "onTouch------------");

                return false;
            }
        });

        findViewById(R.id.childs2).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("sunzn", "onTouch------------");
                return false;
            }
        });


    }


    /**
     * 当子View 都不拦截方法的时候，那么后续的move he up事件不会传递到子View
     */

    /**
     * 这个方法返回值与是否调用 onTouchEvent有间接关系.当Activity中dispatchTouchEvent()方法中getWindow().superDispatchTouchEvent(ev)返回false，
     * 即Activity的根视图以及根视图的子视图都没有拦截该事件的话，则调用Activity的onTouchEvent()
     **/
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("sunzn", "===Activity=== dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);

    }


    public boolean onTouchEvent(MotionEvent event) {
        Log.i("sunzn", "===Activity===  onTouchEvent --> " + TouchEventUtil.getTouchAction(event.getAction()));
        return super.onTouchEvent(event);
    }

}