package com.ge0rge.news.data.RemoteSource

import javax.inject.Inject

class RemoteSourceFactory @Inject constructor(private val newsInterface: NewsInterface) {


    suspend fun getAllNews() : News?
    {
        return newsInterface.getNews().body()
    }
}