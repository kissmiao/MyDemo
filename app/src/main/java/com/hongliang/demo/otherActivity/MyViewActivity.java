package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.Bundle;

import com.hongliang.demo.R;
import com.hongliang.demo.view.MyView;


/**
 * Created by whl on 16/6/30.
 */
public class MyViewActivity extends Activity {


private MyView mview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_myview);
        mview= (MyView) findViewById(R.id.myview);
        mview.startAnim();

    }


}
