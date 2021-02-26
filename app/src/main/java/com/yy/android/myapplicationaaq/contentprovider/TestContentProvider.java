package com.yy.android.myapplicationaaq.contentprovider;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

public class TestContentProvider extends ContentProvider implements Application.ActivityLifecycleCallbacks {

    @Override
    public boolean onCreate() {
        Log.i("AAAAAAAAAAAAAV",Thread.currentThread().getName());
        Context appCtx =  getContext().getApplicationContext();

        if(appCtx instanceof Application)
        {
            Application app = (Application) appCtx;
            app.registerActivityLifecycleCallbacks(this);
        }
        else{
            throw new RuntimeException("no application instance!");
        }

        return false;
    }

    @Override
    public Cursor query( Uri uri, String[] strings, String s, String[] strings1,  String s1) {
        return null;
    }


    @Override
    public String getType(  Uri uri) {
        return null;
    }


    @Override
    public Uri insert(  Uri uri,  ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(  Uri uri,  String s,  String[] strings) {
        return 0;
    }

    @Override
    public int update(  Uri uri,  ContentValues contentValues,  String s,  String[] strings) {
        return 0;
    }



    @Override
    public void onActivityCreated(  Activity activity,  Bundle bundle) {
        Log.d("HAHAHAH","onActivityCreated " + activity);
    }

    @Override
    public void onActivityStarted(  Activity activity) {
        Log.d("HAHAHAH","onActivityStarted " + activity);
        LifecycleEventDispatcher.dispatchEvent(true);
    }

    @Override
    public void onActivityResumed(  Activity activity) {
        Log.d("HAHAHAH","onActivityResumed " + activity);
    }

    @Override
    public void onActivityPaused(  Activity activity) {
        Log.d("HAHAHAH","onActivityPaused " + activity);
    }

    @Override
    public void onActivityStopped(  Activity activity) {
        Log.d("HAHAHAH","onActivityStopped " + activity);
        LifecycleEventDispatcher.dispatchEvent(false);
    }

    @Override
    public void onActivitySaveInstanceState(  Activity activity,   Bundle bundle) {
        Log.d("HAHAHAH","onActivitySaveInstanceState " + activity);
    }

    @Override
    public void onActivityDestroyed(  Activity activity) {
        Log.d("HAHAHAH","onActivityDestroyed " + activity);
    }
}
