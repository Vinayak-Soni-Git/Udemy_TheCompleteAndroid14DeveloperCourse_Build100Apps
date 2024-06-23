package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi.DI;

import android.app.Application;

import androidx.room.Room;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi.ContactAppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    ContactAppDatabase provideContactAppDatabase(Application application){
        return Room.databaseBuilder(
                application,
                ContactAppDatabase.class,
                "ContactDB"
        )  .allowMainThreadQueries()
                .build();
    }
}

