package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinSportsApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class KotlinSportsApp : AppCompatActivity() {
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_sports_app)
        
        val recyclerView:RecyclerView = findViewById(R.id.sportsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        
        
        val sportList:ArrayList<SportModel> = ArrayList()

        val sport1 = SportModel(R.drawable.football, "Football")
        val sport2 = SportModel(R.drawable.basketball, "Basketball")
        val sport3 = SportModel(R.drawable.ping, "Ping Pong")
        val sport4 = SportModel(R.drawable.tennis, "Tennis")
        val sport5 = SportModel(R.drawable.volley, "Volleyball")

        sportList.add(sport1)
        sportList.add(sport2)
        sportList.add(sport3)
        sportList.add(sport4)
        sportList.add(sport5)
        
        val adapter = SportsAdapter(sportList)
        recyclerView.adapter = adapter
        
        
    }
}