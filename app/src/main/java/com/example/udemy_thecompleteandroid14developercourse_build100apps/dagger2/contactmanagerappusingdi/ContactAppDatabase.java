package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi;

import androidx.room.Database;
import androidx.room.RoomDatabase;



@Database(entities = {Contact.class}, version = 1)
public abstract class ContactAppDatabase extends RoomDatabase {
        public abstract ContactDao getContactDao();


}
