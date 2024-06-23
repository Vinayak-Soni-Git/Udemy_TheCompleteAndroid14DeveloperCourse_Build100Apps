package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    void insert(Contact contact);

    @Query("SELECT * FROM contacts")
    List<Contact> getAllContacts();

    @Delete
    void delete(Contact contact);



}
