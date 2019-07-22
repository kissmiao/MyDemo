package com.hongliang.demo.viewActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hongliang.demo.R;
import com.hongliang.demo.view.MView3;

public class ScrollActivity extends Activity implements View.OnClickListener {

    /**
     * 滑动
     */
    private Button mBtScroll;
    private MView3 mMyview;
    /**
     * 滑动to
     */
    private Button mBtScrollTo;
    /**
     * 滑动by
     */
    private Button mBtScrollBy;


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
        mBtScrollTo = (Button) findViewById(R.id.bt_scroll_to);
        mBtScrollTo.setOnClickListener(this);

        mBtScrollBy = (Button) findViewById(R.id.bt_scroll_by);
        mBtScrollBy.setOnClickListener(this);
        mMyview.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_scroll:
                mMyview.smoothScrollTo(0, -800);
                break;
            case R.id.bt_scroll_to:
                mBtScrollTo.scrollTo(50, 0);
                break;
            case R.id.bt_scroll_by:
                mBtScrollBy.scrollBy(50, 0);
                break;
            case R.id.myview:
                Toast.makeText(this, "点击", Toast.LENGTH_LONG).show();
                break;


        }
    }
}
