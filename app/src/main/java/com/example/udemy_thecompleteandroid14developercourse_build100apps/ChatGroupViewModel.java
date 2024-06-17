package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.WhatsappCloneAppUsingFirebaseAndMVVM.Repository.Repository;

import java.util.List;

import javax.annotation.Nonnull;

public class ChatGroupViewModel extends AndroidViewModel {
    Repository repository;

    public ChatGroupViewModel(@Nonnull Application application) {
        super(application);
        repository = new Repository();
    }

    // Auth
    public void signUpAnonymousUser() {
        Context context = this.getApplication();
        repository.firebaseAnonymousAuth(context);
    }

    public String getCurrentUserId() {
        return repository.getCurrentUserId();
    }

    public void signOut() {
        repository.signOut();
    }

    public MutableLiveData<List<ChatGroup>> getGroupList() {
        return repository.getChatGroupMutableLiveData();
    }

    public void createNewChatGroup(String groupName) {
        repository.createNewChatGroup(groupName);
    }
    
    public MutableLiveData<List<ChatMessage>> getMessageLiveData(String groupName){
        return repository.getMessageLiveData(groupName);
    }
    
    public void sendMessage(String message, String chatGroup){
        repository.sendMessage(message, chatGroup);
    }

}
