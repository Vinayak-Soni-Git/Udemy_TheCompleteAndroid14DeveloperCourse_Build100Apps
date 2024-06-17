package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityQuizResultBinding;

public class QuizResultActivity extends AppCompatActivity {

    ActivityQuizResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        binding = ActivityQuizResultBinding.inflate(getLayoutInflater());
        binding.result.setText("Your score is:"+MainQuizAppActivity.result+"/"+MainQuizAppActivity.totalQuestions);
        
        binding.backToQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, MainQuizAppActivity.class);
                startActivity(intent);
            }
        });
    }
}