package com.hongliang.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
