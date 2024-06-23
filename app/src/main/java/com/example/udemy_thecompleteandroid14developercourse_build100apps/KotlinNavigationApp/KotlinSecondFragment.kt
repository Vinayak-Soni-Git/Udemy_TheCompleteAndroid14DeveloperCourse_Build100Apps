package com.example.udemy_thecompleteandroid14developercourse_build100apps.KotlinNavigationApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.FragmentKotlinSecondBinding


class KotlinSecondFragment : Fragment() {
    
    private lateinit var binding: FragmentKotlinSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kotlin_second, container, false)
        var input = requireArguments().getString("name")
        binding.kotlinSecondfragmentTextView.text = input.toString()
        return binding.root
    }

}