package com.msidorenko.cat_project.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    private val loggerInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggerInterceptor)
        .build()

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }
        return retrofit!!
    }
}