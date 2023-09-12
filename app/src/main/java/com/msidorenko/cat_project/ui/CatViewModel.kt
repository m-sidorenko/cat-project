package com.msidorenko.cat_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msidorenko.cat_project.db.LikedBreed
import com.msidorenko.cat_project.repository.Repository
import com.msidorenko.cat_project.retrofit.RetrofitClient
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import kotlinx.coroutines.launch

class CatViewModel(private val repository: Repository) : ViewModel() {
    val breedList: MutableLiveData<List<BreedInfo>> = MutableLiveData()
    val likedBreeds: MutableLiveData<List<BreedInfo>> = MutableLiveData()
    val randomCatNumber: MutableLiveData<Int> = MutableLiveData()

    init {
        getBreeds()
    }

    fun getBreeds() {
        val retrofit = RetrofitClient.instance
        viewModelScope.launch {
            val response = retrofit.getBreedList()

            if (response.isSuccessful) {
                response.body()?.let { listOfBreeds ->
                    breedList.postValue(listOfBreeds)

                    if (listOfBreeds.isNotEmpty()) {
                        randomCatNumber.postValue(
                            (0..listOfBreeds.size).random()
                        )
                    }
                }
            }
        }
    }

    suspend fun likeBreed(breed: BreedInfo) = repository.addNewLikedBreed(breed)

    fun getAllLiked(): List<LikedBreed> = repository.getAllLikedBreeds()

    fun deleteAllLiked() = repository.deleteAllLikedBreeds()
}