package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions.Question;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsListResponseSchema {
    @SerializedName("items")
    private final List<Question> questionList;
    
    public QuestionsListResponseSchema(List<Question> questionList){
        this.questionList = questionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
