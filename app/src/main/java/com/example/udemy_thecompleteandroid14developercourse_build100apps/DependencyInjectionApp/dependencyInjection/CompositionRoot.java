package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.dependencyInjection;

import androidx.annotation.UiThread;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.common.Constants;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking.StackOverFlowApi;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions.FetchQuestionDetailsUseCase;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions.FetchQuestionsListUseCase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@UiThread
public class CompositionRoot {

    private Retrofit retrofit;
    private StackOverFlowApi stackoverflowApi;

    @UiThread
    private Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    @UiThread
    private StackOverFlowApi getStackoverflowApi(){
        if (stackoverflowApi == null){
            stackoverflowApi = getRetrofit().create(StackOverFlowApi.class);
        }
        return stackoverflowApi;
    }

    @UiThread
    public FetchQuestionDetailsUseCase getfetchQuestionDetailsUseCase(){
        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
    }

    @UiThread
    public FetchQuestionsListUseCase getfetchQuestionsListUseCase(){
        return new FetchQuestionsListUseCase(getStackoverflowApi());
    }
}
