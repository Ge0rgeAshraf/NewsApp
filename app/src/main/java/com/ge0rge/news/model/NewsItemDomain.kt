package com.ge0rge.news.model

import java.util.Date

data class NewsItemDomain (
    val title : String,
    val date : String,
    val description : String,
    val url : String,
    val urlToImage : String,
    var isFavorete : Boolean = false
)

