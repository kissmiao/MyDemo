package com.hongliang.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * https://www.jianshu.com/p/5c2ec2420a0e
 * https://www.jianshu.com/p/27181e2e32d2
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LOG", this.getClass().getName() + "：onCreate");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i("LOG", this.getClass().getName() + "：onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LOG", this.getClass().getName() + "：onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("LOG", this.getClass().getName() + "：onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("LOG", this.getClass().getName() + "：onStop");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LOG", this.getClass().getName() + "：onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LOG", this.getClass().getName() + "：onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("LOG", this.getClass().getName() + "：onRestoreInstanceState");
    }


}
