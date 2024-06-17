package com.example.udemy_thecompleteandroid14developercourse_build100apps.AndroidJetpackWorkManager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    private final String tag = "Worker";
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Data data = getInputData();
        int countingLimit = data.getInt("max_limit", 0);
        
        
        for (int i=0;i<countingLimit;i++){
            Log.i(tag, "Count is : "+i);
        }
        
        //Sending data and Done notification
        Data dataToSend = new Data.Builder().putString("msg", "Task done successfully").build();
        return Result.success(dataToSend);
    }
}
