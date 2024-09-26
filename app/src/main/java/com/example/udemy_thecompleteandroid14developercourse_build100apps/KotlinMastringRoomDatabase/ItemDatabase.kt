package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinMastringRoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase:RoomDatabase() {
    abstract fun itemDao():ItemDao
    
    companion object{
        @Volatile
        private var Instance:ItemDatabase? = null
        
        fun getDatabase(context:Context):ItemDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    ItemDatabase::class.java,
                    "item_database"
                ).build().also { Instance = it }
            }
        }
    }
}