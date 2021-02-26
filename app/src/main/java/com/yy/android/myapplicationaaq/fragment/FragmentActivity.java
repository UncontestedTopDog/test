package com.yy.android.myapplicationaaq.fragment;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Interpolator;

import com.yy.android.myapplicationaaq.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity {

    private static final String TAG = "BlankFragmentActivity";

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
        setContentView(R.layout.activity_fragment);
        BlankFragment fragment = new BlankFragment(100);
        BlankFragment fragment2 = new BlankFragment(999);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment, "TEST")
                .commit();

        findViewById(R.id.hide).setOnClickListener(v -> {
            Log.i(TAG, "AAAa");
            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
            // Fragment fragment1 = getSupportFragmentManager().findFragmentByTag("TEST");
            if (fragment.isHidden()) {
                transaction2.show(fragment).commit();
            } else {
                transaction2.hide(fragment).commit();
            }
        });

        findViewById(R.id.show).setOnClickListener(v -> {
            Log.i(TAG, "BBBb");
            FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
            // Fragment fragment1 = getSupportFragmentManager().findFragmentByTag("TEST");
            // transaction3.show(fragment).commit();
            if (i % 2 != 0) {
                transaction3.replace(R.id.fragment_container, fragment).commit();
            } else {
                transaction3.replace(R.id.fragment_container, fragment2).commit();
            }
            i++;
        });

    }

    @Deprecated
    public void test() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        log("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        log("onRestoreInstanceState");
    }

    private void log(String msg) {
        Log.i(TAG, msg);
        Interpolator interpolator = new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return 0;
            }
        };

        TypeEvaluator evaluator = new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                return null;
            }
        };
        ValueAnimator valueAnimator = ValueAnimator.ofObject(evaluator,1,1,1);
    }
}