package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid.models

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("id")
    val id:Int,
    
    @SerializedName("userId")
    val userId:Int,
    
    @SerializedName("title")
    val title:String
)
