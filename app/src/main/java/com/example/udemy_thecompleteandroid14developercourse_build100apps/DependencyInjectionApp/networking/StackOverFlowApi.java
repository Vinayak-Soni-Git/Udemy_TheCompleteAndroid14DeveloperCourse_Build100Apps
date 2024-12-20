package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackOverFlowApi {
    
    @GET("/questions?order=desc&sort=activity&site=stackoverflow")
    Call<QuestionsListResponseSchema> lastActiveQuestions(@Query("pagesize") Integer pageSize);
    
    @GET("/questions/{questionId}site=stackoverflow&filter=withbody")
    Call<SingleQuestionResponseSchema> questionDetails(@Path("questionId") String questionId);

}
