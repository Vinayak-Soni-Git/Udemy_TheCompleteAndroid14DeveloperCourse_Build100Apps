package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.Contacts;

@Database(entities = {Contacts.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDao();

    // Singleton pattern
    private static ContactDatabase dbInstance;

    public static synchronized ContactDatabase getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ContactDatabase.class,
                            "contacts")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dbInstance;
    }
}
