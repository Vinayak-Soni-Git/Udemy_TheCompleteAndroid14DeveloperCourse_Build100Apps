package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.models.JournalUser
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityKotlinJournalAppBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class KotlinJournalApp : AppCompatActivity() {
    
    private lateinit var binding: ActivityKotlinJournalAppBinding
    
    private lateinit var auth:FirebaseAuth
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_journal_app)
        binding = ActivityKotlinJournalAppBinding.inflate(layoutInflater)
        
        binding.createAccountButton.setOnClickListener{
            val intent = Intent(this, KotlinSignUp::class.java)
            startActivity(intent)
        }
        
        binding.signInButton.setOnClickListener{
            loginWithEmailAndPassword(binding.email.text.toString().trim(), binding.password.text.toString().trim()) 
        }
        
        auth = Firebase.auth
        
    }

    private fun loginWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful) {
                    val journal:JournalUser = JournalUser.instance!!
                    journal.userId = auth.currentUser?.uid
                    journal.userName = auth.currentUser?.displayName
                    goToJournals()
                }else {
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            goToJournals()
        }
    }

    private fun goToJournals() {
        val intent = Intent(this, KotlinJournalsActivity::class.java)
        startActivity(intent)
    }
}