package com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVCPattern;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MVCPatternActivity extends AppCompatActivity {
    
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvcpattern);
        
        textView = findViewById(R.id.textViewApp);
    }
    
    public MVCModel getAppFromModel(){
        return new MVCModel("Master Coding App", 900000, 4);
    }
    
    public void displayAppInText(View view){
        textView.setText(getAppFromModel().getAppName() +" "+getAppFromModel().getAppDownloads());
    }
}