package com.example.udemy_thecompleteandroid14developercourse_build100apps.ViewsAndWidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class ViewsAndWidgetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_and_widgets);

        //Declaring and Initialising views
        TextView myTextView = findViewById(R.id.myTextView);
        myTextView.setText("Hi From Java");

        //Edit Text
        EditText myEditText = findViewById(R.id.myEditText);
        String inputText = myEditText.getText().toString();

        //Buttons
        Button myButton = findViewById(R.id.myButton);

        //Listeners in Android
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewsAndWidgetsActivity.this, "You clicked the button", Toast.LENGTH_SHORT).show();
            }
        });

        //ImageView - Displaying Images
        ImageView myImageView = findViewById(R.id.myImage);
        myImageView.setImageResource(R.drawable.baseline_chat_24);

    }
}