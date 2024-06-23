package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityKotlinContactManagerAppBinding
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.adapters.ContactsAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.database.ContactDatabase
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.models.Contact
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.repository.ContactRepository
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.viewmodel.ContactViewModel
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.viewmodel.ContactViewModelFactory

class KotlinContactManagerApp : AppCompatActivity() {
    
    private lateinit var binding: ActivityKotlinContactManagerAppBinding
    private lateinit var contactsViewModel: ContactViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_kotlin_contact_manager_app)
        
        val dao = ContactDatabase.getInstance(applicationContext).contactDao
        val repository = ContactRepository(dao)
        val factory = ContactViewModelFactory(repository)
        
        contactsViewModel = ViewModelProvider(this, factory)[ContactViewModel::class.java]
        binding.contactViewModel = contactsViewModel
        binding.lifecycleOwner = this
        
        initRecyclerView()
        
        
    }

    private fun initRecyclerView() {
        binding.contactsRecyclerView.layoutManager = LinearLayoutManager(this)
        displayUsersList()
    }

    private fun displayUsersList() {
        contactsViewModel.contacts.observe(this, Observer{
            binding.contactsRecyclerView.adapter = ContactsAdapter(it, {selectedItem:Contact -> listItemClicked(selectedItem)})
            
        })
    }
    private fun listItemClicked(selectedItem:Contact){
        Toast.makeText(this, "Selected name is ${selectedItem.contactName}", Toast.LENGTH_SHORT).show()
        contactsViewModel.initUpdateAndDelete(selectedItem)
    }
}