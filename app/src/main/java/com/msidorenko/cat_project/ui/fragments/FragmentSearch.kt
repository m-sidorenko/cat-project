package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.adapters.AdapterSearch
import com.msidorenko.cat_project.databinding.FragmentSearchBinding
import com.msidorenko.cat_project.ui.CatActivity
import com.msidorenko.cat_project.ui.CatViewModel

class FragmentSearch : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: CatViewModel

    private val searchAdapter = AdapterSearch()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatActivity).catActivityViewModel
        binding = FragmentSearchBinding.bind(view)
        setupRV(view)

        viewModel.breedList.observe(viewLifecycleOwner, Observer {
            searchAdapter.addItems(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    private fun setupRV(view: View) {
        searchAdapter.setOnItemClickListener { breedInfo ->
            val bundle = Bundle()
            bundle.putSerializable("breed", breedInfo)
            findNavController().navigate(R.id.action_fragmentSearch_to_fragmentBreedInfo, bundle)
        }

        binding.rvSearch.apply {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(view.context)
        }
    }
}