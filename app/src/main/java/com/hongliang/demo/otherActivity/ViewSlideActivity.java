package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hongliang.demo.R;
import com.hongliang.demo.view.SlideButton;

public class ViewSlideActivity extends Activity implements View.OnClickListener {

    /**
     * Popw
     */
    private Button mBtPopw;
    /**
     * 滑动Button
     */
    private SlideButton mBtSlide;
    private LinearLayout mLlPopw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popw);
        initView();

    }

    private void initView() {
        mBtPopw = (Button) findViewById(R.id.bt_popw);
        mBtPopw.setOnClickListener(this);
        mBtSlide = (SlideButton) findViewById(R.id.bt_slide);
        mLlPopw = (LinearLayout) findViewById(R.id.ll_popw);

        mBtSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtSlide.scrollerMove(-400, -400,5000);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_popw:

                break;
        }
    }
}
