package com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatGroupViewModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatMessage;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Adapters.ChatAdapter;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityChatBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    
    private ActivityChatBinding binding;
    private ChatGroupViewModel viewModel;
    private RecyclerView messagesRecyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatMessage> chatMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        viewModel = new ViewModelProvider(this).get(ChatGroupViewModel.class);
        messagesRecyclerView = binding.messagesRecyclerView;
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        messagesRecyclerView.setHasFixedSize(true);
        
        String groupName = getIntent().getStringExtra("GROUP_NAME");
        viewModel.getMessageLiveData(groupName).observe(this, new Observer<List<ChatMessage>>() {
            @Override
            public void onChanged(List<ChatMessage> chatMessage) {
                chatMessageList = new ArrayList<>();
                chatMessageList.addAll(chatMessage);
                
                chatAdapter = new ChatAdapter(chatMessageList, getApplicationContext());
                messagesRecyclerView.setAdapter(chatAdapter);
                
                chatAdapter.notifyDataSetChanged();
                int latestPosition = chatAdapter.getItemCount() - 1;
                if (latestPosition > 0){
                    messagesRecyclerView.smoothScrollToPosition(latestPosition);
                    
                }
                
                
            }
        });
        
        binding.setViewModel(viewModel);
        binding.sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = binding.messageEditText.getText().toString();
                
                
                viewModel.sendMessage(message, groupName);
                
                binding.messageEditText.getText().clear();
            }
        });
    }
}