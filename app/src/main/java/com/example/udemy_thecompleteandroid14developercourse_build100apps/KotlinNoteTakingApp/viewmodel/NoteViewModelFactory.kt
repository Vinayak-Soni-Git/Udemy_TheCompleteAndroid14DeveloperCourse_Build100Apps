package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.repository.NoteRepository

class NoteViewModelFactory(val application:Application,
                           private val noteRepository: NoteRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(application, noteRepository) as T
    }
                               
}