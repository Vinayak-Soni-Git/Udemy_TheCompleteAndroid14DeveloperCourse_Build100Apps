package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.Contacts;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    //because it contains the application context

    //Repository
    private Repository repository;

    //LiveData
    private LiveData<List<Contacts>> allContacts;

    public ViewModel(@NonNull Application application){
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = repository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contact){
        repository.addContact(contact);
    }

    public void deleteContact(Contacts contact){
        repository.deleteContact(contact);
    }
}
