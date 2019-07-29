package com.hongliang.demo.viewActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hongliang.demo.R;
import com.hongliang.demo.view.DragView;
import com.hongliang.demo.view.FllowerAnimation;


/**
 * Created by wanghongliang on 16/3/23.
 */
public class DrawCircleActivity extends Activity {
    private ImageView iv_zan;
    private FllowerAnimation view_xin;
    private RelativeLayout ll_dianzan;
    private TextView tv_loadimage_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadimage_layout);
        tv_loadimage_text = (TextView) findViewById(R.id.tv_loadimage_text);

      //  view_xin = new FllowerAnimation(this);

        iv_zan = (ImageView) findViewById(R.id.iv_zan);
        ll_dianzan = (RelativeLayout) findViewById(R.id.rl_dianzan);



      /*  ViewTreeObserver vto2 = iv_zan.getViewTreeObserver();
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
*/


        iv_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = iv_zan.getHeight() / 2;
                int width = iv_zan.getWidth() / 2;
                int left = (int) iv_zan.getX() + width;
                int top = (int) iv_zan.getY() + height;
                view_xin = new FllowerAnimation(DrawCircleActivity.this, left, top);
                ll_dianzan.addView(view_xin);
                view_xin.startAnimation();
            }
        });

    }


}
