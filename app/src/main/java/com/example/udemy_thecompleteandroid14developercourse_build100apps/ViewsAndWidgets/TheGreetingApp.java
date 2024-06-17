package com.example.udemy_thecompleteandroid14developercourse_build100apps.ViewsAndWidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class TheGreetingApp extends AppCompatActivity {

    EditText nameEditText;
    Button myButton;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_greeting_app);
        nameEditText = findViewById(R.id.nameEditText);
        myButton = findViewById(R.id.greetButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = nameEditText.getText().toString();
                Toast.makeText(TheGreetingApp.this, "welcome "+inputName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}