package com.ge0rge.news.data

import com.ge0rge.news.data.RemoteSource.RemoteSourceFactory
import com.ge0rge.news.model.NewsItemDomain
import com.ge0rge.news.model.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val remoteSourceFactory: RemoteSourceFactory, private val mapper: NewsToNewsItemMapper) : Repository {

    override suspend fun getAllNews(): List<NewsItemDomain> {

        return mapper.map(remoteSourceFactory.getAllNews()!!)
    }


}