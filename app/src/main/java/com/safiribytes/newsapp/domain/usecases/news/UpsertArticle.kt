package com.safiribytes.newsapp.domain.usecases.news

import com.safiribytes.newsapp.data.local.NewsDao
import com.safiribytes.newsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}