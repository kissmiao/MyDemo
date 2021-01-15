package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.hongliang.demo.MyIntentServer;
import com.hongliang.demo.R;


/**
 * Created by Administrator on 2016/6/23.
 */
public class MessengerActivity extends Activity {

    Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(MessengerActivity.this, "====" + msg.obj, Toast.LENGTH_LONG).show();
            return false;
        }

    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_scrollor);


        Intent intent = new Intent(this, MyIntentServer.class);
        intent.putExtra("messages", new android.os.Messenger(handler));
        startService(intent);

    }


}
