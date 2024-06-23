package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions;

import com.google.gson.annotations.SerializedName;

public class QuestionWithBody {
    @SerializedName("title")
    private final String title;
    
    @SerializedName("questionId")
    private final String id;
    
    @SerializedName("body")
    private final String body;
    
    public QuestionWithBody(String title, String id, String body) {
        this.title = title;
        this.id = id;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
