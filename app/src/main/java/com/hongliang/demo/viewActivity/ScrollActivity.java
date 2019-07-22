package com.hongliang.demo.viewActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.hongliang.demo.R;
import com.hongliang.demo.view.MView3;

public class ScrollActivity extends Activity implements View.OnClickListener {

    /**
     * 滑动
     */
    private Button mBtScroll;
    private MView3 mMyview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        initView();

    }


    private void initView() {
        mBtScroll = (Button) findViewById(R.id.bt_scroll);
        mBtScroll.setOnClickListener(this);


        mMyview = (MView3) findViewById(R.id.myview);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_scroll:
                mMyview.smoothScrollTo(0, -800);

                break;
        }
    }
}
