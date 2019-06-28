package com.hongliang.demo.aidl;

import android.os.IInterface;
import android.os.RemoteException;

public interface INumberManage extends IInterface {
    static final java.lang.String DESCRIPTOR = "com.hongliang.demo.aidl.INumberManage";
    static final int TRANSACTION_GETNUMBER = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);

    public int getNumber() throws RemoteException;
}
