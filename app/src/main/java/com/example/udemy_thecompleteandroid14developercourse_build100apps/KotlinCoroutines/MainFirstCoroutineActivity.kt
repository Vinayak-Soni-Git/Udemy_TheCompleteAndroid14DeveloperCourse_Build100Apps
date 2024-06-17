package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinCoroutines

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFirstCoroutineActivity : AppCompatActivity() {

    private lateinit var downloadBigFileButton: Button
    private lateinit var increaseCounterButton: Button
    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_first_coroutine)

        var count = 0

        downloadBigFileButton = findViewById(R.id.downloadBigFileButton)
        increaseCounterButton = findViewById(R.id.increaseCounterButton)
        counterTextView = findViewById(R.id.counterTextView)

        downloadBigFileButton.setOnClickListener {

//            GlobalScope.launch(Dispatchers.IO) {
//                downloadBigFile()
//            }

            CoroutineScope(Dispatchers.IO).launch {
                downloadBigFile()
            }

        }

        increaseCounterButton.setOnClickListener {
            counterTextView.text = count++.toString()
        }

    }

    fun downloadBigFile() {
        for (i in 1..100000) {
            Log.i("downloadingBigFile", "Downloading $i in ${Thread.currentThread()}")
        }
    }
}