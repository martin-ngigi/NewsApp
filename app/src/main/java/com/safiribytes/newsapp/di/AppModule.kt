package com.safiribytes.newsapp.di

import android.app.Application
import com.safiribytes.newsapp.data.manager.LocalUserManagerImpl
import com.safiribytes.newsapp.domain.manager.LocalUserManager
import com.safiribytes.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.safiribytes.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.safiribytes.newsapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

}