package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid.instance

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    
    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        
        fun getRetrofitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}