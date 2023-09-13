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
import com.msidorenko.cat_project.adapters.AdapterLiked
import com.msidorenko.cat_project.databinding.FragmentLikedBinding
import com.msidorenko.cat_project.ui.CatActivity
import com.msidorenko.cat_project.ui.CatViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentLiked : Fragment(R.layout.fragment_liked) {
    private lateinit var binding: FragmentLikedBinding
    private lateinit var viewModel: CatViewModel

    private val adapterLiked = AdapterLiked()

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

        viewModel.getAllLiked().observe(viewLifecycleOwner, Observer {
            adapterLiked.addItems(it)
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
        adapterLiked.setOnItemClickListener { breedNumber ->
            val bundle = Bundle()
            bundle.putSerializable("breed", breedNumber)
            findNavController().navigate(R.id.action_fragmentLiked_to_fragmentBreedInfo, bundle)
        }

        binding.rvLiked.apply {
            adapter = adapterLiked
            layoutManager = LinearLayoutManager(view.context)
        }
    }
}