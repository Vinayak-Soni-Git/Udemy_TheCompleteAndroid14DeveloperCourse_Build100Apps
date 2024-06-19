package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.fragments.NotesHomeFragmentDirections
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.models.Note
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.NoteItemLayoutBinding
import kotlin.random.Random

class NoteAdapter:RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    
    class NoteViewHolder(val itemBinding: NoteItemLayoutBinding):RecyclerView.ViewHolder(itemBinding.root)
        
        private val differCallBack = object: DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id && 
                        oldItem.body == newItem.body &&
                        oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }
        }
        
        val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.itemBinding.noteTitleTextView.text = currentNote.title
        holder.itemBinding.noteBodyTextView.text = currentNote.body
        
        
        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(156))
        holder.itemBinding.colorView.setBackgroundColor(color)
        holder.itemView.setOnClickListener{
            val direction = NotesHomeFragmentDirections.actionNotesHomeFragmentToUpdateNoteFragment(currentNote)
            it.findNavController().navigate(direction)
        }
    }

}