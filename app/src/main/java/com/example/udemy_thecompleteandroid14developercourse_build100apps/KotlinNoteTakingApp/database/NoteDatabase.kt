package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.dao.NoteDao
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.models.Note


@Database(entities = [Note::class], version=1)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getNoteDao():NoteDao
    
    companion object{
        @Volatile
        private var instance:NoteDatabase? = null
        private val LOCK = Any()
        
        operator fun invoke(context: Context) = instance ?:
            synchronized(LOCK){
                instance ?:
                createDatabase(context).also{
                    instance = it
                }
            }
        
        private fun createDatabase(context:Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "note_db"
        ).build()
    }
}