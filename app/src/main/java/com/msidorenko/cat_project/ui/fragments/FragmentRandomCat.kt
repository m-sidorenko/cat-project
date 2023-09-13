package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentRandomBinding
import com.msidorenko.cat_project.ui.CatActivity
import com.msidorenko.cat_project.ui.CatViewModel


class FragmentRandomCat : Fragment(R.layout.fragment_random) {
    private lateinit var binding: FragmentRandomBinding
    private lateinit var viewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatActivity).catActivityViewModel

        binding = FragmentRandomBinding.bind(view)

        binding.fabFragmentRandomCat.setOnClickListener {
            /*CoroutineScope(Dispatchers.IO).launch {
                val a = viewModel.getAllLiked().value
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(
                        view.context, a.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }*/

            /*if (!viewModel.breedList.value.isNullOrEmpty()) {
                val listSize = viewModel.breedList.value?.size
                if (listSize != null) {
                    viewModel.randomCatNumber.postValue((0 until listSize).random())
                }
            }*/
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
        return inflater.inflate(R.layout.fragment_random, container, false)
    }
}