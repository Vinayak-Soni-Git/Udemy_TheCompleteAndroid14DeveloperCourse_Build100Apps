package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinMastringRoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val price:Double,
    val quantity:Int
)
