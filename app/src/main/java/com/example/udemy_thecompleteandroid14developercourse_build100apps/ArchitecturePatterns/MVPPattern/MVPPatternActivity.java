package com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVPPattern;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MVPPatternActivity extends AppCompatActivity implements AppView {
    
    Button button;
    TextView textView;
    
    Presenter appPresenter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppattern);
        
        button = findViewById(R.id.displayAppButton);
        appPresenter = new Presenter(this);
        
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appPresenter.getAppDetails();
            }
        });
        
    }

    @Override
    public void onGetAppName(String name) {
        textView.setText(name);
    }
}   