package com.example.udemy_thecompleteandroid14developercourse_build100apps.FirebaseCloudMessagingApp;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    private static final String TAG = "MyWorker";
    
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters){
        super(context, workerParameters);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.v(TAG, "Performing long running task");
        return Result.success();
    }
}
