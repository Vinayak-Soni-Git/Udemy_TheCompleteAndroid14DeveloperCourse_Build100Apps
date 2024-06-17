package com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.BR;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatMessage;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.RowChatBinding;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    
    private List<ChatMessage> chatMessageList;
    private Context context;
    
    public ChatAdapter(List<ChatMessage> chatMessageList, Context context){
        this.chatMessageList = chatMessageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row_chat,
                parent,
                false
        );
        RowChatBinding binding = DataBindingUtil.bind(view);
        return new ChatViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.chatMessage, chatMessageList.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return chatMessageList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        private RowChatBinding binding;


        public ChatViewHolder(RowChatBinding binding) {
            super(binding.getRoot());
            setBinding(binding);
        }

        public RowChatBinding getBinding() {
            return binding;
        }

        public void setBinding(RowChatBinding binding) {
            this.binding = binding;
        }
    }
}