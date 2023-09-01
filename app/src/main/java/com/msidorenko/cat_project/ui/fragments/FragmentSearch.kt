package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.adapters.AdapterSearchBreed
import com.msidorenko.cat_project.databinding.FragmentSearchBinding
import com.msidorenko.cat_project.ui.ActivityViewModel
import com.msidorenko.cat_project.CatActivity

class FragmentSearch : Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: ActivityViewModel
    private val searchAdapter by lazy{ AdapterSearchBreed() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatActivity).catActivityViewModel
        binding = FragmentSearchBinding.bind(view)

        binding.rvFragmentSearch.apply {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(view.context)

        }

        viewModel.breedsList.observe(viewLifecycleOwner, Observer {
            searchAdapter.dataList = it
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}