package com.msidorenko.cat_project.db

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var INSTANCE: LikedBreedsDatabase? = null
    fun getInstance(context: Context): LikedBreedsDatabase {
        if (INSTANCE == null) {
            synchronized(LikedBreedsDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }
    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            LikedBreedsDatabase::class.java,
            "favorite-db"
        ).build()
}