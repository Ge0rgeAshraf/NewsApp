package com.ge0rge.news.data.RemoteSource

data class News(
    val articles:List<Article>,
    val status:String,
    var totalResults: Int = 0
)


data class Source(
    val id: String,
    val name: String
)

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)