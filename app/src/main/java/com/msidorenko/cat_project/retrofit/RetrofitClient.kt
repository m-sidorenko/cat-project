package com.msidorenko.cat_project.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private var retrofit: Retrofit? = null

    private var gson = GsonBuilder()
        .setLenient()
        .create()

/*    val loggerInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .addInterceptor(loggerInterceptor)
        .build()*/

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(client)
                .build()
        }
        return retrofit!!
    }
}