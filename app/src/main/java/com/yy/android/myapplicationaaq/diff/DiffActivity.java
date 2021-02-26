package com.yy.android.myapplicationaaq.diff;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.yy.android.myapplicationaaq.R;

import java.util.ArrayList;
import java.util.List;

public class DiffActivity extends AppCompatActivity {

    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff);
        test = findViewById(R.id.test);

        test.setOnClickListener(v->{

            List<Data> oldList = new ArrayList<>();
            List<Data> newList = new ArrayList<>();
            for (int i = 0 ; i < 200;i++) {
                oldList.add(new Data("A"+i, 1, i));
                if (i % 10 == 0) {
                    newList.add(new Data("ABV"+i, 1, i));
                } else {
                    newList.add(new Data("A"+i, 1, i));
                }
            }
            //
            // oldList.add(new Data("A", 1, 1));
            // oldList.add(new Data("B", 1, 2));
            // oldList.add(new Data("C", 1, 3));
            // oldList.add(new Data("D", 1, 4));
            // oldList.add(new Data("E", 1, 5));
            // oldList.add(new Data("F", 1, 6));
            // oldList.add(new Data("G", 1, 7));
            // oldList.add(new Data("H", 1, 8));
            // oldList.add(new Data("I", 1, 9));
            //
            // newList.add(new Data("B", 2, 2));
            // newList.add(new Data("C", 2, 3));
            // newList.add(new Data("D", 2, 4));
            // newList.add(new Data("A", 2, 1));
            // newList.add(new Data("ZZZZZ", 1, 5));
            // newList.add(new Data("F", 1, 6));
            // newList.add(new Data("G", 1, 7));
            // newList.add(new Data("H", 1, 8));
            // newList.add(new Data("I", 1, 9));


            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return oldList.size();
                }

                @Override
                public int getNewListSize() {
                    return newList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return oldList.get(oldItemPosition).areItemsTheSame(newList.get(newItemPosition));
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return oldList.get(oldItemPosition).areContentsTheSame(newList.get(newItemPosition));
                }
            });

            diffResult.dispatchUpdatesTo(new ListUpdateCallback() {
                @Override
                public void onInserted(int position, int count) {
                    Log.i("DiffChange","onInserted "+position+"   "+count);
                }

                @Override
                public void onRemoved(int position, int count) {
                    Log.i("DiffChange","onRemoved "+position+"   "+count);
                }

                @Override
                public void onMoved(int fromPosition, int toPosition) {
                    Log.i("DiffChange","onMoved "+fromPosition+"   "+toPosition);
                }

                @Override
                public void onChanged(int position, int count, @Nullable Object payload) {
                    Log.i("DiffChange","onChanged "+position+"   "+count+ "   "+ payload);
                }
            });
        });
    }
}