package com.hongliang.demo.otherActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.hongliang.demo.BaseActivity;
import com.hongliang.demo.R;
import com.hongliang.demo.otherActivity.anim.AlphaFragment;
import com.hongliang.demo.otherActivity.anim.RotateFragment;
import com.hongliang.demo.otherActivity.anim.ScaleFragment;
import com.hongliang.demo.otherActivity.anim.SetFragment;
import com.hongliang.demo.otherActivity.anim.TransLateFragment;

public class AnimActivity extends BaseActivity implements View.OnClickListener {

    FrameLayout f_layout;
    FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        findViewById(R.id.bt_alpha).setOnClickListener(this);
        findViewById(R.id.bt_rotate).setOnClickListener(this);
        findViewById(R.id.bt_scale).setOnClickListener(this);
        findViewById(R.id.bt_translate).setOnClickListener(this);
        findViewById(R.id.bt_set).setOnClickListener(this);
        f_layout = findViewById(R.id.f_layout);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_alpha:
                AlphaFragment alphaFragment = new AlphaFragment();
                replaceFragment(alphaFragment);
                break;
            case R.id.bt_rotate:
                RotateFragment rotateFragment = new RotateFragment();
                replaceFragment(rotateFragment);
                break;
            case R.id.bt_scale:
                ScaleFragment scaleFragment = new ScaleFragment();
                replaceFragment(scaleFragment);
                break;
            case R.id.bt_translate:
                TransLateFragment transLateFragment = new TransLateFragment();
                replaceFragment(transLateFragment);
                break;
            case R.id.bt_set:
                SetFragment setFragment = new SetFragment();
                replaceFragment(setFragment);
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   // 开启一个事务
        transaction.replace(R.id.f_layout, fragment);
        transaction.commit();
    }


}
