package com.example.udemy_thecompleteandroid14developercourse_build100apps.kotlincontactmanagerapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val contactId:Int,
    var contactName:String,
    var contactEmail:String
)