package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Models.QuestionList;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Retrofit.QuestionsAPI;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {
    //Interacts with the API service interface
    //Handling data retrieval and operations
    private QuestionsAPI questionsAPI;
    
    public QuizRepository(){
        this.questionsAPI = new RetrofitInstance()
                .getRetrofitInstance()
                .create(QuestionsAPI.class);
    }
    
    public LiveData<QuestionList> getQuestionsFromAPI(){
        MutableLiveData<QuestionList> data = new MutableLiveData<>();

        Call<QuestionList> response = questionsAPI.getQuestions();
        
        response.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                QuestionList list = response.body();
                data.setValue(list);
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {

            }
        });
        return data;
    }
}
