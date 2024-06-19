package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.MainNoteTakingAppActivity
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.adapter.NoteAdapter
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.models.Note
import com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNoteTakingApp.viewmodel.NoteViewModel
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.FragmentNotesHomeBinding

class NotesHomeFragment : Fragment(R.layout.fragment_notes_home), SearchView.OnQueryTextListener {

    private var _binding:FragmentNotesHomeBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       _binding = FragmentNotesHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = (activity as MainNoteTakingAppActivity).noteViewModel
        setUpRecyclerView()
        binding.fabAddNewNote.setOnClickListener{
            it.findNavController().navigate(
                R.id.action_notesHomeFragment_to_newNoteFragment
            )
        }
    }

    private fun setUpRecyclerView() {
        noteAdapter = NoteAdapter()
        binding.notesRecyclerView.apply { 
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = noteAdapter
        }
        
        activity?.let{
            noteViewModel.getAllNotes().observe(
                viewLifecycleOwner, {
                    note -> noteAdapter.differ.submitList(note)
                    updateUI(note)
                }
            )
        }
    }

    private fun updateUI(note: List<Note>?) {
        if (note != null) {
            if(note.isNotEmpty()){
                binding.notesCardView.visibility = View.GONE
                binding.notesRecyclerView.visibility = View.VISIBLE
            } else {
                binding.notesCardView.visibility = View.VISIBLE
                binding.notesRecyclerView.visibility = View.GONE
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.notes_app_home_menu, menu)
        
        val menuSearch = menu.findItem(R.id.menuSearch).actionView as SearchView
        menuSearch.isSubmitButtonEnabled = false
        menuSearch.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        searchNote(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null){
            searchNote(newText)
        }
        return true
    }
    
    private fun searchNote(query:String?){
        val searchQuery = "%$query"
        noteViewModel.searchNote(searchQuery).observe(
            this,
            {list -> noteAdapter.differ.submitList(list)}
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}