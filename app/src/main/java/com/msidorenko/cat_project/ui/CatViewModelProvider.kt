package com.msidorenko.cat_project.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.msidorenko.cat_project.repository.LikedBreedRepository

@Suppress("UNCHECKED_CAST")
class CatViewModelProvider(private val repository: LikedBreedRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatViewModel(repository) as T
    }
}