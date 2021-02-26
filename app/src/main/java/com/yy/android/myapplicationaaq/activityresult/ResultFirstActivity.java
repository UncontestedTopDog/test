package com.yy.android.myapplicationaaq.activityresult;

import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityResultFirstBinding;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class ResultFirstActivity extends AppCompatActivity {

    ActivityResultFirstBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_first);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result_first);

        ActivityResultLauncher<Void> launcher =
                registerForActivityResult(new ActivityResultContracts.TakePicturePreview(),
                        result -> {
                            binding.image.setImageBitmap(result);
                        });

        binding.test.setOnClickListener(v -> {
            launcher.launch(null);
        });
    }
}