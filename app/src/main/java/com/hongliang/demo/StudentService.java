package com.hongliang.demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

public class StudentService extends Service {

    private String[] studentNo = {"张三", "李四", "王五"};
    private IBinder binder;

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new StudentQueryBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
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

}
