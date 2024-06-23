package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNavigationApp

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.FragmentKotlinHomeBinding

class KotlinHomeFragment : Fragment() {
    private lateinit var binding: FragmentKotlinHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kotlin_home, container, false)
        
        
        binding.submitButton.setOnClickListener{
            if (!TextUtils.isEmpty(binding.nameEditText.text.toString())){
                val bundle = bundleOf("name" to binding.nameEditText.text.toString())
                it.findNavController().navigate(R.id.action_kotlinHomeFragment_to_kotlinSecondFragment, bundle)
            }else{
                Toast.makeText(activity, "Enter your name", Toast.LENGTH_SHORT).show()
            }
        }
        
        return binding.root
    }

}