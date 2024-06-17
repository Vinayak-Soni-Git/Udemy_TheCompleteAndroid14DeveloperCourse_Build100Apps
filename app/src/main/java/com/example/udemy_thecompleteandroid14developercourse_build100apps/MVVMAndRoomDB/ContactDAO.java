package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.Contacts;

import java.util.List;

@Dao
public interface ContactDAO {

    @Insert
    void insert(Contacts contact);

    @Delete
    void delete(Contacts contact);

    @Query("SELECT * FROM contacts")
    LiveData<List<Contacts>> getAllContacts();
}
