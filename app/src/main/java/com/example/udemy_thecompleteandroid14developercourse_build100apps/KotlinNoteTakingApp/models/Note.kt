package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize  
data class Note(
    @PrimaryKey
    val id:Int,
    val title:String,
    val body:String
):Parcelable
