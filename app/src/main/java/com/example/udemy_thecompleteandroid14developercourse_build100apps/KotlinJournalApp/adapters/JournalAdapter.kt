package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinJournalApp.models.Journal
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R

class JournalAdapter(val context:Context, val journalList:MutableList<Journal>):RecyclerView.Adapter<JournalAdapter.JournalViewHolder>() {
    
    inner class JournalViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        
        fun bind(journal:Journal){
            
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.journal_row, parent, false)
        return JournalViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        val journal:Journal = journalList[position]
        holder.bind(journal)
    }
}