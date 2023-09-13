package com.msidorenko.cat_project.retrofit.api

import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import com.msidorenko.cat_project.retrofit.api.models.Image
import com.msidorenko.cat_project.retrofit.api.models.ImageWithBreedInfo
import com.msidorenko.cat_project.retrofit.api.models.RandomCat
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val CAT_BASE_URL = "https://api.thecatapi.com/v1/"

interface CatApiService {
    @GET("images/search")
    fun getRandomCatImage(): Call<List<RandomCat>>

    @GET("breeds")
    suspend fun getBreedList(): Response<List<BreedInfo>>

    @GET("breeds/{breedId}")
    suspend fun getBreedInfo(@Path("breedId") breedId: String): Response<BreedInfo>

    @GET("images/search")
    suspend fun getImageByBreedId(@Query("breed_ids") imageId: String): Response<List<Image>>

    @GET("images/{imageId}")
    suspend fun getImageById(@Path("imageId") imageId: String): Response<ImageWithBreedInfo>
}