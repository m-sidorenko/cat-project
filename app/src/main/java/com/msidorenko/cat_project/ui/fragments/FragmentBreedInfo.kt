package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentBreedInfoPageBinding
import com.msidorenko.cat_project.ui.ActivityViewModel
import com.msidorenko.cat_project.ui.MainActivity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class FragmentBreedInfo : Fragment(R.layout.fragment_breed_info_page) {
    private lateinit var binding: FragmentBreedInfoPageBinding
    private lateinit var viewModel: ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainActivityViewModel
        binding = FragmentBreedInfoPageBinding.bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_cat, container, false)
    }
}