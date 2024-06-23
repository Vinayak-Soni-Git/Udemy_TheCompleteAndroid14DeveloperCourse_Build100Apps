package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinPlanetApp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinPlanetApp.models.Planet
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class PlanetAdapter (val context:Context,val planetList: List<Planet>):BaseAdapter() {
    override fun getCount(): Int {
        return planetList.size
    }

    override fun getItem(position: Int): Any {
        return planetList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        
        val view:View
        if(convertView == null){
            view = inflater.inflate(R.layout.planet_item_layout, parent, false)
        } else {
            view = convertView
        }
        val item = getItem(position) as Planet
        
        val titleTextView = view.findViewById<TextView>(R.id.planetTextView)
        val moonCountTextView = view.findViewById<TextView>(R.id.moonCountTextView)
        val moonImage = view.findViewById<ImageView>(R.id.planetImageView)

        titleTextView.text = item.title
        moonCountTextView.text = item.moonCount
        moonImage.setImageResource(item.planetImage)
        
        view.setOnClickListener{
            Toast.makeText(context, "You clicked: ${planetList[position].title}", Toast.LENGTH_SHORT).show()
        }
        
        return view

    }


}