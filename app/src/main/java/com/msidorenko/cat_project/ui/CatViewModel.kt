package com.msidorenko.cat_project.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msidorenko.cat_project.db.LikedBreed
import com.msidorenko.cat_project.repository.LikedBreedRepository
import com.msidorenko.cat_project.retrofit.RetrofitClient
import com.msidorenko.cat_project.retrofit.api.CAT_BASE_URL
import com.msidorenko.cat_project.retrofit.api.CatApiService
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatViewModel(private val repository: LikedBreedRepository) : ViewModel() {
    val breedsList: MutableLiveData<List<BreedInfo>> = MutableLiveData()
    val randomCatNumber: MutableLiveData<Int> = MutableLiveData()

    init {
        getBreeds()
    }

    fun getBreeds() {
        val retrofit = RetrofitClient.getClient(CAT_BASE_URL).create(CatApiService::class.java)
        viewModelScope.launch {
            val response = retrofit.getBreedList()

            if (response.isSuccessful) {
                println("RAW " + response.raw().body)
                response.body()?.let { listOfBreeds ->
                    breedsList.postValue(listOfBreeds)

                    if (listOfBreeds.isNotEmpty()) {
                        randomCatNumber.postValue(
                            (0..listOfBreeds.size).random()
                        )
                    }
                }
            }
        }
    }

    fun likeBreed(breed: BreedInfo) = repository.addNew(LikedBreed(0, breed.id ?: " "))

    fun getAllBreed(): List<LikedBreed> = repository.getAll()
}