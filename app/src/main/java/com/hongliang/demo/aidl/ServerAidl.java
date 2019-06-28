package com.hongliang.demo.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

public class ServerAidl extends Service {

    NumberManage manage;

    @Override
    public void onCreate() {
        super.onCreate();
        manage = new NumberManage();
    }


    class NumberManage extends NumberManageImpl {


        @Override
        public int getNumber() throws RemoteException {
            return 10086;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return manage;
    }
}
