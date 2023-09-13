package com.msidorenko.cat_project.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msidorenko.cat_project.db.LikedBreed
import com.msidorenko.cat_project.repository.Repository
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class CatViewModel(private val repository: Repository) : ViewModel() {
    val breedList: MutableLiveData<List<BreedInfo>> = MutableLiveData()
    val randomCatNumber: MutableLiveData<Int> = MutableLiveData()

    init {
        getBreeds()
    }

    fun getBreeds() = viewModelScope.launch {
        val response = repository.getAllBreeds()

        if (response.isSuccessful) {
            response.body()?.let { listOfBreeds ->
                breedList.postValue(listOfBreeds)
            }
        }
    }

    fun likeBreed(breed: BreedInfo) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.addNewLikedBreed(breed)
        }
    }

    fun getAllLiked(): LiveData<List<LikedBreed>> = repository.getAllLikedBreeds()

    fun deleteAllLiked() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.deleteAllLikedBreeds()
        }
    }

    fun delete(breed: BreedInfo) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.delete(breed)
        }
    }
}