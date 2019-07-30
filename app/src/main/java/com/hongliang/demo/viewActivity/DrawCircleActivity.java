package com.hongliang.demo.viewActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hongliang.demo.FloatingService;
import com.hongliang.demo.R;
import com.hongliang.demo.view.StarsView;


/**
 * Created by wanghongliang on 16/3/23.
 */
public class DrawCircleActivity extends Activity {
    private ImageView iv_zan;
    private StarsView view_xin;
    private RelativeLayout ll_dianzan;
    private TextView tv_loadimage_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadimage_layout);
        tv_loadimage_text = (TextView) findViewById(R.id.tv_loadimage_text);

        try {
            //强制打开GPU渲染
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        } catch (Exception e) {
            throw new RuntimeException("cmo:HARDWARE_ACCELERATED not support!");
        }


        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivity(intent);
                return;
            }
        }

        setFloatVisibility(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setFloatVisibility(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setFloatVisibility(true);
    }


    public void setFloatVisibility(boolean isVisibility) {
        Intent intent = new Intent(this, FloatingService.class);
        if (isVisibility) {
            intent.putExtra(FloatingService.ACTION, FloatingService.SHOW);
        } else {
            intent.putExtra(FloatingService.ACTION, FloatingService.HIDE);
        }
        startService(intent);
    }






/*
    //  view_xin = new FllowerAnimation(this);

    iv_zan = (ImageView) findViewById(R.id.iv_zan);
    ll_dianzan = (RelativeLayout) findViewById(R.id.rl_dianzan);


    final View view = LayoutInflater.from(this).inflate(R.layout.activity_glide, null);


    final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_PHONE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT);
    //初始化位置
    params.x = 10;
    params.y = 100;
    //获取WindowManager对象
    mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(view, params);




      *//*  ViewTreeObserver vto2 = iv_zan.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.i("LOG","====vto2=");
                iv_zan.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int height = iv_zan.getHeight() / 2;
                int width = iv_zan.getWidth() / 2;
                int left = (int) iv_zan.getX() + width;
                int top = (int) iv_zan.getY() + height;
                view_xin.setStartX(left, top);
                view_xin.init(DrawCircleActivity.this);
                view_xin.requestLayout();
            }
        });
*//*


     *//*  iv_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = iv_zan.getHeight() / 2;
                int width = iv_zan.getWidth() / 2;
                int left = (int) iv_zan.getX() + width;
                int top = (int) iv_zan.getY() + height;
                view_xin = new StarsView(DrawCircleActivity.this, left, top);
                ll_dianzan.addView(view_xin);

                //     params.x = left;
                //     params.y = top;
                //     WindowManager mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                //     mWindowManager.addView(view_xin, params);
                view_xin.startAnimation();

            }
        });*//*

    mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        iv_zan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int height = iv_zan.getHeight() / 2;
            int width = iv_zan.getWidth() / 2;
            int left = (int) iv_zan.getX() + width;
            int top = (int) iv_zan.getY() + height;
            //     view_xin = new StarsView(DrawCircleActivity.this, left, top);
            params.x = left;
            params.y = top;

            mWindowManager.addView(view, params);


        }
    });

        view.findViewById(R.id.iv_glide).setOnTouchListener(new View.OnTouchListener() {

        //获取X坐标
        private int startX;
        //获取Y坐标
        private int startY;
        //初始化X的touch坐标
        private float startTouchX;
        //初始化Y的touch坐标
        private float startTouchY;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = params.x;
                    startY = params.y;
                    startTouchX = event.getRawX();
                    startTouchY = event.getRawY();
                    return true;
                case MotionEvent.ACTION_MOVE:
                    params.x = startX + (int) (event.getRawX() - startTouchX);
                    params.y = startY + (int) (event.getRawY() - startTouchY);
                    //更新View的位置
                    mWindowManager.updateViewLayout(view, params);
                    return true;
            }

            return false;
        }
    });*/


}
