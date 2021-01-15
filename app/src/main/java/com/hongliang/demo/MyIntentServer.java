package com.hongliang.demo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 使用Message 让service和activity通信
 */
public class MyIntentServer extends Service {
    Messenger mMessenger;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("LOG", "onCreate thread id = " + Thread.currentThread().getId() + ",thread name = " + Thread.currentThread().getName());

        Log.i("LOG", "===onCreate=====");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMessenger = (Messenger) intent.getExtras().get("messages");
        Message message = Message.obtain();
        message.arg1 = 1;
        message.obj = "成功";
        try {
            mMessenger.send(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        Log.i("LOG", "===onDestroy============================");
        super.onDestroy();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("LOG", "===onRebind=====");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("LOG", "===onUnbind=====");
        return super.onUnbind(intent);
    }


}
