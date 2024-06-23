package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.models.Contact
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository):ViewModel(), Observable {
    val contacts = repository.contacts
    private var isUpdateOrDelete = false
    private lateinit var contactToUpdateOrDelete:Contact
    
    @Bindable
    val inputName = MutableLiveData<String?>()
    
    @Bindable
    val inputEmail = MutableLiveData<String?>()
    
    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()
    
    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()
    
    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    
    fun insert(contact:Contact) = viewModelScope.launch { 
        repository.insert(contact)
    }
    
    fun delete(contact:Contact) = viewModelScope.launch {
        repository.delete(contact)
        
        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    
    fun update(contact:Contact) = viewModelScope.launch { 
        repository.update(contact)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    
    fun clearAll() = viewModelScope.launch { 
        repository.deleteAll()
    }
    
    fun saveOrUpdate(){
        if (isUpdateOrDelete){
            contactToUpdateOrDelete.contactName = inputName.value!!
            contactToUpdateOrDelete.contactEmail = inputEmail.value!!
            update(contactToUpdateOrDelete)
        }else {
            val name = inputName.value!!
            val email = inputEmail.value!!
            
            insert(Contact(0, name, email))
            inputEmail.value = null
            inputName.value = null
        }
    }
    
    fun clearAllOrDelete(){
        if (isUpdateOrDelete){
            delete(contactToUpdateOrDelete)
        }else{
            clearAll()
        }
    }
    
    fun initUpdateAndDelete(contact:Contact){
        inputName.value = contact.contactName
        inputEmail.value = contact.contactEmail
        isUpdateOrDelete = true
        contactToUpdateOrDelete = contact
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        
    }

}