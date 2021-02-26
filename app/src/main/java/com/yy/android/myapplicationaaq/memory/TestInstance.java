package com.yy.android.myapplicationaaq.memory;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class TestInstance {

    private static volatile TestInstance instance;

    private Activity activity;

    private List<Activity> activities = new ArrayList<>();

    public static TestInstance getInstance() {
        if (instance == null) {
            synchronized (TestInstance.class) {
                if (instance == null) {
                    instance = new TestInstance();
                }
            }
        }
        return instance;
    }

    public void setActivity(Activity activity) {
        activities.add(activity);
    }
}
