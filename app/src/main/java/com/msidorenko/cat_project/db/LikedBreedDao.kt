package com.msidorenko.cat_project.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LikedBreedDao {
    @Query("SELECT * from liked_breeds_table") // ORDER BY breedId ASC
    fun getAll(): LiveData<List<LikedBreed>>

    @Insert(entity= LikedBreed::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(newLikedCat: LikedBreed)

    @Delete(entity= LikedBreed::class)
    fun delete(likedCat: LikedBreed)

    @Query("DELETE FROM liked_breeds_table")
    fun deleteAll()
}