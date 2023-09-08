package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentBreedInfoBinding
import com.msidorenko.cat_project.ui.CatViewModel
import com.msidorenko.cat_project.ui.CatActivity

class FragmentBreedInfo : Fragment(R.layout.fragment_breed_info) {
    private lateinit var binding: FragmentBreedInfoBinding
    private lateinit var viewModel: CatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatActivity).catActivityViewModel
        binding = FragmentBreedInfoBinding.bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random, container, false)
    }
}