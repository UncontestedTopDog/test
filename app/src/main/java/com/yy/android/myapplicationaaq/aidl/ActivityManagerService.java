package com.yy.android.myapplicationaaq.aidl;

import android.content.Intent;
import android.os.RemoteException;

public class ActivityManagerService extends ActivityManagerNative{
    @Override
    public int startActivity(Intent intent) throws RemoteException {
        return 0;
    }
}
