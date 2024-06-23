package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions;

import com.google.gson.annotations.SerializedName;

public class Question {
    @SerializedName("title")
    private final String title;
    
    @SerializedName("question_id")
    private final String questionId;
    
    
    public Question(String title, String questionId){
        this.title = title;
        this.questionId = questionId;
    };

    public String getTitle() {
        return title;
    }

    public String getQuestionId() {
        return questionId;
    }
}
