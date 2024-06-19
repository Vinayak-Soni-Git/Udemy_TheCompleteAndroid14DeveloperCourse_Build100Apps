package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.MainNoteTakingAppActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.adapter.NoteAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.models.Note
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.viewmodel.NoteViewModel
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.FragmentUpdateNoteBinding

class UpdateNoteFragment : Fragment() {
    
    private var _binding : FragmentUpdateNoteBinding? = null
    private val binding get() =  _binding!!
    
    private lateinit var noteViewModel:NoteViewModel
    private lateinit var noteAdapter:NoteAdapter
    
    private lateinit var currentNote : Note
    private val args:UpdateNoteFragmentArgs by navArgs()
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) 
        noteViewModel = (activity as MainNoteTakingAppActivity).noteViewModel
        currentNote = args.note!!
        
        binding.noteTitleUpdateEditText.setText(currentNote.title)
        binding.noteBodyUpdateEditText.setText(currentNote.body)
        
        binding.updateFragmentFab.setOnClickListener{
            val title = binding.noteTitleUpdateEditText.text.toString().trim()
            val body = binding.noteBodyUpdateEditText.text.toString().trim()
            
            if (title.isNotEmpty()){
                val note = Note(currentNote.id, title, body)
                noteViewModel.updateNote(note)
                view.findNavController().navigate(R.id.action_updateNoteFragment_to_notesHomeFragment)
            } else {
                Toast.makeText(requireContext(), "Please enter your title", Toast.LENGTH_SHORT).show()
            }
        }
        
    }
    
    private fun deleteNote(){
        AlertDialog.Builder(requireContext()).apply { 
            setTitle("Delete Note")
            setMessage("You want to delete this note?")
            setPositiveButton("Delete"){_, _, ->
                noteViewModel.deleteNote(currentNote)
                view?.findNavController()?.navigate(R.id.action_updateNoteFragment_to_notesHomeFragment)
                
            }
            setNegativeButton("Cancel", null)
        }.create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.update_note_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuDelete -> {deleteNote()}
        }
        
        return super.onOptionsItemSelected(item)
        
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}