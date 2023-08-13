package com.ge0rge.newsviewapp

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)


data class Source(
    val id: String,
    val name: String
)


data class Article(
    val author: String,
    val content: Any,
    val description: Any,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: Any
)