package com.yy.android.myapplicationaaq.arouter;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.android.myapplicationaaq.App;

public class MyNavigationCallbackImpl implements NavigationCallback {
    @Override
    public void onFound(Postcard postcard) {

    }

    @Override
    public void onLost(Postcard postcard) {

    }

    @Override
    public void onArrival(Postcard postcard) {

    }

    @Override
    public void onInterrupt(Postcard postcard) {
        String path = postcard.getPath();
        Log.i("AAAA","onInterrupt  "+path);
        App.login = true;
        Bundle bundle = postcard.getExtras();
        ARouter.getInstance().build("/test/two")
                .with(bundle)
                .withString("/test/activity",path)
                .navigation();
    }
}
