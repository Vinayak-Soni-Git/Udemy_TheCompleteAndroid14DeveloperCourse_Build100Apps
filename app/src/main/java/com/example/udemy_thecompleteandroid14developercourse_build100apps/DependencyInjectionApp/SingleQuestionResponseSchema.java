package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class SingleQuestionResponseSchema {
    @SerializedName("items")
    private final List<QuestionWithBody> questions;
    
    public SingleQuestionResponseSchema(QuestionWithBody questions){
        this.questions = Collections.singletonList(questions);
    }
    
    public QuestionWithBody getQuestions(){
        return questions.get(0);
    }
}
