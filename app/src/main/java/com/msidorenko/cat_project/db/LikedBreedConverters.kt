package com.msidorenko.cat_project.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo

class LikedBreedConverters {
    @TypeConverter
    fun convertLikedBreedToJSONString(likedBreed: LikedBreed): String = Gson().toJson(likedBreed)
    @TypeConverter
    fun convertJSONStringToLikedBreed(jsonString: String): LikedBreed = Gson().fromJson(jsonString, LikedBreed::class.java)

    @TypeConverter
    fun convertBreedInfoToJSONString(breedInfo: BreedInfo): String = Gson().toJson(breedInfo)
    @TypeConverter
    fun convertJSONStringToBreedInfo(jsonString: String): BreedInfo = Gson().fromJson(jsonString, BreedInfo::class.java)
}