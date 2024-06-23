package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questiondetails;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions.QuestionWithBody;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questionslist.BaseViewMVC;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;


public class QuestionDetailsViewMvcImpl extends BaseViewMVC<QuestionDetailsViewMVC.Listener>
        implements QuestionDetailsViewMVC {

    private final TextView mTxtQuestionBody;

    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.activity_question_details, container, false));
        mTxtQuestionBody = findViewById(R.id.questionBodyTextView);
    }

    @Override
    public void bindQuestion(QuestionWithBody question) {
        String questionBody = question.getBody();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mTxtQuestionBody.setText(Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY));
        } else {
            mTxtQuestionBody.setText(Html.fromHtml(questionBody));
        }
    }
}