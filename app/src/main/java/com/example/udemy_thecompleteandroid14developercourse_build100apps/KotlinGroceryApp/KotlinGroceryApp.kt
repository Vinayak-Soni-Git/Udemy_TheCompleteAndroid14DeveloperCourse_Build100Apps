package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinGroceryApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinGroceryApp.adapter.GroceryAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinGroceryApp.model.Grocery
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class KotlinGroceryApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_grocery_app)
        
        val groceryRecyclerView:RecyclerView = findViewById(R.id.groceriesRecyclerView)
        groceryRecyclerView.layoutManager = LinearLayoutManager(
            this,LinearLayoutManager.VERTICAL, false)
        
        val groceryItems:ArrayList<Grocery> = ArrayList()
        
        val g1 = Grocery(R.drawable.fruit, "Fruits", "Fresh fruits from the garden")
        val g2 = Grocery(R.drawable.vegitables, "Vegetables", "Delicious Vegetables")
        val g3 = Grocery(R.drawable.bread, "Bakery", "Bread, Wheat and Beans")
        val g4 = Grocery(R.drawable.beverage, "Beverage", "Juice, Tea, Coffee")
        val g5 = Grocery(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt")
        val g6 = Grocery(R.drawable.popcorn, "Snacks", "Pop corn, Donut and drinks")

        groceryItems.add(g1)
        groceryItems.add(g2)
        groceryItems.add(g3)
        groceryItems.add(g4)
        groceryItems.add(g5)
        groceryItems.add(g6)
        
        
        val adapter = GroceryAdapter(groceryItems)
        groceryRecyclerView.adapter = adapter
    }
}