package com.safiribytes.newsapp.domain.usecases.news

import com.safiribytes.newsapp.data.local.NewsDao
import com.safiribytes.newsapp.domain.model.Article
import com.safiribytes.newsapp.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article? {
       return  newsRepository.selectArticle(url)
    }
}