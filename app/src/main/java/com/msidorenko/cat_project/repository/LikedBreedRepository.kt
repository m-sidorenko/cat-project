package com.msidorenko.cat_project.repository

import com.msidorenko.cat_project.db.LikedBreedDao
import com.msidorenko.cat_project.db.LikedBreedsDatabase
import com.msidorenko.cat_project.db.entity.LikedBreed
import kotlinx.coroutines.flow.Flow

class LikedBreedRepository(private val database: LikedBreedsDatabase) {

    private val dao = database.likedCatDao()

    fun getAll(): Flow<List<LikedBreed>> = dao.getAll()

    suspend fun addNew(newLikedBreed: LikedBreed) {
        dao.insert(newLikedBreed)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

    suspend fun delete(breedID: String) {
        dao.delete(breedID)
    }
}