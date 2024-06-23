package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinSportsApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class SportsAdapter(val sportList:ArrayList<SportModel>):RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {
    
    inner class SportsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var sportImage: ImageView
        var sportName:TextView
        init {
            sportImage = itemView.findViewById(R.id.sportImage)
            sportName = itemView.findViewById(R.id.sportText)
            
            
            itemView.setOnClickListener{
                Toast.makeText(itemView.context, "You clicked: ${sportList[adapterPosition].sportName}", Toast.LENGTH_SHORT).show()
            }
            
        }
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)
        return SportsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        holder.sportImage.setImageResource(sportList[position].sportImage)
        holder.sportName.text = sportList[position].sportName
        
    }
}