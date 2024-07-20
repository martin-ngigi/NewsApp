package com.safiribytes.newsapp.presentation.details

import com.safiribytes.newsapp.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()
    object RemoveSideEffect: DetailsEvent()
}