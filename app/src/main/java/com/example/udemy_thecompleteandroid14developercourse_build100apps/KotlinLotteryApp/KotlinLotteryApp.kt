package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinLotteryApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class KotlinLotteryApp : AppCompatActivity() {
    
    private lateinit var editText:EditText
    private lateinit var generateButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_lottery_app)
        
        editText = findViewById(R.id.nameEditText)
        generateButton = findViewById(R.id.generateLotteryNumberButton)
        
        generateButton.setOnClickListener{
            val name = editText.text.toString()
            
            val intent = Intent(this, KotlinLotterySA::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
            
        }
        
    }
}