package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.dao.ContactDao
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.models.Contact

@Database(entities = [Contact::class], version=1)
abstract class ContactDatabase:RoomDatabase() {
    abstract val contactDao:ContactDao
    
    // Singleton design pattern
    // Only one instance of database exists
    // Avoiding unnecessary overhead associated with repeated database creation
    companion object{
        @Volatile
        private var INSTANCE:ContactDatabase ?= null
        fun getInstance(context: Context):ContactDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contacts_db"
                    ).build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
    
}