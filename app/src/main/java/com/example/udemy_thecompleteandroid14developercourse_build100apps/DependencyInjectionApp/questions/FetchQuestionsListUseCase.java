package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions;

import androidx.annotation.Nullable;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking.QuestionsListResponseSchema;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking.StackOverFlowApi;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questionslist.BaseObservable;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionsListUseCase extends BaseObservable<FetchQuestionsListUseCase.Listener> {

    private final StackOverFlowApi mStackoverflowApi;
    @Nullable
    Call<QuestionsListResponseSchema> call;


    public FetchQuestionsListUseCase(StackOverFlowApi stackoverflowApi) {


        mStackoverflowApi  = stackoverflowApi;
    }

    public void fetchLastActiveQuestionsAndNotify(int numOfQuestions){
        cancelCurrentFetchIfActive();

        call = mStackoverflowApi.lastActiveQuestions(numOfQuestions);
        call.enqueue(new Callback<QuestionsListResponseSchema>() {
            @Override
            public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                if (response.isSuccessful()){
                    notifySucceeded(response.body().getQuestionList());
                }else
                {
                    notifyFailed();
                }
            }

            @Override
            public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                notifyFailed();
            }
        });
    }

    private void cancelCurrentFetchIfActive(){
        if (call != null && !call.isCanceled() && !call.isExecuted()){
            call.cancel();
        }
    }

    private void notifySucceeded(List<Question> questions){
        List<Question> unmodifiableQuestions = Collections.unmodifiableList(questions);
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionsSucceeded(unmodifiableQuestions);
        }
    }

    private void notifyFailed(){
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionsFailed();
        }
    }

    public interface Listener {
        void onFetchOfQuestionsSucceeded(List<Question> questions);
        void onFetchOfQuestionsFailed();

    }

}
