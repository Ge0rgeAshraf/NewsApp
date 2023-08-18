package com.ge0rge.news.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ge0rge.news.model.GetAllNewsUseCase
import com.ge0rge.news.model.NewsItemDomain
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val getAllNewsUseCase: GetAllNewsUseCase) : ViewModel(){

    var newsList by mutableStateOf(emptyList<NewsItemDomain>())

    init {
        getAllNews()
    }

    fun getAllNews()
    {
        viewModelScope.launch {
            newsList = getAllNewsUseCase()
        }
    }


}