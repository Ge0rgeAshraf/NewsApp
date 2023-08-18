package com.ge0rge.news.data.RemoteSource

import retrofit2.Response
import retrofit2.http.GET


interface NewsInterface {

    @GET("everything/cnn.json")
    suspend fun getNews() : Response<News>
}