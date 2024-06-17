package com.example.udemy_thecompleteandroid14developercourse_build100apps.LuckyNumberApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.Random;

public class NumberResultActivity extends AppCompatActivity {

    TextView resultDeclarationText, luckyNumberText;
    Button shareButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_result);

        resultDeclarationText = findViewById(R.id.resultDeclarationText);
        luckyNumberText = findViewById(R.id.resultNumber);
        shareButton = findViewById(R.id.shareButton);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        int randomNumber = generateRandomNumber();
        luckyNumberText.setText(""+randomNumber);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, randomNumber);
            }
        });
    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upperLimit = 1000;
        int randomGeneratedNumber = random.nextInt(upperLimit);
        return randomGeneratedNumber;
    }

    public void shareData(String userName, int randomNumber){
        // Implicit Intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, userName +" got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is: "+ randomNumber);
        startActivity(Intent.createChooser(intent, "Choose a platform"));
    }
}