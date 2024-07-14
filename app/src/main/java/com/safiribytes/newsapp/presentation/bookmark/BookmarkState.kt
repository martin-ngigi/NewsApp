package com.safiribytes.newsapp.presentation.bookmark

import com.safiribytes.newsapp.domain.model.Article

data class BookmarkState (
    val articles: List<Article> = emptyList()
)