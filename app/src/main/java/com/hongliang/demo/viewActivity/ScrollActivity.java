package com.hongliang.demo.viewActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;

import com.hongliang.demo.R;

public class ScrollActivity extends Activity implements View.OnClickListener {

    /**
     * 滑动
     */
    private Button mBtScroll;

    Scroller scroller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        initView();

    }


    private void initView() {
        mBtScroll = (Button) findViewById(R.id.bt_scroll);
        mBtScroll.setOnClickListener(this);

        scroller = new Scroller(this);
    }


    public void smoothScrollTo(int desX, int desY) {
        int scrollX = mBtScroll.getScrollX();
        int deltaX = desX - scrollX;

        int scrollY = mBtScroll.getScrollY();
        int deltaY = desY - scrollY;

        scroller.startScroll(scrollX, scrollY, deltaX, deltaY, 5000);

        mBtScroll.invalidate();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_scroll:
                smoothScrollTo(500, 500);
                break;
        }
    }
}
