package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.common.Constants;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.common.ServerErrorDialogFragment;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking.SingleQuestionResponseSchema;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.networking.StackOverFlowApi;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionDetailsActivity extends AppCompatActivity implements Callback<SingleQuestionResponseSchema> {
    
    private TextView textQuestionBody;
    private StackOverFlowApi stackOverFlowApi;
    private String questionId;
    private Call<SingleQuestionResponseSchema> call;
    
    public static void start(Context context, String questionId){
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra("QuestionId", questionId);
        context.startActivity(intent);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);
        
        textQuestionBody = findViewById(R.id.questionBodyTextView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        stackOverFlowApi = retrofit.create(StackOverFlowApi.class);
        
        questionId = getIntent().getExtras().getString("QuestionId");
        
    }

    @Override
    public void onResponse(Call<SingleQuestionResponseSchema> call, Response<SingleQuestionResponseSchema> response) {
         SingleQuestionResponseSchema singleQuestionResponseSchema;
         if (response.isSuccessful() && (singleQuestionResponseSchema = response.body()) != null){
             String questionBody = singleQuestionResponseSchema.getQuestions().getBody();
             textQuestionBody.setText(Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY));
         } else {
             onFailure(call, null);
         }
    }

    @Override
    public void onFailure(Call<SingleQuestionResponseSchema> call, Throwable t) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss();
    }

    @Override
    protected void onStart() {
        super.onStart();
        call = stackOverFlowApi.questionDetails(questionId);
        call.enqueue(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (call != null){
            call.cancel();
        }
    }
}