package com.yy.android.myapplicationaaq.memory;

import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityMemoryBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MemoryActivity extends AppCompatActivity {

    Test test1;
    Test test2;
    Test test3;
    Test test4;
    Test test5;
    Test test6;
    Test test7;
    Test test8;
    Test test9;
    Test test10;

    public static List<Test> tests = new ArrayList<>();

    ActivityMemoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_memory);
        binding.add.setOnClickListener(v -> {
            test1 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test2 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test3 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test4 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test5 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test6 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test7 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test8 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test9 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            test10 = new Test("AAAAAAAAAAAAAAAAAAA", "SSSSSSSSSSSSSSSSSSSSS",
                    "DDDDDDDDDDDDDDDDDDDDDD");
            tests.add(test1);
            tests.add(test2);
            tests.add(test3);
            tests.add(test4);
            tests.add(test5);
            tests.add(test6);
            tests.add(test7);
            tests.add(test8);
            tests.add(test9);
            tests.add(test10);

        });

        binding.delete.setOnClickListener(v -> {
            test1 = null;
            test2 = null;
            test3 = null;
            test4 = null;
            test5 = null;
            test6 = null;
            test7 = null;
            test8 = null;
            test9 = null;
            test10 = null;
            System.out.println("Performance:" + tests.get(2).toString());
        });

        binding.finish.setOnClickListener(v -> {
            tests.clear();
            tests = null;
        });

    }
}