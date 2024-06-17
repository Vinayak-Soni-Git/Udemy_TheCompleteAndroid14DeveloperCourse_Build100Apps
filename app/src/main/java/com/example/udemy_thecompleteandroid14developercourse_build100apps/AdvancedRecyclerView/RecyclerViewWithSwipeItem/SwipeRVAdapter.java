package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithSwipeItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class SwipeRVAdapter extends RecyclerView.Adapter<SwipeRVAdapter.SwipeViewHolder>{

    @NonNull
    @Override
    public SwipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SwipeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SwipeViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private TextView textEdit;
        private TextView textDelete;
//        private SwipeRevealLayout swipeRevealLayout;


        public SwipeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
//            textEdit = itemView.findViewById(R.id.txtEdit);
//            textDelete = itemView.findViewById(R.id.txtDelete);
//            swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);
            
        }
    }
    
}
