package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinVolumeCalculatorApp

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinVolumeCalculatorApp.adapters.ShapeAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinVolumeCalculatorApp.models.Shape
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class KotlinVolumeCalculatorApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_volume_calculator_app)
        
        val gridView:GridView = findViewById(R.id.volumeGridView)
        
        val shape1 = Shape(R.drawable.sphere, "Sphere")
        val shape2 = Shape(R.drawable.cube, "Cube")
        val shape3 = Shape(R.drawable.prism, "Prism")
        val shape4 = Shape(R.drawable.cylinder, "Cylinder")
        
        val gridItems = listOf(shape1, shape2, shape3, shape4)
        
        val customAdapter = ShapeAdapter(this, gridItems)
        gridView.adapter = customAdapter
        
        
        gridView.setOnItemClickListener{_,_,position,_->
            val clickedItem = customAdapter.getItem(position)
            if (clickedItem?.shapeName.equals("Sphere")){
                val intent = Intent(this, KotlinSphereActivity::class.java)
                startActivity(intent)
            }
        }
    }
}   