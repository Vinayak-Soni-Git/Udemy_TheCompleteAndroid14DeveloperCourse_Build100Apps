package com.example.udemy_thecompleteandroid14developercourse_build100apps.LuckyNumberApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MainLuckyNumberAppActivity extends AppCompatActivity {

    EditText nameEditText;
    Button generateLuckyNumberButton;
    TextView welcomeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lucky_number_app);

        nameEditText = findViewById(R.id.nameEditText);
        generateLuckyNumberButton = findViewById(R.id.generateLuckyNumberButton);
        welcomeTextView = findViewById(R.id.welcomeText);

        generateLuckyNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = nameEditText.getText().toString();

                //Explicit Intent
                Intent intent = new Intent(getApplicationContext(), NumberResultActivity.class);
                intent.putExtra("name", userName);
                startActivity(intent);

            }
        });

    }
}