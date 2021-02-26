package com.yy.android.myapplicationaaq.viewmodel;

import android.os.Bundle;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityViewModelBinding;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelActivity extends AppCompatActivity {

    private static final String TAG = "ViewModelActivityLog: ";
    UserViewModel user;

    ActivityViewModelBinding binding;

    OneFragment oneFragment;
    TwoFragment twoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model);
        user = new ViewModelProvider(this, new UserViewModelFactory()).get(UserViewModel.class);
        Log.i(TAG, "ViewModel" + user);
        user.getSet().observe(this, new Observer<List<RemoteUserData>>() {
            @Override
            public void onChanged(List<RemoteUserData> remoteUserDatas) {
                for (RemoteUserData remoteUserData1 : remoteUserDatas) {
                    Log.i("AAAAAAAAA   ", remoteUserData1.toString());
                }
            }
        });
        binding.test.setOnClickListener(v -> {
            user.test();
        });

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.one_fragment, oneFragment, "TEST").add(R.id.two_fragment, twoFragment,
                "TEST222").commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}