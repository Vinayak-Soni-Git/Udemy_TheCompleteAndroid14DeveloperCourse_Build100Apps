package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinLotteryApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class KotlinLotterySA : AppCompatActivity() {
    
    lateinit var generatedNumberTextView:TextView
    lateinit var shareButton:Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_lottery_sa)
        
        generatedNumberTextView = findViewById(R.id.generatedNumberTextView)
        shareButton = findViewById(R.id.shareLotteryNumberButton)
        
        val randomNumber = generateRandomNumber(6)
        generatedNumberTextView.text = randomNumber
        var userName = receiveUserName()
        
        shareButton.setOnClickListener{
            shareResult(userName, randomNumber)
        }
        
    }
    
    private fun generateRandomNumber(count:Int):String{
        val randomNumber = List(count){
            (0..42).random()
        }
        return randomNumber.joinToString(" ")
    }
    
    private fun receiveUserName():String{
        val bundle:Bundle? = intent.extras
        val userName = bundle?.getString("UserName").toString()
        return userName
    }
    
    fun shareResult(userName:String, generatedNumber:String){
        var intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_SUBJECT, "$userName generates these numbers")
        intent.putExtra(Intent.EXTRA_TEXT, "The lottery numbers are: $generatedNumber")
        startActivity(intent)
    }
}