package com.msidorenko.cat_project.repository

import androidx.lifecycle.LiveData
import com.msidorenko.cat_project.db.LikedBreedDatabase
import com.msidorenko.cat_project.db.LikedBreed

class LikedBreedRepository(database: LikedBreedDatabase) {

    private val dao = database.getDao()

    fun getAll(): List<LikedBreed> = dao.getAll()

    fun addNew(newLikedBreed: LikedBreed) = dao.insert(newLikedBreed)

//    suspend fun deleteAll() = dao.deleteAll()

//    suspend fun delete(breedID: String) = dao.delete(breedID)
}