package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinCoroutines

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainCoroutinesAppActivity : AppCompatActivity() {

    private val textView1: TextView = findViewById(R.id.textView1);
    private val textView2: TextView = findViewById(R.id.textView2);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines_app)

        sayHelloFromMainThread()
        sayHelloFromBackgroundThread()
    }

    private fun sayHelloFromMainThread() {
        CoroutineScope(Dispatchers.Main).launch {
            textView1.text = "Hello from ${Thread.currentThread().name}"
        }
    }

    private fun sayHelloFromBackgroundThread() {
        CoroutineScope(Dispatchers.IO).launch {
            textView2.text = "Hello from ${Thread.currentThread().name}"
        }
    }
}