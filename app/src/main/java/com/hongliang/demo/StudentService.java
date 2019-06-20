package com.hongliang.demo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class StudentService extends Service {

    private String[] studentNo = {"张三", "李四", "王五"};
    private IBinder binder;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("LOG", "-------StudentService---onCreate--");
        binder = new StudentQueryBinder();
    }


    @Override
    public void unbindService(ServiceConnection conn) {
        Log.e("LOG", "-------StudentService---unbindService--");
        super.unbindService(conn);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("LOG", "-------StudentService---onBind--");
        return binder;
    }




    @Override
    public void onRebind(Intent intent) {
        Log.e("LOG", "-------StudentService---onRebind--");
        super.onRebind(intent);
    }


    class StudentQueryBinder extends StudentAidl.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getStudent(int no) throws RemoteException {
            int l = studentNo.length;
            if (l < 0) {
                no = 0;
            }
            if (no >= l) {
                no = l - 1;
            }
            return studentNo[no];
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("LOG", "-------StudentService---onStartCommand--");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("LOG", "-------StudentService---onUnbind--");
        return super.onUnbind(intent);
    }

    @Override
    public boolean stopService(Intent name) {
        Log.e("LOG", "-------StudentService---stopService--");
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        Log.e("LOG", "-------StudentService---onDestroy--");
        super.onDestroy();
    }
}
