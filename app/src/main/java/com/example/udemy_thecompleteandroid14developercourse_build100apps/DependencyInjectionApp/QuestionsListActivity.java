package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsListActivity extends AppCompatActivity implements Callback<QuestionsListResponseSchema> {

    private RecyclerView mRecyclerView;
    private QuestionsAdapter mQuestionAdapter;

    private StackOverFlowApi mStackoverflowApi;

    private Call<QuestionsListResponseSchema> mCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);

        // Initializing RecyclerView
        mRecyclerView = findViewById(R.id.questionsListRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mQuestionAdapter = new QuestionsAdapter(new OnQuestionClickListener() {
            @Override
            public void onQuestionClicked(Question question) {
                // 1- we will  create a details Activity
                // 2- getId() will be solved in Question Class
                    QuestionDetailsActivity.start(QuestionsListActivity.this, question.getQuestionId());
            }
        });

        mRecyclerView.setAdapter(mQuestionAdapter);






        /* ***********   Retrofit Configuration  *************************/

        // 1- Dependency of retrofit        X
        // 2- StackOverFlow API   X
        // 3- Question Class  X
        // 4- Configuration of other classes and Interfaces   XX
        // 5- Running the App

        // I will separate every thing
        // UI & Networking...

        // Initiate Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mStackoverflowApi = retrofit.create(StackOverFlowApi.class);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mCall = mStackoverflowApi.lastActiveQuestions(20);
        mCall.enqueue(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mCall !=null){
            mCall.cancel();
        }
    }

    @Override
    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
        QuestionsListResponseSchema responseSchema;
        if(response.isSuccessful() && (responseSchema = response.body()) != null){
            mQuestionAdapter.bindData(responseSchema.getQuestionList());
        }else{
            onFailure(call, null);
        }
    }

    @Override
    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss();
    }


    /***************  RecyclerView Adapter *******************/
    public interface OnQuestionClickListener{
        void onQuestionClicked(Question question);

    }

    public static class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {

        private final OnQuestionClickListener mOnQuestionClickListener;
        private List<Question> mQuestionList = new ArrayList<>(0);


        public QuestionsAdapter(OnQuestionClickListener onQuestionClickListener) {
            mOnQuestionClickListener = onQuestionClickListener;
        }

        // Binding Data
        public void bindData(List<Question> questions) {
            mQuestionList = new ArrayList<>(questions);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.questions_list_item_layout, parent, false);
            return new QuestionViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

            // we will solve this after Question Class configuration with retrofit
            holder.mTitle.setText(mQuestionList.get(position).getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnQuestionClickListener.onQuestionClicked(mQuestionList.get(position));
                }
            });
        }

        @Override
        public int getItemCount() {
            return mQuestionList.size();
        }

        // View holder
        public static class QuestionViewHolder extends RecyclerView.ViewHolder {
            public TextView mTitle;

            public QuestionViewHolder(@NonNull View itemView) {
                super(itemView);
                mTitle = itemView.findViewById(R.id.textTitle);

            }
        }
    }
}