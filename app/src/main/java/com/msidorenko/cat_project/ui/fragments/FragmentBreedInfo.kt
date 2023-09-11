package com.msidorenko.cat_project.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.FragmentBreedInfoBinding
import com.msidorenko.cat_project.retrofit.RetrofitClient
import com.msidorenko.cat_project.retrofit.api.CAT_BASE_URL
import com.msidorenko.cat_project.retrofit.api.CatApiService
import com.msidorenko.cat_project.ui.CatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentBreedInfo : Fragment(R.layout.fragment_breed_info) {
    private val args: FragmentBreedInfoArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = (activity as CatActivity).catActivityViewModel
        val binding = FragmentBreedInfoBinding.bind(view)

        val currentBreedInformation = viewModel.breedsList.value?.get(args.breedNumber)
        if (currentBreedInformation != null) {
            binding.apply {
                tvNameBreedInfo.text = currentBreedInformation.name
                tvWeightBreedInfo.text = currentBreedInformation.weight!!.metric
                tvOriginBreedInfo.text = currentBreedInformation.origin
                tvDescriptionBreedInfo.text = currentBreedInformation.description

                btnLikeBreedInfo.setOnClickListener {
                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.likeBreed(currentBreedInformation)
                    }
                }

                // --------- BTN
                val bundle = Bundle()
                val urlList = listOf(
                    currentBreedInformation.cfaUrl,
                    currentBreedInformation.vetstreetUrl,
                    currentBreedInformation.wikipediaUrl,
                    currentBreedInformation.vcahospitalsUrl
                )
                urlList.forEach { link ->
                    if (!link.isNullOrEmpty()) {
                        bundle.putString("url", link)
                        btnOpenWeb.isEnabled = true
                        return@forEach
                    }
                }
                btnOpenWeb.setOnClickListener {
                    findNavController().navigate(R.id.fragmentWebView, bundle)
                }

                // --------- IMAGE
                val retrofit =
                    RetrofitClient.getClient(CAT_BASE_URL).create(CatApiService::class.java)

                lifecycleScope.launch {
                    val referenceImageId = currentBreedInformation.referenceImageId
                    if (referenceImageId != null) {
                        val result = retrofit.getImageById(referenceImageId)

                        if (result.isSuccessful) {
                            val url = result.body()?.url
                            if (url != null) {
                                Glide.with(view.context).load(url).into(binding.ivBreedInfo)
                            }
                        } else {
                            Glide.with(view.context).load(R.drawable.fish_24)
                                .into(binding.ivBreedInfo)
                            Log.e("myTag", "retrofit.getImageById isn't successful")
                        }
                    } else {
                        Glide.with(view.context).load(R.drawable.fish_24).into(binding.ivBreedInfo)
                        Log.e("myTag", "result are not successful")
                    }
                }
            }

        }

        // TODO: РАБОТУ С ПОДПИСКОЙ НА ЗНАЧЕНИЕ УБРАТЬ И ПЕРЕНЕСТИ В randomCat И ПЕРЕДЕДАТЬ

        /*var job: Job? = null
        viewModel.randomCatNumber.observe(viewLifecycleOwner, Observer { number ->
            Log.i("myTag", "Update random numb. New value is: $number")
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
                                        .into(binding.ivBreedInfo)
                                } else {
                                    Log.e("myTag", "empty image list")
                                }
                            } else {
                                Log.e("myTag", "result are not successful")
                            }
                        }
                    }

                    tvNameBreedInfo.text = currentItem.name
                    tvCountryBreedInfo.text = currentItem.origin

                    tvWeightBreedInfo.text = if (currentItem.weight != null) {
                        currentItem.weight.metric + " kg"
                    } else {
                        "unknown weight"
                    }

                    tvDescriptionBreedInfo.text = currentItem.description
                }
            }
        })*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_info, container, false)
    }
}