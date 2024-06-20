package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinFirebaseCloudStorage

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinFirebaseCloudStorage.models.User
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class KotlinCloudStorage : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_cloud_storage)
        val textView :TextView = findViewById(R.id.cloudStorageValueTextView)
        // Real time database reference
        database = Firebase.database.reference
        
        // Writing data to firebase
        database.child("GoldPrice").setValue("1920 $")
        
        // Reading data from firebase
        val postListener = object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val goldPrice = snapshot.value
                textView.text = goldPrice.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                
            }

        }
        database.child("price").addValueEventListener(postListener)
        
        // Writing custom objects to firebase
        val user1 = User("Jack", "1234")
        database.child("Users").setValue(user1)
        
        // Reading custom objects to firebase
        val pe = object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val u1 = snapshot.getValue<User>()
                textView.text = u1.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                
            }
            
        }
        database.child("Users").addValueEventListener(pe)
    }
}