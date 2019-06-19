package com.hongliang.demo.touchevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.hongliang.demo.R;


public class TouchEventActivity extends Activity {

    private Button button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_touchevent);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sunzn", "****************");
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("sunzn", "------------");

                return true;
            }
        });


    }

    /**
     * 这个方法返回值与是否调用 onTouchEvent有间接关系.当Activity中dispatchTouchEvent()方法中getWindow().superDispatchTouchEvent(ev)返回false，
     * 即Activity的根视图以及根视图的子视图都没有拦截该事件的话，则调用Activity的onTouchEvent()
     **/
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("sunzn", "===A=== dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);

    }


    public boolean onTouchEvent(MotionEvent event) {
        Log.i("sunzn", "===A===  onTouchEvent --> " + TouchEventUtil.getTouchAction(event.getAction()));
        return false;
    }

}