package com.msidorenko.cat_project.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.msidorenko.cat_project.db.entity.LikedBreed

@Database(
    entities = arrayOf(LikedBreed::class),
    version = 1,
    exportSchema = false
)
public abstract class LikedBreedsDatabase : RoomDatabase() {
    abstract fun likedCatDao(): LikedBreedDao

    companion object{

        @Volatile
        private var INSTANCE: LikedBreedsDatabase? = null

        fun getDatabase(context: Context): LikedBreedsDatabase{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LikedBreedsDatabase::class.java,
                    "liked-breeds-db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}