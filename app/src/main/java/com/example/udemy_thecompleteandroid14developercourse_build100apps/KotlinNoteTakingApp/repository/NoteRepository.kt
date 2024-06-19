package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.repository

import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.database.NoteDatabase
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.models.Note

class NoteRepository(private val db:NoteDatabase) {
    
    suspend fun insertNote(note:Note) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note:Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note:Note) = db.getNoteDao().updateNote(note)
    
    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query:String?) = db.getNoteDao().searchNote(query)
    
}