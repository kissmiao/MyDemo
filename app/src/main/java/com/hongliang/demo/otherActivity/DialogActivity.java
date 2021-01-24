package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.hongliang.demo.R;
import com.hongliang.demo.util.MyDialog;
import com.hongliang.demo.util.MyDialog2;


/**
 * Created by whl on 2017/3/19.
 */
public class DialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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


    }
}
