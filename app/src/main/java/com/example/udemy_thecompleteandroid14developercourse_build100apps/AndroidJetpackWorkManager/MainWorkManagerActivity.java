package com.example.udemy_thecompleteandroid14developercourse_build100apps.AndroidJetpackWorkManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MainWorkManagerActivity extends AppCompatActivity {
    
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_work_manager);
        button = findViewById(R.id.startWorkManagerButton);
        
        //Data
        Data data = new Data.Builder().putInt("max_limit", 500).build();
        
        
        //Constraints
        Constraints constraints = new Constraints
                .Builder()
                .setRequiresCharging(true)
                .build();

        WorkRequest workRequest = new OneTimeWorkRequest
                .Builder(MyWorker.class)
                .setConstraints(constraints)
                .setInputData(data)
                .build();
        
        //Making use of worker
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkManager.getInstance(getApplicationContext()).enqueue(workRequest);
            }
        });
        
        //Monitoring the status of work manager
        WorkManager.getInstance(getApplicationContext()).getWorkInfoByIdLiveData(workRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if (workInfo != null){
                            Toast.makeText(MainWorkManagerActivity.this, "Status: "+workInfo.getState().name(), Toast.LENGTH_SHORT).show();
                            if (workInfo.getState().isFinished()){
                                Data data1 = workInfo.getOutputData();
                                Toast.makeText(MainWorkManagerActivity.this, ""+data1.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}