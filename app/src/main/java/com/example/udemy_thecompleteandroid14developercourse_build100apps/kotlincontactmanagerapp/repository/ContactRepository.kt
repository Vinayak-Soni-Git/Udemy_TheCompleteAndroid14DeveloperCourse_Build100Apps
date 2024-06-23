package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.repository

import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.dao.ContactDao
import com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.models.Contact

class ContactRepository(private val contactDao:ContactDao) {
    val contacts = contactDao.getAllContacts()
    
    suspend fun insert(contact:Contact):Long{
        return contactDao.insertContact(contact)
    }
    
    suspend fun delete(contact:Contact){
        return contactDao.deleteContact(contact)
    }
    
    suspend fun update(contact:Contact){
        return contactDao.updateContact(contact)
    }
    
    suspend fun deleteAll(){
        return contactDao.deleteAll()
    }
}