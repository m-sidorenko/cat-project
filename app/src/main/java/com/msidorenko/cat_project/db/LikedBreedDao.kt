package com.msidorenko.cat_project.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.msidorenko.cat_project.db.entity.LikedBreed
import kotlinx.coroutines.flow.Flow

@Dao
interface LikedBreedDao {

    @Query("SELECT * from liked_breeds_table ORDER BY breedId ASC")
    fun getAll(): Flow<List<LikedBreed>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    /*suspend*/ fun insert(newLikedCat: LikedBreed)

    @Query("DELETE FROM liked_breeds_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(likedCatId: String)
}