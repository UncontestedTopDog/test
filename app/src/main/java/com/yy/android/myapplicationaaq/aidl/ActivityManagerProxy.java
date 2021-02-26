package com.yy.android.myapplicationaaq.aidl;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class ActivityManagerProxy implements IActivityManager {
    private IBinder mRemote;
    public ActivityManagerProxy(IBinder remote) {
        mRemote = remote;
    }

    @Override
    public int startActivity(Intent intent) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel replay = Parcel.obtain();
        int result;
        try {
            intent.writeToParcel(data,0);
            mRemote.transact(IActivityManager.TRANSACTION_startActivity,data,replay,0);
            replay.readException();
            result = replay.readInt();
        }finally {
            data.recycle();
            replay.recycle();
        }
        return result;
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }
}
