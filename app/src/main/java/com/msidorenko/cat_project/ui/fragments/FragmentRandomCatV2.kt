package com.msidorenko.cat_project.ui.fragments

import android.os.BaseBundle
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentRandomV2Binding
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import com.msidorenko.cat_project.ui.CatActivity
import com.msidorenko.cat_project.ui.CatViewModel
import kotlinx.coroutines.Job


class FragmentRandomCatV2 : Fragment(R.layout.fragment_random_v2) {
    private lateinit var binding: FragmentRandomV2Binding
    private lateinit var viewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatActivity).catActivityViewModel

        binding = FragmentRandomV2Binding.bind(view)

//        val fragmentBreedInfo= FragmentBreedInfo()
//        val ft = childFragmentManager.beginTransaction()
//        fragmentBreedInfo.arguments = Bundle().apply { putInt("breedNumber", viewModel.randomCatNumber.value!!.toInt()) }
//        ft.replace(R.id.fragmentContainer_fragmentRandom, fragmentBreedInfo)
//        ft.commit()

        binding.fabFragmentRandomCat.setOnClickListener {
            if (!viewModel.breedsList.value.isNullOrEmpty()) {
                val listSize = viewModel.breedsList.value?.size
                if (listSize != null) {
                    viewModel.randomCatNumber.postValue((0 until listSize).random())
                }
            }
        }
    }

    private fun showLoading() {
//        binding.apply {
//            progressBar.isVisible = true
////            tvBreedName.isVisible = false
////            tvContryOrigin.isVisible = false
////            tvWeight.isVisible = false
////            tvDescription.isVisible = false
////            textView.isVisible = false
////            textView2.isVisible = false
////            textView3.isVisible = false
////            textView4.isVisible = false
//        }
    }

    private fun hideLoading() {
        binding.apply {
            progressBar.isVisible = false
//            tvBreedName.isVisible = true
//            tvContryOrigin.isVisible = true
//            tvWeight.isVisible = true
//            tvDescription.isVisible = true
//            textView.isVisible = true
//            textView2.isVisible = true
//            textView3.isVisible = true
//            textView4.isVisible = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_v2, container, false)
    }
}