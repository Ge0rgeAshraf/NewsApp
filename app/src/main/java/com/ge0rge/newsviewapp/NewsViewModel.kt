package com.ge0rge.newsviewapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.await
import java.util.Collections.emptyList

class NewsViewModel : ViewModel() {
    private val retrofitInstance = RetrofitClient.getInstance()?.create(ApiService::class.java)
    var newsResponse = NewsResponse(emptyList(), "", 0)

    suspend fun fetchNewsArticles() {
        viewModelScope.launch {
            val response = retrofitInstance?.getNews("eg", "17e0770cb2d2473f9cb474a44abb610")?.await()
            if (response != null) {
                newsResponse = response.body() ?: NewsResponse(emptyList(), "", 0)
            }
        }
    }
}
