package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questiondetails;


import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions.QuestionWithBody;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questionslist.ObservableViewMVC;

public interface QuestionDetailsViewMVC extends ObservableViewMVC<QuestionDetailsViewMVC.Listener> {
    void bindQuestion(QuestionWithBody question);
    interface Listener{

    }
}
