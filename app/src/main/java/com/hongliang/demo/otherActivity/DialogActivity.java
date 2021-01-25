package com.hongliang.demo.otherActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.hongliang.demo.BaseActivity;
import com.hongliang.demo.R;
import com.hongliang.demo.util.dialog.FragmentDialog;
import com.hongliang.demo.util.dialog.MyDialog;
import com.hongliang.demo.util.dialog.MyDialog2;


/**
 * Created by whl on 2017/3/19.
 */
public class DialogActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.bt_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog dialog = new MyDialog(DialogActivity.this);
                dialog.show();

            }
        });
        findViewById(R.id.bt_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog2 dialog = new MyDialog2(DialogActivity.this);
                dialog.show();

            }
        });

        //https://blog.csdn.net/zh_nan811/article/details/83015076
        findViewById(R.id.bt_dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                BaseFragmentDialog dialog = new BaseFragmentDialog();
//                dialog.show(getSupportFragmentManager(), "BaseFragmentDialog");

                FragmentDialog dialog = new FragmentDialog();
                dialog.show(getSupportFragmentManager(), "BaseFragmentDialog");
            }
        });


    }
}
