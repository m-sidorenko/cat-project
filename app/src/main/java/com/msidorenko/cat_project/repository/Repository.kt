package com.msidorenko.cat_project.repository

import androidx.lifecycle.LiveData
import com.msidorenko.cat_project.db.LikedBreed
import com.msidorenko.cat_project.db.LikedBreedDatabase
import com.msidorenko.cat_project.retrofit.RetrofitClient
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo

class Repository(database: LikedBreedDatabase) {
    private val dao = database.getDao()

    suspend fun getAllBreeds() = RetrofitClient.instance.getBreedList()

    fun getAllLikedBreeds(): LiveData<List<LikedBreed>> = dao.getAll()

    suspend fun addNewLikedBreed(breed: BreedInfo) {
        val imageId = breed.referenceImageId
        if (!imageId.isNullOrEmpty()) {
            val response = RetrofitClient.instance.getImageById(imageId)
            if (response.isSuccessful && response.body() != null) {
                val responseBody = response.body()
                responseBody?.url?.let { link ->
                    val newLikedBreed = LikedBreed(breed, link)
                    dao.insert(newLikedBreed)
                    return
                }
            }
        }
        val newLikedBreed = LikedBreed(breed)
        dao.insert(newLikedBreed)
    }

    fun deleteAllLikedBreeds() = dao.deleteAll()

    fun delete(breed: BreedInfo) {
        val deletingBreed = dao.getAll().value?.find { likedBreed ->
            likedBreed.breedInfo.id == breed.id
        }
        if (deletingBreed != null) {
            dao.delete(deletingBreed)
        }
    }
}