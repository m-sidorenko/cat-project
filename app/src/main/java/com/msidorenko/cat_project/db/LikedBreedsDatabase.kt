package com.msidorenko.cat_project.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.msidorenko.cat_project.db.entity.LikedBreed

@Database(
    entities = [LikedBreed::class],
    version = 1,
    exportSchema = false
)
public abstract class LikedBreedsDatabase : RoomDatabase() {
    abstract fun likedCatDao(): LikedBreedDao

    companion object {
        fun getDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            LikedBreedsDatabase::class.java,
            "liked-breeds-db"
        ).build()

    }

}