package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinMastringRoomDatabase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainMasteringRoomActivity : AppCompatActivity() {
    
    
    lateinit var itemNameEt:EditText
    lateinit var itemPriceEt:EditText
    lateinit var itemQuantity:EditText
    lateinit var recordsTv:TextView
    lateinit var addItemButton:Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mastering_room)
        
        itemNameEt = findViewById(R.id.itemName)
        itemPriceEt = findViewById(R.id.itemPrice)
        itemQuantity = findViewById(R.id.itemQuantity)
        recordsTv = findViewById(R.id.recordsTv)
        addItemButton = findViewById(R.id.addItemButton)
        
        
        addItemButton.setOnClickListener{
            val name = itemNameEt.text.toString()
            val price = itemPriceEt.text.toString()
            val quantity = itemQuantity.text.toString()

            val doublePrice = price.toDouble()
            val intQuantity = quantity.toInt()

            val db = ItemDatabase.getDatabase(applicationContext)
            val dao = db.itemDao()
            var item:Item = Item(0, name, doublePrice, intQuantity)
            
            CoroutineScope(Dispatchers.IO).launch {
                dao.insertItem(item)
                
            }
            
        }
    }
    
    fun displayAllRecords(){
        val db = ItemDatabase.getDatabase(applicationContext)
        val dao = db.itemDao()
        dao.getAllItemsInDB().observe(this, {
            var result = ""
            for(item in it){
                result = it.joinToString("\n")
            }
            recordsTv.text = result
        })
    }
}