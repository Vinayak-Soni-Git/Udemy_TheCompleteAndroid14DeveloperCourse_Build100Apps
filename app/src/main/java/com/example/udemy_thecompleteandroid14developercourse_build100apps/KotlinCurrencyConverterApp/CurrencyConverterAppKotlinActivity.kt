package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinCurrencyConverterApp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class CurrencyConverterAppKotlinActivity : AppCompatActivity() {
    
    private lateinit var usdEditText:EditText
    private lateinit var convertResultTextView:TextView
    private lateinit var convertButton:Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currenry_converter_app_kotlin)
        
        usdEditText = findViewById(R.id.USDEditText)
        convertResultTextView = findViewById(R.id.convertResultTextView)
        convertButton = findViewById(R.id.convertButton)
        
        convertButton.setOnClickListener { 
            val usdText = usdEditText.text.toString()
            val usdDouble = usdText.toDouble()
            val euros = makeConversion(usdDouble)
            convertResultTextView.text = euros.toString()
        }
    }
    
    private fun makeConversion(usd:Double):Double{
        return usd*0.94
    }
}