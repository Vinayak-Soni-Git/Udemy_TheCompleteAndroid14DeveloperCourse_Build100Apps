package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.adapters.JournalAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.models.Journal
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityKotlinJournalsBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference

class KotlinJournalsActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityKotlinJournalsBinding

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var user: FirebaseUser
    var db = FirebaseFirestore.getInstance()

    lateinit var storageReference: StorageReference
    var collectionReference: CollectionReference = db.collection("Journal")

    lateinit var journalList:MutableList<Journal>
    lateinit var adapter:JournalAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_journals)
        binding = ActivityKotlinJournalsBinding.inflate(layoutInflater)

        firebaseAuth = Firebase.auth
        user = firebaseAuth.currentUser!!

        binding.journalRecyclerView.setHasFixedSize(true)
        binding.journalRecyclerView.layoutManager = LinearLayoutManager(this)
        
        journalList = arrayListOf<Journal>()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.journal_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add -> if (user != null && firebaseAuth != null){
                val intent = Intent(this, AddJournalActivity::class.java)
                startActivity(intent)
            }
            R.id.action_sign_out -> {
                if (user!=null && firebaseAuth != null){
                    firebaseAuth.signOut()
                    val intent = Intent(this, KotlinJournalApp::class.java)
                    startActivity(intent)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        collectionReference.whereEqualTo("userId", user.uid)
            .get()
            .addOnSuccessListener { 
                if (!it.isEmpty){
                    for (document in it){
                        val journal = Journal(
                            document.data.get("title").toString(),
                            document.data.get("thoughts").toString(),
                            document.data.get("imageUrl").toString(),
                            document.data.get("userId").toString(),
                            document.data.get("timeAdded") as Timestamp,
                            document.data.get("username").toString(),
                        )
                        journalList.add(journal)
                    }
                    adapter = JournalAdapter(this, journalList)
                    binding.journalRecyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                } 
            }
    }
    
}