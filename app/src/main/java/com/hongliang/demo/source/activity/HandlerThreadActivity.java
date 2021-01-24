package com.hongliang.demo.source.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hongliang.demo.R;
import com.hongliang.demo.util.Platform;

import java.util.Date;

public class HandlerThreadActivity extends Activity {
    private HandlerThread myHandlerThread;
    private Handler handler;
    private EditText mInput;

    private Handler mainHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_thread);
        mInput = findViewById(R.id.input);
        findViewById(R.id.handler_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(1);
            }
        });


        onCreateHandle();

        mainHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                Toast.makeText(HandlerThreadActivity.this, "消息： " + msg.obj + "  线程： " + Thread.currentThread().getName(), Toast.LENGTH_LONG).show();
                mInput.setText("消息： " + msg.obj + "  线程： " + Thread.currentThread().getName());
            }
        };

        MyThread myThread = new MyThread();
        myThread.start();
    }


    //线程运行耗时任务，运行完了用handler通知

    /**
     * 创建一个HandlerThread，然后在loopThread 中每隔2秒发送一个消息，mainHandler接受消息，显示页面
     */
    private void onCreateHandle() {

        //创建一个线程,线程名字：handler-thread
        myHandlerThread = new HandlerThread("handler-thread");
        //开启一个线程
        myHandlerThread.start();

        //在这个线程中创建一个handler对象
        handler = new Handler(myHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //这个方法是运行在 handler-thread 线程中的 ，可以执行耗时操作
                Log.i("TAG ", "消息： " + msg.obj + "  线程： " + Thread.currentThread().getName());
                mainHandler.sendMessage(mainHandler.obtainMessage(msg.what, msg.obj));
                loopThread();
            }
        };

    }


    private void loopThread() {

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.sendMessage(handler.obtainMessage(1, new Date().getTime() + ""));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        //释放资源
        myHandlerThread.quit();
        mainHandler.removeCallbacksAndMessages(null);
    }


    class MyThread extends Thread {


        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(500);//等待500后会异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // todo handler 可以进行线程间切换，必须是new 一个Runnable 在Runnable的run方法之前切换
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new MyRunable("cccc"));
        }

    }


    private class MyRunable implements Runnable {
        String data;

        public MyRunable(String data) {
            this.data = data;
        }

        @Override
        public void run() {
            mInput.setText(data);
        }
    }

    private void change(String data) {

        Platform.get().execute(new Runnable() {
            @Override
            public void run() {
                mInput.setText(data);
            }
        });
    }


}
