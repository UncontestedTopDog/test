package com.yy.android.myapplicationaaq.aidl;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IActivityManager extends IInterface {
    String DESCRIPTOR = "android.app.IActivityManager";
    int TRANSACTION_startActivity = IBinder.FIRST_CALL_TRANSACTION + 0;
    int startActivity(Intent intent) throws RemoteException;
}
