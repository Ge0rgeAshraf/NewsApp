package com.ge0rge.news.model

import com.ge0rge.news.data.RepositoryImp
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(private val repository: RepositoryImp) {

    suspend operator fun invoke():List<NewsItemDomain>
    {
        return repository.getAllNews()
    }
}