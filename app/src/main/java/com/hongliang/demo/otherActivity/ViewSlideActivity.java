package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hongliang.demo.R;
import com.hongliang.demo.view.MyTabLayout;
import com.hongliang.demo.view.SlideButton;

import java.util.ArrayList;
import java.util.List;

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


    private MyTabLayout myTabLayout;

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
               // mBtSlide.scrollerMove(-400, -200, 5000);
            }
        });

        myTabLayout = findViewById(R.id.my_tab);
        List<String> list = new ArrayList<>();
        list.add("银行卡");
        list.add("支付宝");
        list.add("微信");
        myTabLayout.setData(list,1);
        myTabLayout.setOnChangeListener(new MyTabLayout.OnChangeListener() {
            @Override
            public void onChange(int position) {
                Toast.makeText(ViewSlideActivity.this, "position  " + position, Toast.LENGTH_SHORT).show();
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
