package com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Repository;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatGroup;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.ChatMessage;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Activities.GroupsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    MutableLiveData<List<ChatGroup>> chatGroupMutableLiveData;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    DatabaseReference groupReference;
    MutableLiveData<List<ChatMessage>> messageLiveData;
    

    public Repository() {
        this.chatGroupMutableLiveData = new MutableLiveData<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
        
        messageLiveData = new MutableLiveData<>();
    }

    public void firebaseAnonymousAuth(Context context) {
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(context, GroupsActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        }
                    }
                });
    }

    // Getting current user id
    public String getCurrentUserId() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    // SignOut Functionality
    public void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    // Getting chat groups available from firebase realtime DB
    public MutableLiveData<List<ChatGroup>> getChatGroupMutableLiveData() {
        List<ChatGroup> groupList = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                groupList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ChatGroup chatGroup = new ChatGroup(dataSnapshot.getKey());
                    groupList.add(chatGroup);
                }
                chatGroupMutableLiveData.postValue(groupList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return chatGroupMutableLiveData;
    }

    //Creating a new group
    public void createNewChatGroup(String groupName) {
        reference.child(groupName).setValue(groupName);

    }

    public MutableLiveData<List<ChatMessage>> getMessageLiveData(String groupName) {
        groupReference = firebaseDatabase.getReference().child(groupName);
        List<ChatMessage> messageList = new ArrayList<>();
        groupReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        ChatMessage message = dataSnapshot.getValue(ChatMessage.class);
                    messageList.add(message);
                }
                messageLiveData.postValue(messageList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return messageLiveData;
    }
    
    public void sendMessage(String message, String chatGroup){
        DatabaseReference rf = firebaseDatabase.getReference(chatGroup);
        if (!message.trim().equals("")){
            ChatMessage chatMessage = new ChatMessage(FirebaseAuth.getInstance().getCurrentUser().getUid(),
                    message, System.currentTimeMillis());
            
            String randomKey = rf.push().getKey();
            rf.child(randomKey).setValue(chatMessage);
        }
    }
}
