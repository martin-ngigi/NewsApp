package com.safiribytes.newsapp.domain.usecases

import com.safiribytes.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry  (
    private val localManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localManager.readAppEntry()
    }
}