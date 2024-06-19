package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.database.NoteDatabase
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.repository.NoteRepository
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.viewmodel.NoteViewModel
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.viewmodel.NoteViewModelFactory
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityMainNoteTakingAppBinding

class MainNoteTakingAppActivity : AppCompatActivity() {
    
    lateinit var noteViewModel: NoteViewModel
    lateinit var binding: ActivityMainNoteTakingAppBinding
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainNoteTakingAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}