package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking.SingleQuestionResponseSchema;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking.StackOverFlowApi;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questionslist.BaseObservable;

import javax.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionDetailsUseCase extends BaseObservable<FetchQuestionDetailsUseCase.Listener> {

    private final StackOverFlowApi mStackoverflowApi;
    @Nullable
    Call<SingleQuestionResponseSchema> call;



    public FetchQuestionDetailsUseCase(StackOverFlowApi stackoverflowApi){


        mStackoverflowApi = stackoverflowApi;

    }

    public void fetchQuestionDetailsAndNotify(String questionId){
        cancelCurrentFetchIfActive();

        call = mStackoverflowApi.questionDetails(questionId);
        call.enqueue(new Callback<SingleQuestionResponseSchema>() {
            @Override
            public void onResponse(Call<SingleQuestionResponseSchema> call, Response<SingleQuestionResponseSchema> response) {

                if (response.isSuccessful()){
                    notifySucceeded(response.body().getQuestions());
                }else{
                    notifyFailed();
                }
            }

            @Override
            public void onFailure(Call<SingleQuestionResponseSchema> call, Throwable t) {
                if (call != null && !call.isCanceled() && !call.isExecuted()){
                    call.cancel();
                }
            }


        });
    }

    private void cancelCurrentFetchIfActive(){
        if(call != null && !call.isCanceled() && !call.isExecuted()){
            call.cancel();
        }
    }

    private void notifySucceeded(QuestionWithBody question){
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionDetailsSucceeded(question);
        }
    }

    private void notifyFailed(){
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionDetailsFailed();
        }
    }

    public interface Listener {
        void onFetchOfQuestionDetailsSucceeded(QuestionWithBody question);
        void onFetchOfQuestionDetailsFailed();
    }
}
