package com.msidorenko.cat_project.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "liked_breeds_table")
data class LikedBreed(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "breedId") val breedId: String?
): Serializable
