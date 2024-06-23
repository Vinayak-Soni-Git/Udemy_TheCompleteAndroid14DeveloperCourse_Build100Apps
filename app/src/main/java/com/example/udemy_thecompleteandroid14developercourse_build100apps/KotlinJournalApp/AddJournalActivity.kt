package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.models.Journal
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.models.JournalUser
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityAddJournal2Binding
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.Date

class AddJournalActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityAddJournal2Binding
    var currentUserId:String = ""
    var currentUserName:String = ""
    
    lateinit var auth:FirebaseAuth
    lateinit var user:FirebaseUser
    
    var db:FirebaseFirestore = FirebaseFirestore.getInstance()
    lateinit var storageReference: StorageReference
    
    var collectionReference: CollectionReference = db.collection("Journal")
    lateinit var imageUri:Uri
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_journal2)
        binding = ActivityAddJournal2Binding.inflate(layoutInflater)
        
        storageReference = FirebaseStorage.getInstance().getReference()
        
        auth = Firebase.auth    
        binding.apply { 
            postProgressBar.visibility = View.VISIBLE
            if(JournalUser.instance != null){
//                currentUserId = JournalUser.instance!!.userId.toString()
//                currentUserName = JournalUser.instance!!.userName.toString()
                currentUserId = auth.currentUser?.uid.toString()
                currentUserName = auth.currentUser?.displayName.toString()
                postUserName.text = currentUserName
                
            }
            savePostButton.setOnClickListener{
                saveJournal()
            }
        }
        
        binding.postCameraButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, 1)
            
        }
       
        
    }

    private fun saveJournal() {
        var title:String = binding.postTitle.text.toString().trim()
        var thoughts:String = binding.postDescription.text.toString().trim()
        
        binding.postProgressBar.visibility = View.VISIBLE
        
        if(title.isNotEmpty() && thoughts.isNotEmpty() && imageUri != null){
            val filePath:StorageReference = storageReference
                .child("journal_images")
                .child("my_image_"+ Timestamp.now().seconds)

            filePath.putFile(imageUri).addOnSuccessListener { 
                filePath.downloadUrl.addOnSuccessListener { 
                    var imageUri:String = it.toString()
                    
                    val timeStamp:Timestamp = Timestamp(Date())
                    
                    var journal:Journal = Journal(title, thoughts,imageUri, currentUserId ,timeStamp, currentUserName)
                    
                    collectionReference.add(journal).addOnSuccessListener { 
                        binding.postProgressBar.visibility = View.VISIBLE
                        var intent = Intent(this, KotlinJournalsActivity::class.java)
                        startActivity(intent)
                        finish()
                    }.addOnFailureListener{
                        binding.postProgressBar.visibility = View.INVISIBLE
                    }
                }
            }
        } else {
            binding.postProgressBar.visibility = View.VISIBLE
        }
        
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK){
            if (data != null){
                imageUri = data.data!!
                binding.postImage.setImageURI(imageUri)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        user = auth.currentUser!!
        
    }

    override fun onStop() {
        super.onStop()
        if (auth != null){
            
        }
    }
}