package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinFireStoreWithAndroid

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class KotlinFireStore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_firestore)
        
        val textView:TextView = findViewById(R.id.textViewFireStore)
        
        // Initialize FireStore
        val db = Firebase.firestore
        
        // Creating a collection: "Users"
        val userCollection = db.collection("Users")
        
        // Creating documents
        val user1 = hashMapOf("name" to "jack", "lastName" to "reacher", "born" to "1992")
        val user2 = hashMapOf("name" to "john", "lastName" to "wick", "born" to "1982")
        
        userCollection.document("user1").set(user1)
        userCollection.document("user2").set(user2)
        
        // Receiving documents from firestore
        val documentRef = db.collection("Users").document("user1")
        
        documentRef.get().addOnSuccessListener {document ->
            if (document != null){
                textView.text = "${document.data?.get("name")}"
            }
        }
        
        // Reading all documents from collection
        db.collection("Users").get().addOnSuccessListener { result ->
            for(document in result){
                textView.text = "${document.data}"
            }
        }
        
        // Updating and deleting document
        db.collection("Users")
            .document("user1")
            .update("born", 1998)

        db.collection("Users")
            .document("user1")
            .delete()
    }
}