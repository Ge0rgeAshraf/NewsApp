package com.ge0rge.newsviewapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.foundation.lazy.*


object RetrofitClient {

    private const val BASE_URL = "https://newsapi.org/v2/"
    private var retrofitInstence:Retrofit? = null

    fun getInstance() : Retrofit?
    {
        if (retrofitInstence == null)
        {
            retrofitInstence = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }
        return retrofitInstence
    }
}