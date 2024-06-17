package com.example.udemy_thecompleteandroid14developercourse_build100apps.FrenchTeacherApp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class MainFrenchTeacherAppActivity extends AppCompatActivity implements View.OnClickListener {
    Button blackButton, redButton, yellowButton, greenButton, purpleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_french_teacher_app);

        blackButton = findViewById(R.id.buttonBlack);
        redButton = findViewById(R.id.buttonRed);
        yellowButton = findViewById(R.id.buttonYellow);
        greenButton = findViewById(R.id.buttonGreen);
        purpleButton = findViewById(R.id.buttonPurple);

        blackButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        purpleButton.setOnClickListener(this)   ;

    }

    @Override
    public void onClick(View v) {
        int clickedButtonId = v.getId();

        if (clickedButtonId == R.id.buttonRed){
            playSound(R.raw.red);
        } else if (clickedButtonId == R.id.buttonBlack){
            playSound(R.raw.black);
        } else if (clickedButtonId == R.id.buttonGreen){
            playSound(R.raw.green);
        } else if (clickedButtonId == R.id.buttonPurple){
            playSound(R.raw.purple);
        } else if (clickedButtonId == R.id.buttonYellow){
            playSound(R.raw.yellow);
        }
    }

    public void playSound(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this, id
        );
        mediaPlayer.start();
    }
}