package com.ge0rge.news.data

import com.ge0rge.news.Imaper
import com.ge0rge.news.data.RemoteSource.News
import com.ge0rge.news.model.NewsItemDomain

class NewsToNewsItemMapper : Imaper<News,List<NewsItemDomain>>
{


    override fun map(from: News):List<NewsItemDomain>{

        var listOfArticales : MutableList<NewsItemDomain> = ArrayList()
        for (artical in from.articles)
        {
            listOfArticales.add(NewsItemDomain(artical.title,artical.publishedAt,artical.description,artical.url,artical.urlToImage))
        }
        return listOfArticales
    }
}