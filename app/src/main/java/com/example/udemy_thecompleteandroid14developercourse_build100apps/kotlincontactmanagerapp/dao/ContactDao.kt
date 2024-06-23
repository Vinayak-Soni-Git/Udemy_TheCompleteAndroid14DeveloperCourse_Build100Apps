package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.models.Contact

@Dao
interface ContactDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact:Contact):Long
    
    @Update
    suspend fun updateContact(contact:Contact)
    
    @Delete
    suspend fun deleteContact(contact:Contact)
    
    @Query("delete from contacts")
    suspend fun deleteAll()
    
    @Query("select * from contacts")
    fun getAllContacts():LiveData<List<Contact>>
}