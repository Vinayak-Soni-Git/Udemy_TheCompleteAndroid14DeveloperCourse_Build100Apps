package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinVolumeCalculatorApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinVolumeCalculatorApp.models.Shape
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class ShapeAdapter(context:Context, private val shapeList:List<Shape>)
    :ArrayAdapter<Shape>(context, 0, shapeList) {
        
        private class ShapeViewHolder{
            lateinit var shapeImageView:ImageView
            lateinit var shapeName:TextView
            
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        val holder:ShapeViewHolder
        if (convertView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false)
            
            holder = ShapeViewHolder()
            holder.shapeImageView = itemView.findViewById(R.id.shapeImage)
            holder.shapeName = itemView.findViewById(R.id.shapeName)
            
            itemView.tag = holder
        }else {
            holder = itemView?.tag as ShapeViewHolder
        }
        
        val currentItem = shapeList[position]
        holder.shapeImageView.setImageResource(currentItem.shapeImage)
        holder.shapeName.text = currentItem.shapeName
        return itemView!!
    }
}