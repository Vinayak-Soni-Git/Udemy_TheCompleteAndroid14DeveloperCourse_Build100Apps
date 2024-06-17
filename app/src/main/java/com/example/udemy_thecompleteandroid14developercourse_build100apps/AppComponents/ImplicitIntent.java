package com.example.udemy_thecompleteandroid14developercourse_build100apps.AppComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class ImplicitIntent extends AppCompatActivity {
    Button openWebsiteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        openWebsiteButton = findViewById(R.id.openWebsiteButton);
        openWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage();
            }
        });
    }

    public void openWebPage(){
        Uri webPage = Uri.parse("https://www.google.com");

        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        startActivity(intent);
    }
}