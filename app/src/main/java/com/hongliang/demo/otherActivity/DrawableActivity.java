package com.hongliang.demo.otherActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hongliang.demo.R;
import com.hongliang.demo.otherActivity.draeable.BitmapDrawable;
import com.hongliang.demo.otherActivity.draeable.ClipDrawableFragment;
import com.hongliang.demo.otherActivity.draeable.InsetDrawableFragment;
import com.hongliang.demo.otherActivity.draeable.LayerDrawable;
import com.hongliang.demo.otherActivity.draeable.LevelDrawable;
import com.hongliang.demo.otherActivity.draeable.ScaleDrawableFragment;
import com.hongliang.demo.otherActivity.draeable.ShapeDrawable;
import com.hongliang.demo.otherActivity.draeable.TransitionDrawableFragment;


/**
 * Created by Administrator on 2016/8/29.
 */
public class DrawableActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_drawable);
        findViewById(R.id.bt_bitmap).setOnClickListener(this);
        findViewById(R.id.bt_shape).setOnClickListener(this);
        findViewById(R.id.bt_layer).setOnClickListener(this);
        findViewById(R.id.bt_level).setOnClickListener(this);
        findViewById(R.id.bt_transition).setOnClickListener(this);
        findViewById(R.id.bt_inset).setOnClickListener(this);
        findViewById(R.id.bt_scan).setOnClickListener(this);
        findViewById(R.id.bt_clip).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_bitmap:
                BitmapDrawable bitmapDrawable = new BitmapDrawable();
                replaceFragment(bitmapDrawable);
                break;
            case R.id.bt_shape:
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                replaceFragment(shapeDrawable);
                break;
            case R.id.bt_layer:
                LayerDrawable layerDrawable = new LayerDrawable();
                replaceFragment(layerDrawable);
                break;
            case R.id.bt_level:
                LevelDrawable levelDrawable = new LevelDrawable();
                replaceFragment(levelDrawable);
                break;
            case R.id.bt_transition:
                TransitionDrawableFragment transitionDrawableFragment = new TransitionDrawableFragment();
                replaceFragment(transitionDrawableFragment);
                break;
            case R.id.bt_inset:
                InsetDrawableFragment insetDrawableFragment = new InsetDrawableFragment();
                replaceFragment(insetDrawableFragment);
                break;
            case R.id.bt_scan:
                ScaleDrawableFragment scaleDrawableFragment = new ScaleDrawableFragment();
                replaceFragment(scaleDrawableFragment);
                break;
            case R.id.bt_clip:
                ClipDrawableFragment clipDrawableFragment = new ClipDrawableFragment();
                replaceFragment(clipDrawableFragment);
                break;
        }
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   // 开启一个事务
        transaction.replace(R.id.fl_drawable, fragment);
        transaction.commit();
    }


}
