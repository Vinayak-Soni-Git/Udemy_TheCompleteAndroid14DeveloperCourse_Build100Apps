package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.repository.ContactRepository

class ContactViewModelFactory(private val repository: ContactRepository) :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContactViewModel::class.java)){
                return ContactViewModel(repository) as T    
            }
        throw IllegalArgumentException("Unknown view model class")
    }
}