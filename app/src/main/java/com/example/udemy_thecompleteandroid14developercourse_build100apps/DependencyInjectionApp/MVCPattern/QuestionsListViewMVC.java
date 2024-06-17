package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.MVCPattern;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.Question;

import java.util.List;

public interface QuestionsListViewMVC extends ObservableViewMVC<QuestionsListViewMVC.Listener> {
    void bindQuestions(List<Question> questions);
    interface Listener{
        void onQuestionClicked(Question question);
    }
}