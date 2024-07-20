package com.safiribytes.newsapp.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safiribytes.newsapp.domain.model.Article
import com.safiribytes.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    /*
    fun onEvent(event: DetailsEvent){
        when (event){
            is  DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCases.selectArticle(event.article.url )
                    if(article == null){
                        upsertArticle(event.article)
                    }
                    else {
                        deleteArticle(event.article)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }
    */

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val article = newsUseCases.selectArticle(event.article.url)
                    if (article == null) {
                        upsertArticle(event.article)
                    } else {
                        deleteArticle(event.article)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }


    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article = article)
        sideEffect = "Article Deleted Successfully" // notify the UI

    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.upsertArticle(article = article)
        sideEffect = "Article Saved Successfully" // notify the UI
    }

}