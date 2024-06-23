package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityKotlinSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class KotlinSignUp : AppCompatActivity() {
    
    private lateinit var auth:FirebaseAuth
    private lateinit var binding:ActivityKotlinSignUpBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_sign_up)
        binding = ActivityKotlinSignUpBinding.inflate(layoutInflater)
        
        auth = Firebase.auth
        
        binding.signUpButton.setOnClickListener{
            createUser()
        }
    }

    private fun createUser() {
        val email = binding.signUpEmail.text.toString()
        val password = binding.signUpPassword.text.toString()
        
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(this@KotlinSignUp, "Authentication failed", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            reload()
        }
    }

    private fun reload() {
        
    }
}