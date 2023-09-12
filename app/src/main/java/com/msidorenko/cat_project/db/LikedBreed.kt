package com.msidorenko.cat_project.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import java.io.Serializable

@Entity(tableName = "liked_breeds_table")
data class LikedBreed(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "breedInfo") val breedInfo: BreedInfo,
    @ColumnInfo(name = "refImageLink") val refImageLink: String? = null,
) : Serializable