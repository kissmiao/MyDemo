package com.hongliang.demo.viewActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hongliang.demo.R;

public class AttributeSetActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("Activity onCreate");
        setContentView(R.layout.activity_view_attributset);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        log("Activity onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("Activity onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        log("Activity onResume");
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        log("Activity onPostResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        log("Activity onStop");
    }


    @Override
    protected void onPause() {
        super.onPause();
        log("Activity onPause");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        log("Activity onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        log("Activity onSaveInstanceState");
    }

    private void log(String msg) {
        Log.i("TAG", msg);
    }
}
