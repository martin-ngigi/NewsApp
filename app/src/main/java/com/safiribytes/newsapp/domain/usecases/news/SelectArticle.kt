package com.safiribytes.newsapp.domain.usecases.news

import com.safiribytes.newsapp.data.local.NewsDao
import com.safiribytes.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}