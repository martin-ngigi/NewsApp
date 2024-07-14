package com.safiribytes.newsapp.di

import android.app.Application
import androidx.room.Room
import com.safiribytes.newsapp.data.local.NewsDao
import com.safiribytes.newsapp.data.local.NewsDatabase
import com.safiribytes.newsapp.data.local.NewsTypeConvertor
import com.safiribytes.newsapp.data.manager.LocalUserManagerImpl
import com.safiribytes.newsapp.data.remote.dto.NewsApi
import com.safiribytes.newsapp.data.respository.NewsRepositoryImpl
import com.safiribytes.newsapp.domain.manager.LocalUserManager
import com.safiribytes.newsapp.domain.repository.NewsRepository
import com.safiribytes.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.safiribytes.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.safiribytes.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.safiribytes.newsapp.domain.usecases.news.DeleteArticle
import com.safiribytes.newsapp.domain.usecases.news.GetNews
import com.safiribytes.newsapp.domain.usecases.news.NewsUseCases
import com.safiribytes.newsapp.domain.usecases.news.SearchNews
import com.safiribytes.newsapp.domain.usecases.news.SelectArticle
import com.safiribytes.newsapp.domain.usecases.news.UpsertArticle
import com.safiribytes.newsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun providesAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(
        application: Application
    ): NewsDatabase {
        return  Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = Constants.NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}