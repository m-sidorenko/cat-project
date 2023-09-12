package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.adapters.AdapterSearch
import com.msidorenko.cat_project.databinding.FragmentLikedBinding
import com.msidorenko.cat_project.ui.CatActivity
import com.msidorenko.cat_project.ui.CatViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentLiked : Fragment(R.layout.fragment_liked) {
    private lateinit var binding: FragmentLikedBinding
    private lateinit var viewModel: CatViewModel

    private val searchAdapter = AdapterSearch()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatActivity).catActivityViewModel
        binding = FragmentLikedBinding.bind(view)
        setupRV(view)

        binding.btnClearLiked.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                viewModel.deleteAllLiked()
            }
        }

        viewModel.breedList.observe(viewLifecycleOwner, Observer {
            searchAdapter.addItems(it)
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liked, container, false)
    }

    private fun setupRV(view: View){
        searchAdapter.setOnItemClickListener { breedNumber ->
            val bundle = Bundle()
            bundle.putInt("breedNumber", breedNumber)
            findNavController().navigate(R.id.action_fragmentLiked_to_fragmentBreedInfo, bundle)
        }

        binding.rvLiked.apply {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(view.context)
        }
    }
}