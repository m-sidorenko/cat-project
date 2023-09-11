package com.msidorenko.cat_project.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LikedBreed::class],
    version = 1,
    exportSchema = false
)
abstract class LikedBreedDatabase : RoomDatabase() {
    abstract fun getDao(): LikedBreedDao

    companion object {
        @Volatile
        private var instance: LikedBreedDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LikedBreedDatabase::class.java,
                "breed_database"
            ).build()
    }
}