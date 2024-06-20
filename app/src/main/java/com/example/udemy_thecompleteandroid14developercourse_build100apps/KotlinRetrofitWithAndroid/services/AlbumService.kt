package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid.services

import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid.models.AlbumArray
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    // You should specify endpoints of the url
    @GET("/albums")
    suspend fun getAlbums():Response<AlbumArray>
    
    @GET("/albums")
    suspend fun getSpecificAlbums(@Query ("userId") userId:Int):Response<AlbumArray>
    
}