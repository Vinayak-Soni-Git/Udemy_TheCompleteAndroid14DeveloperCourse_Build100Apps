package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Models.QuestionList;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Repository.QuizRepository;

public class QuizViewModel extends ViewModel {
    QuizRepository quizRepository = new QuizRepository();
    LiveData<QuestionList> questionListLiveData;
    
    public QuizViewModel(){
        questionListLiveData = quizRepository.getQuestionsFromAPI();
    }

    public LiveData<QuestionList> getQuestionListLiveData() {
        return questionListLiveData;
    }
}
