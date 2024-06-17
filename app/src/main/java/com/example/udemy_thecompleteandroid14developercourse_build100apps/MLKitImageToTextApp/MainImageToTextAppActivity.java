package com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitImageToTextApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MainImageToTextAppActivity extends AppCompatActivity {

    Button captureButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_image_to_text_app);
        
        captureButton = findViewById(R.id.captureButton);
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainImageToTextAppActivity.this, ScannerActivity.class);
                startActivity(intent);
            }
        });
        
    }
}