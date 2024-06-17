package com.example.udemy_thecompleteandroid14developercourse_build100apps.ViewsAndWidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class TheCounterApp extends AppCompatActivity {
    int counter = 0;
    TextView welcomeText, counterText;
    Button counterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_counter_app);

        counterButton = findViewById(R.id.startCounterButton);
        counterText = findViewById(R.id.counterText);
        welcomeText = findViewById(R.id.welcomeText);

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterText.setText(""+increaseCounter());
            }
        });
    }

    public int increaseCounter(){
        return ++counter;
    }
}