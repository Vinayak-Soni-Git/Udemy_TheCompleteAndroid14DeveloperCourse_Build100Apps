package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinMastringRoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item:Item)
    
    @Delete
    suspend fun deleteItem(item:Item)
    
    @Update
    suspend fun updateTime(item:Item)
    
    @Query("DELETE FROM item")
    fun deleteAllItems()
    
    @Query("SELECT * FROM item")
    fun getAllItemsInDB():LiveData<List<Item>>
}