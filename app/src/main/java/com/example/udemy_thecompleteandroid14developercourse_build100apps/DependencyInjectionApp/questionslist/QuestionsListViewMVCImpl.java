package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questionslist;

import android.view.View;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questions.Question;

import java.util.List;

public class QuestionsListViewMVCImpl extends BaseViewMVC<QuestionsListViewMVC.Listener> implements QuestionsListViewMVC{
    @Override
    public void bindQuestions(List<Question> questions) {
        
    }

    @Override
    public View getRootView() {
        return null;
    }

//    private RecyclerView recyclerView;
//    private QuestionsListActivity.QuestionsAdapter adapter;
//    
//    public QuestionsListViewMVCImpl(LayoutInflater inflater, ViewGroup container){
//        setRootView(inflater.inflate(R.layout.questions_list_item_layout, container, false));
//        
//        recyclerView = container.findViewById(R.id.questionsListRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
//        adapter = new QuestionsListActivity.QuestionsAdapter(new QuestionsListActivity.OnQuestionClickListener() {
//            @Override
//            public void onQuestionClicked(Question question) {
//                for (Listener listener : getListeners()){
//                    listener.onQuestionClicked(question);
//                }
//            }
//        });
//        recyclerView.setAdapter(adapter);
//        
//        
//    }
//    @Override
//    public void registerListener(Listener listener) {
//        
//    }
//
//    @Override
//    public void unRegisterListener(Listener listener) {
//
//    }
//
//    @Override
//    public void bindQuestions(List<Question> questions) {
//        adapter.bindData(questions);
//    }
//    
//    @Override
//    public View getRootView() {
//        return null;
//    }
//    
//
//    public interface OnQuestionClickListener{
//        void onQuestionClicked(Question question);
//    }
//
//    public static class QuestionsAdapter extends RecyclerView.Adapter<QuestionsListActivity.QuestionsAdapter.QuestionViewHolder> {
//
//        private final QuestionsListActivity.OnQuestionClickListener mOnQuestionClickListener;
//        private List<Question> mQuestionList = new ArrayList<>(0);
//
//
//        public QuestionsAdapter(QuestionsListActivity.OnQuestionClickListener onQuestionClickListener) {
//            mOnQuestionClickListener = onQuestionClickListener;
//        }
//
//        // Binding Data
//        public void bindData(List<Question> questions) {
//            mQuestionList = new ArrayList<>(questions);
//            notifyDataSetChanged();
//        }
//
//        @NonNull
//        @Override
//        public QuestionsListActivity.QuestionsAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View itemView = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.questions_list_item_layout, parent, false);
//            return  new QuestionsListActivity.QuestionsAdapter.QuestionViewHolder(itemView);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull QuestionsListActivity.QuestionsAdapter.QuestionViewHolder holder, int position) {
//
//            // we will solve this after Question Class configuration with retrofit
//            holder.mTitle.setText(mQuestionList.get(position).getTitle());
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mOnQuestionClickListener.onQuestionClicked(mQuestionList.get(position));
//                }
//            });
//        }
//
//        @Override
//        public int getItemCount() {
//            return mQuestionList.size();
//        }
//
//        // View holder
//        public class QuestionViewHolder extends RecyclerView.ViewHolder {
//            public TextView mTitle;
//
//            public QuestionViewHolder(@NonNull View itemView) {
//                super(itemView);
//                mTitle = itemView.findViewById(R.id.textTitle);
//
//            }
//        }
//    }
    
}
