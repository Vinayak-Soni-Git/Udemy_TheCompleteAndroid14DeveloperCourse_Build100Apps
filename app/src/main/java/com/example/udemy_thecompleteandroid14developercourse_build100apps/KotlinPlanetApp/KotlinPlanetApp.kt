package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinPlanetApp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinPlanetApp.adapter.PlanetAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinPlanetApp.models.Planet
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class KotlinPlanetApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kolint_planet_app)
        
        val planetListView:ListView = findViewById(R.id.planetListView)
        
        val planet1 = Planet("Mercury", "0", R.drawable.mercury)
        val planet2 = Planet("Venus", "0", R.drawable.venus)
        val planet3 = Planet("Earth", "1", R.drawable.earth)
        val planet4 = Planet("Mars", "2", R.drawable.mars)
        val planet5 = Planet("Jupiter", "79", R.drawable.jupiter)
        val planet6 = Planet("Saturn", "83", R.drawable.saturn)
        val planet7 = Planet("Uranus", "27", R.drawable.uranus)
        val planet8 = Planet("Neptune", "14", R.drawable.neptune)
        
        val planetList = ArrayList<Planet>()

        planetList.add(planet1)
        planetList.add(planet2)
        planetList.add(planet3)
        planetList.add(planet4)
        planetList.add(planet5)
        planetList.add(planet6)
        planetList.add(planet7)
        planetList.add(planet8)
        
        val adapter = PlanetAdapter(this, planetList)
        planetListView.adapter = adapter
    }
}