package com.safiribytes.newsapp.domain.repository

import androidx.paging.PagingData
import com.safiribytes.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}