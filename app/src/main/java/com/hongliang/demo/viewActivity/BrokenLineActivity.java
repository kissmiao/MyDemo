package com.hongliang.demo.viewActivity;

import android.app.Activity;
import android.os.Bundle;

import com.hongliang.demo.view.BrokenLineView;


/**
 * Created by Administrator on 2016/11/9.
 */
public class BrokenLineActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new BrokenLineView(BrokenLineActivity.this));
    }
}
