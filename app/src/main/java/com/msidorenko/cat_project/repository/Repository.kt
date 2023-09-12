package com.msidorenko.cat_project.repository

import com.msidorenko.cat_project.db.LikedBreed
import com.msidorenko.cat_project.db.LikedBreedDatabase
import com.msidorenko.cat_project.retrofit.RetrofitClient
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo

class Repository(database: LikedBreedDatabase) {
    private val dao = database.getDao()

    fun getAllLikedBreeds(): List<LikedBreed> = dao.getAll()

    suspend fun addNewLikedBreed(breed: BreedInfo) {
        val imageId = breed.referenceImageId
        if (!imageId.isNullOrEmpty()) {
            val response = RetrofitClient.instance.getImageById(imageId)
            if (response.isSuccessful && response.body() != null) {
                val responseBody = response.body()
                responseBody?.url?.let { link ->
                    val newLikedBreed = LikedBreed(0, breed, link)
                    dao.insert(newLikedBreed)
                    return
                }
            }
        }
        val newLikedBreed = LikedBreed(0, breed)
        dao.insert(newLikedBreed)
    }

    fun deleteAllLikedBreeds() = dao.deleteAll()

//    suspend fun delete(breedID: String) = dao.delete(breedID)
}