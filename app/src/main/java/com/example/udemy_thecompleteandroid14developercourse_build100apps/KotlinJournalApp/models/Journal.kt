package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.models

import com.google.firebase.Timestamp

data class Journal (
    val title:String,
    val thought:String,
    val imageUrl:String,
    val userId:String,
    val timeAdded:Timestamp,
    val userName:String
    
)