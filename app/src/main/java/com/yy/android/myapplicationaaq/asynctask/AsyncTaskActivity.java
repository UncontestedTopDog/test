package com.yy.android.myapplicationaaq.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.yy.android.myapplicationaaq.R;

import java.lang.ref.WeakReference;

public class AsyncTaskActivity extends AppCompatActivity {

    private int today = 0;
    private TextView text;
    AsyncTask asyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        text = findViewById(R.id.text);
        // MyTask myTask = new MyTask(this);
        // myTask.execute();
        new Thread(new Runnable() {
            @Override
            public void run() {
                asyncTask = new AsyncTask<Object, Integer ,Boolean>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        text.setText("0");
                        Log.i("ppppp","onPreExecute");
                    }

                    @Override
                    protected Boolean doInBackground(Object[] objects) {
                        Log.i("ppppp","doInBackground");
                        while (true) {
                            today++;
                            if (today > 10000)
                                break;
                            // if (today > 10000)
                            //     today = 0;
                            publishProgress(1,today);
                        }
                        return true;
                    }

                    @Override
                    protected void onPostExecute(Boolean result) {
                        super.onPostExecute(result);
                        Log.i("ppppp","onPostExecute");
                        // if (result) {
                        //     text.setText("SUCCESS");
                        // } else{
                        //     text.setText("FAIL");
                        // }
                    }


                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        Log.i("ppppp","onProgressUpdate");
                        // System.out.println("AAAAAA2"+Thread.currentThread().getName());
                        // text.setText(values[1]+"");
                    }


                }.execute();
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // asyncTask.cancel(true);
    }

    public static class MyTask extends AsyncTask<Object, Integer ,Boolean> {

        private WeakReference<AsyncTaskActivity> activity;

        int today = 0;

        public MyTask(
                AsyncTaskActivity activity) {
            this.activity = new WeakReference<AsyncTaskActivity>(activity);
        }

        @Override
        protected Boolean doInBackground(Object[] objects) {
            while (true) {
                today++;
                if (today > 1000)
                    break;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }


        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (activity.get() == null)
                return;
            if (result) {
                activity.get().text.setText("SUCCESS");
            } else{
                activity.get().text.setText("FAIL");
            }
        }
    }
}