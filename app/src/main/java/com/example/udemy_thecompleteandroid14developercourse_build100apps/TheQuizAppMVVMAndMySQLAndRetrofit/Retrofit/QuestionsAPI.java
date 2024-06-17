package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Retrofit;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.TheQuizAppMVVMAndMySQLAndRetrofit.Models.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionsAPI {
    
    @GET("quiz_json.json")
    Call<QuestionList> getQuestions();
}
