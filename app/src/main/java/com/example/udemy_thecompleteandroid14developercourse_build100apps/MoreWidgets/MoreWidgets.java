package com.example.udemy_thecompleteandroid14developercourse_build100apps.MoreWidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MoreWidgets extends AppCompatActivity {
    CheckBox checkBox;
    RadioGroup radioGroup;
    Spinner spinner;
    TimePicker timePicker;
    DatePicker datePicker;
    ProgressBar progressBar;
    int progress = 0;
    Button clickMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_widgets);

        //CheckBox
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MoreWidgets.this, "The Checkbox is checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MoreWidgets.this, "The Checkbox is unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Radio Button
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MoreWidgets.this, "You selected: "+ radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        spinner = findViewById(R.id.spinner);
        String[] courses = {"C++", "Java", "Kotlin", "Python"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        spinner.setAdapter(adapter);

//        timePicker = findViewById(R.id.timePicker);
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                Toast.makeText(MoreWidgets.this, "Hour: "+hourOfDay+" minute: "+minute, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        datePicker = findViewById(R.id.datePicker);

        progressBar = findViewById(R.id.progressBar);
        clickMeButton = findViewById(R.id.button);


        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress += 10;
                progressBar.setProgress(progress);
                if (progressBar.getProgress() > 25){
                    progressBar.getProgressDrawable().setColorFilter(Color.rgb(255, 127, 0), android.graphics.PorterDuff.Mode.SRC_IN);
                } if (progressBar.getProgress() > 50){
                    progressBar.getProgressDrawable().setColorFilter(Color.rgb(255, 100, 100), PorterDuff.Mode.SRC_IN);
                } if (progressBar.getProgress() > 75){
                    progressBar.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                }

            }
        });

    }
}