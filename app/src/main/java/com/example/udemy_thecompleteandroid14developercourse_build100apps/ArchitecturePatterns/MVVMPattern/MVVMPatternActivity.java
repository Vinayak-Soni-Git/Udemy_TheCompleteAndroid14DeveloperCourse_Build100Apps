package com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVVMPattern;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MVVMPatternActivity extends AppCompatActivity {
    
    Button button;
    TextView textView;
    
    // connecting MainActivity with viewmodel and listening to live data
    MVVMViewModel mvvmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmpattern);
        
        button = findViewById(R.id.displayAppButton);
        textView = findViewById(R.id.textViewApp);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvvmViewModel.getAppName();
            }
        });
        
        mvvmViewModel = new ViewModelProvider(this).get(MVVMViewModel.class);
        mvvmViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }
}