package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid.instance.RetrofitInstance
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid.models.AlbumArray
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinRetrofitWithAndroid.services.AlbumService
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import retrofit2.Response

class RetrofitKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_kotlin)
        
        val resultTextView:TextView = findViewById(R.id.retrofitResultTextView)
        
        val retrofitService = RetrofitInstance.getRetrofitInstance()
            .create(AlbumService::class.java)
        
        val responseLiveData:LiveData<Response<AlbumArray>> = liveData { 
            val response = retrofitService.getAlbums()
            val response2 = retrofitService.getSpecificAlbums(6)
            emit(response)
            emit(response2)
        }
        responseLiveData.observe(this, Observer { 
            val albumList = it.body()?.listIterator()
            
            if (albumList != null){
                while(albumList.hasNext()){
                    val albumItem = albumList.next()
                    val result = "Album Title: ${albumItem.title}\n"
                    resultTextView.append(result)
                }
            }
        })
        
    }
}