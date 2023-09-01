package com.msidorenko.cat_project.repository

import androidx.annotation.WorkerThread
import com.msidorenko.cat_project.db.LikedBreedDao
import com.msidorenko.cat_project.db.entity.LikedBreed
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class LikedBreedRepository(private val likedBreedDao: LikedBreedDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allLikedBreed: Flow<List<LikedBreed>> = likedBreedDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(likedBreed: LikedBreed) {
        likedBreedDao.insert(likedBreed)
    }
}