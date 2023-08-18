package com.ge0rge.news.model

import com.ge0rge.news.data.RemoteSource.News

interface Repository {

    suspend fun getAllNews() : List<NewsItemDomain>
}