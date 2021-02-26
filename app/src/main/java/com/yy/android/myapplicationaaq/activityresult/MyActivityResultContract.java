package com.yy.android.myapplicationaaq.activityresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyActivityResultContract extends ActivityResultContract<String,String> {
    Class<?> cls;

    public MyActivityResultContract(Class<?> cls) {
        this.cls = cls;
    }

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String input) {
        Intent intent = new Intent(context,this.cls);
        intent.putExtra("name",input);
        return intent;
    }

    @Override
    public String parseResult(int resultCode, @Nullable Intent intent) {
        String data = intent.getStringExtra("result");
        if (resultCode == Activity.RESULT_OK && data != null) {
            return data;
        }
        return null;
    }
}
