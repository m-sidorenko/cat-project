package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.transition.Transition
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.findFragment
import androidx.lifecycle.Observer
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentRandomCatBinding
import com.msidorenko.cat_project.retrofit.api.models.RandomCat
import com.msidorenko.cat_project.ui.ActivityViewModel
import com.msidorenko.cat_project.ui.MainActivity

class FragmentRandomCat : Fragment(R.layout.fragment_random_cat) {
    private lateinit var binding: FragmentRandomCatBinding
    private lateinit var viewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainActivityViewModel
        binding = FragmentRandomCatBinding.bind(view)

        binding.fabFragmentRandomCat.setOnClickListener {
            if (!viewModel.breedsList.value.isNullOrEmpty()) {
                viewModel.randomCatNumber.postValue(
                    (0..viewModel.breedsList.value!!.size).random()
                )
            }
        }

        viewModel.randomCatNumber.observe(viewLifecycleOwner, Observer { number ->
            Log.i("myTag", "Update random numb. New value is: $number")

            val currentItem = viewModel.breedsList.value?.get(number)
            if (currentItem != null){
                binding.apply {
                    tvBreedName.text = currentItem.name
                    tvContryOrigin.text = currentItem.origin
                    tvWeight.text = currentItem.weight?.metric ?: "unknown weight"
                    tvDescription.text = currentItem.description
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_cat, container, false)
    }
}