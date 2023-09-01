package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentRandomCatBinding
import com.msidorenko.cat_project.retrofit.RetrofitClient
import com.msidorenko.cat_project.retrofit.api.CAT_BASE_URL
import com.msidorenko.cat_project.retrofit.api.CatApiService
import com.msidorenko.cat_project.ui.ActivityViewModel
import com.msidorenko.CatActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentRandomCat : Fragment(R.layout.fragment_random_cat) {
    private lateinit var binding: FragmentRandomCatBinding
    private lateinit var viewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatActivity).catActivityViewModel
        binding = FragmentRandomCatBinding.bind(view)

        showLoading()

        binding.fabFragmentRandomCat.setOnClickListener {
            if (!viewModel.breedsList.value.isNullOrEmpty()) {
                val listSize = viewModel.breedsList.value?.size
                if (listSize != null) {
                    viewModel.randomCatNumber.postValue((0 until listSize).random())
                }
            }
        }

        var job: Job? = null
        viewModel.randomCatNumber.observe(viewLifecycleOwner, Observer { number ->
            Log.i("myTag", "Update random numb. New value is: $number")
            hideLoading()

            val currentItem = viewModel.breedsList.value?.get(number)

            if (currentItem != null) {
                binding.apply {

                    job?.cancel()
                    job = lifecycleScope.launch {
                        delay(150)
                        val retrofit =
                            RetrofitClient.getClient(CAT_BASE_URL).create(CatApiService::class.java)

                        if (!currentItem.id.isNullOrEmpty()) {
                            val result = retrofit.getImageByBreedId(currentItem.id)

                            if (result.isSuccessful) {
                                val image = result.body()
                                Log.e("myTag", "imageBody:$image")

                                if (image?.get(0) != null) {
                                    Glide.with(view.context).load(image[0].url)
                                        .into(binding.imageView)
                                } else {
                                    Log.e("myTag", "empty image list")
                                }
                            } else {
                                Log.e("myTag", "result are not successful")
                            }
                        }
                    }

                    tvBreedName.text = currentItem.name
                    tvContryOrigin.text = currentItem.origin

                    tvWeight.text = if (currentItem.weight != null) {
                        currentItem.weight.metric + " kg"
                    } else {
                        "unknown weight"
                    }

                    tvDescription.text = currentItem.description
                }
            }
        })
    }

    private fun showLoading() {
        binding.apply {
            progressBar.isVisible = true
            tvBreedName.isVisible = false
            tvContryOrigin.isVisible = false
            tvWeight.isVisible = false
            tvDescription.isVisible = false
            textView.isVisible = false
            textView2.isVisible = false
            textView3.isVisible = false
            textView4.isVisible = false
        }
    }

    private fun hideLoading() {
        binding.apply {
            progressBar.isVisible = false
            tvBreedName.isVisible = true
            tvContryOrigin.isVisible = true
            tvWeight.isVisible = true
            tvDescription.isVisible = true
            textView.isVisible = true
            textView2.isVisible = true
            textView3.isVisible = true
            textView4.isVisible = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_cat, container, false)
    }
}