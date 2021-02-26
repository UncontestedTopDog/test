package com.yy.android.myapplicationaaq.activityresult;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yy.android.myapplicationaaq.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SaveActivity extends AppCompatActivity {

    private static final String TAG = "SaveAvtivityTAG";
    TextView text;
    Button btn;

    int a;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"oncreate");
        setContentView(R.layout.activity_save);

        linearLayout = findViewById(R.id.linear);
        ViewGroup parent = (ViewGroup) linearLayout.getParent().getParent();

        parent.getChildAt(1).setVisibility(View.GONE);
        for (int i = 0; i < parent.getChildCount(); i++)
        Log.d(TAG,parent.getChildAt(i)+"  !");

        Log.i(TAG,"--------------------------");

        parent = (ViewGroup) parent.getParent();
        Log.d(TAG,parent+"  !");
        for (int i = 0; i < parent.getChildCount(); i++)
            Log.d(TAG,parent.getChildAt(i)+"  !");
        text = findViewById(R.id.test);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                text.setText(""+a);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("texta",a);
        Log.i(TAG,"onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
        if (savedInstanceState != null && savedInstanceState.getInt("texta") != 0) {
            text.setText(savedInstanceState.getInt("texta")+"");
        }
    }

    @Override
    public void onTrimMemory(int level) {
        Log.i(TAG, "onTrimMemory" + level);
        super.onTrimMemory(level);
    }
}