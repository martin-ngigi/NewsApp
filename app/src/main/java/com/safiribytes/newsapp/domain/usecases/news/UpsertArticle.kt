package com.safiribytes.newsapp.domain.usecases.news

import com.safiribytes.newsapp.data.local.NewsDao
import com.safiribytes.newsapp.domain.model.Article
import com.safiribytes.newsapp.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }
}