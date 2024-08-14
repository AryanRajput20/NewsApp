package com.example.mynews.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mynews.models.Article



@Dao
interface ArticleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long
    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<Article>>
    @Query("DELETE FROM articles WHERE id = :articleId")
    suspend fun deleteArticle(articleId: kotlin.Int?)
}