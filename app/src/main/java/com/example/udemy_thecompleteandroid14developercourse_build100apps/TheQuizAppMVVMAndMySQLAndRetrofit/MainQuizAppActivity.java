package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Models.Question;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Models.QuestionList;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.ViewModel.QuizViewModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityMainQuizAppBinding;

import java.util.List;

public class MainQuizAppActivity extends AppCompatActivity {

    ActivityMainQuizAppBinding binding;
    QuizViewModel quizViewModel;
    List<Question> questionList;

    static int result = 0;
    static int totalQuestions = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz_app);
        binding = ActivityMainQuizAppBinding.inflate(getLayoutInflater());

        result = 0;
        totalQuestions = 0;

        quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
        displayFirstQuestion();

    }

    public void displayFirstQuestion() {
        quizViewModel.getQuestionListLiveData().observe(this, new Observer<QuestionList>() {
            @Override
            public void onChanged(QuestionList questions) {
                questionList = questions;
                binding.textQuestion.setText("Question 1: " + questions.get(0).getQuestion());
                binding.radioButton1.setText(questions.get(0).getOption1());
                binding.radioButton2.setText(questions.get(0).getOption2());
                binding.radioButton3.setText(questions.get(0).getOption3());
                binding.radioButton4.setText(questions.get(0).getOption4());
            }
        });
    }

    public void displayNextQuestion() {
        //Direct the user to the result activity
        if (binding.buttonNext.getText().equals("Finish")){
            Intent intent = new Intent(MainQuizAppActivity.this, QuizResultActivity.class);
            startActivity(intent);
            finish();
        }
        
        //Displaying the question
        int selectedOption = binding.radioGroup.getCheckedRadioButtonId();
        if (selectedOption != -1) {
            RadioButton radioButton = findViewById(selectedOption);

            //More questions to display
            if ((questionList.size() - i) > 0) {

                //Getting the number of question
                totalQuestions = questionList.size();
                if (radioButton.getText().toString().equals(questionList.get(i).getCorrectOption())) {
                    result++;
                    binding.textResult.setText("Correct Answer: " + result);
                }
                if (i == 0){
                    i++;
                }
                binding.textQuestion.setText("Question "+(i+1)+" : "+questionList.get(i).getQuestion());
                binding.radioButton1.setText(questionList.get(i).getOption1());
                binding.radioButton2.setText(questionList.get(i).getOption2());
                binding.radioButton3.setText(questionList.get(i).getOption3());
                binding.radioButton4.setText(questionList.get(i).getOption4());
                
                // Check if it is the last question
                if (i == (questionList.size()) - 1){
                    binding.buttonNext.setText("Finish");
                }
                binding.radioGroup.clearCheck();
                i++;
            } else {
                if (radioButton.getText().toString().equals(questionList.get(i-1).getCorrectOption())){
                    result++;
                    binding.textResult.setText("Correct Answer :"+ result);
                }
            }
        } else {
            Toast.makeText(this, "You need to make a selection", Toast.LENGTH_SHORT).show();
        }
    }
}