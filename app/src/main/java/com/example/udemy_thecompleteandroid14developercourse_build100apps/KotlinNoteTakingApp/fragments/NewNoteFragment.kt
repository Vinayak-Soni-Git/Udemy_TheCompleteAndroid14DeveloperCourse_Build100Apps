package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.MainNoteTakingAppActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.adapter.NoteAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.models.Note
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.viewmodel.NoteViewModel
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.FragmentNewNoteBinding

class NewNoteFragment : Fragment() {
    
    private var _binding :FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var mView:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = (activity as MainNoteTakingAppActivity).noteViewModel
        mView = view
    }
    private fun saveNote(view:View){
        val title = binding.noteTitleEditText.text.toString().trim()
        val body = binding.noteBodyEditText.text.toString().trim()
        
        if (title.isNotEmpty()){
            val note = Note(0, title, body)
            noteViewModel.addNote(note)
            
            Toast.makeText(requireContext(), "Note saved successfully", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_newNoteFragment_to_notesHomeFragment)
        } else {
            Toast.makeText(requireContext(), "Please enter your title", Toast.LENGTH_SHORT).show()
        }
        
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.new_note_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuSave -> {
                saveNote(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}