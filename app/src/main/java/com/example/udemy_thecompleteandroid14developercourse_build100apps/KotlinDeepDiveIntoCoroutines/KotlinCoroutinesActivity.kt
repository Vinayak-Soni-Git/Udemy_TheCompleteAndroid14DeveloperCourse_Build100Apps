package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinDeepDiveIntoCoroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KotlinCoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_coroutines)
        
        val mainScope = CoroutineScope(Dispatchers.Main)
        val backgroundScope = CoroutineScope(Dispatchers.IO)
        
        val job = mainScope.launch { 
            Log.v("tag", "Using the $coroutineContext")
            
            // Switching to IO Dispatcher Temporarily
            withContext(Dispatchers.IO){
                Log.v("tag", "Using the $coroutineContext")
                delay(1000)
            }
            
            // Switcher to Main Dispatcher
            Log.v("tag", "Using the $coroutineContext")
        }
        
        job.cancel()
    }
    
    
}