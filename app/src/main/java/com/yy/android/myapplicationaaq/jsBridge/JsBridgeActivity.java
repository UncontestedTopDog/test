package com.yy.android.myapplicationaaq.jsBridge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import rx.Observer;

import android.os.Bundle;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityJsBridgeBinding;

public class JsBridgeActivity extends AppCompatActivity {

    ActivityJsBridgeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_js_bridge);
        RxBus.getDefault().register(Test.class).subscribe(new Observer<Test>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Test test) {
                Log.i("RxBusTest",test.toString());
            }
        });
        RxBus.getDefault().register(Test2.class).subscribe(new Observer<Test2>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Test2 test2) {
                Log.i("RxBusTest",test2.toString());
            }
        });
        binding.bt1.setOnClickListener(v->{
            RxBus.getDefault().post(new Test("A"));
        });
        binding.bt2.setOnClickListener(v->{
            RxBus.getDefault().post(new Test2("B"));
        });
    }
}