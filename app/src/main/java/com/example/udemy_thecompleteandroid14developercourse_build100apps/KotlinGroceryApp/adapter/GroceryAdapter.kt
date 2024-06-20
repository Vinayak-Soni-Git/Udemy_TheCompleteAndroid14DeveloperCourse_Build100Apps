package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinGroceryApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinGroceryApp.model.Grocery
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class GroceryAdapter(val groceryList: ArrayList<Grocery>):RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {
    
    inner class GroceryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var groceryImage:ImageView = itemView.findViewById(R.id.groceryImageView)
        var groceryName:TextView = itemView.findViewById(R.id.groceryNameTextView)
        var groceryDesc:TextView = itemView.findViewById(R.id.groceryDescTextView)
        
        init {
            itemView.setOnClickListener{
                Toast.makeText(itemView.context, "You choose: ${groceryList[adapterPosition].name}", Toast.LENGTH_SHORT).show()
            }
        }
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.grocery_item_layout, parent, false)
        return GroceryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return groceryList.size
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val currentGroceryItem:Grocery = groceryList[position]
        holder.groceryName.text = currentGroceryItem.name
        holder.groceryDesc.text = currentGroceryItem.desc
        holder.groceryImage.setImageResource(currentGroceryItem.image)
        
    }
}