package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNavigationDrawerApp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.google.android.material.navigation.NavigationView

class KotlinNavigationDrawer : AppCompatActivity() {
    
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_navigation_drawer)
        
        val drawerLayout:DrawerLayout = findViewById(R.id.mainDrawerLayout)
        
        
        toggle = ActionBarDrawerToggle(
            this@KotlinNavigationDrawer, drawerLayout,R.string.oneNavigationDrawer, R.string.closeNavigationDrawer 
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { 
            it.isChecked = true
            when(it.itemId){
                R.id.homePage -> {
                    Toast.makeText(applicationContext, "Home Page", Toast.LENGTH_SHORT).show()
                }
                R.id.messagePage -> {
                    Toast.makeText(applicationContext, "Message Page", Toast.LENGTH_SHORT).show()
                }
                R.id.settings -> {
                    Toast.makeText(applicationContext, "Settings Page", Toast.LENGTH_SHORT).show()
                }
                R.id.login -> {
                    Toast.makeText(applicationContext, "Login Page", Toast.LENGTH_SHORT).show()
                }

                else -> {

                }
            }
            true
        }
        
        
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    
}