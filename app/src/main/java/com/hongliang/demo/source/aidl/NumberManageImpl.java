package com.hongliang.demo.source.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class NumberManageImpl extends Binder implements INumberManage {


    public NumberManageImpl() {
        this.attachInterface(this, DESCRIPTOR);
    }


    public static INumberManage adInterface(IBinder obj) {
        if ((obj == null)) {
            return null;
        }

        android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if (((iin != null) && (iin instanceof INumberManage))) {
            return ((INumberManage) iin);
        }
        return new NumberManageImpl.Proxy(obj);

    }


    @Override
    public IBinder asBinder() {
        return this;
    }


    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {


        switch (code) {
            case INTERFACE_TRANSACTION: {
                return true;
            }
            case TRANSACTION_GETNUMBER: {
                data.enforceInterface(DESCRIPTOR);
                int result = this.getNumber();
                reply.writeNoException();
                reply.writeInt(result);

                return true;

            }

        }

        return super.onTransact(code, data, reply, flags);


    }




    private static class Proxy implements INumberManage {

        private IBinder mRemote;

        Proxy(IBinder remote) {
            mRemote = remote;
        }

        @Override
        public int getNumber() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            int result;
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TRANSACTION_GETNUMBER, data, reply, 0);
                reply.readException();
                result = reply.readInt();

            } finally {
                reply.recycle();
                data.recycle();
            }

            return result;
        }

        @Override
        public IBinder asBinder() {
            return mRemote;
        }


        public String getInterfaceDescriptor() {
            return DESCRIPTOR;
        }


    }
}
