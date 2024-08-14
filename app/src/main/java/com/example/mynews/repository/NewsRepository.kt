package com.example.mynews.repository

import com.example.mynews.api.RetrofitInstance
import com.example.mynews.db.ArticleDatabase
import com.example.mynews.models.Article

class NewsRepository( private val db:ArticleDatabase) {
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) {
        db.getArticleDao().upsert(article)
    }

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(articleId: Int?) {
        db.getArticleDao().deleteArticle(articleId)
    }
}
