package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hongliang.demo.R;

public class RefreshViewActivity extends Activity implements View.OnClickListener {


    /**
     * Handler
     */
    private Button mBtHandler;
    /**
     * postView
     */
    private Button mBtPostView;
    /**
     * AsyncTask
     */
    private Button mBtAsyncTask;
    /**
     * runOnUiThread
     */
    private Button mBtRunOnUiThread;

    private EditText mEtData;
    private Handler handler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();


        //造成Handler内存泄漏两个原因
        //1、Handler内部类的创建方式导致隐式持有外部Activity的引用，当Handler所伴随的线程无法及时发送消息，但此时又关闭了Activity
        //那么线程将持有handler,handler由持有Activity，导致内存无法回收造成泄漏
        //2、当使用postDelayed延迟发送消息，导致Message占用MessageQueue、message、handler,activity一条消息链，导致Activity无法回收
        //避免内存泄漏 使用静态内部类 或弱引用 Activity销毁的时候回收Message

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        mEtData.setText("handler");
                        break;

                }
            }
        };


    }

    private void initView() {
        mBtHandler = (Button) findViewById(R.id.bt_handler);
        mBtHandler.setOnClickListener(this);
        mBtPostView = (Button) findViewById(R.id.bt_postView);
        mBtPostView.setOnClickListener(this);
        mBtAsyncTask = (Button) findViewById(R.id.bt_asyncTask);
        mBtAsyncTask.setOnClickListener(this);
        mBtRunOnUiThread = (Button) findViewById(R.id.bt_runOnUiThread);
        mBtRunOnUiThread.setOnClickListener(this);
        mEtData = findViewById(R.id.et_data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_handler:
                onHandler();
                break;
            case R.id.bt_postView:
                onPostView();
                break;
            case R.id.bt_asyncTask:
                break;
            case R.id.bt_runOnUiThread:
                onRunOnUiThread();
                break;
        }
    }


    private void onRunOnUiThread() {

        //执行完run()方法Thread就进入到死亡状态，当run()方法存在柱塞的时候，要注意回收线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEtData.setText("runOnUiThread");
                    }
                });


            }
        });
        thread.start();

    }


    private void onPostView() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                mEtData.post(new Runnable() {
                    @Override
                    public void run() {
                        mEtData.setText("onPostView");
                    }
                });

            }
        });
        thread.start();
    }


    private void onHandler() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                message.what = 1;
                handler.sendMessage(message);
            }
        });
        thread.start();

    }


//https://blog.csdn.net/annkie/article/details/8496564
    private void onSync(){

        AsyncTask asyncTask =new AsyncTask() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Object doInBackground(Object[] objects) {
                return null;
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                super.onProgressUpdate(values);


            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }
        };



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);

    }
}
