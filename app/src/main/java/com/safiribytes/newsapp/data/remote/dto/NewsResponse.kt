package com.safiribytes.newsapp.data.remote.dto

import com.safiribytes.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)