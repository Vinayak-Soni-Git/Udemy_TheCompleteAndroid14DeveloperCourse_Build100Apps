package com.example.udemy_thecompleteandroid14developercourse_build100apps.TopCompaniesApp

import com.google.gson.annotations.SerializedName

data class Company(
    val name:String,
    val countryCode:String,
    
    @SerializedName("market_cap")
    val marketCap:Double,
    val id:Int
)