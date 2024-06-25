package com.safiribytes.newsapp.domain.usecases.app_entry

import com.safiribytes.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry  (
    private val localManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localManager.readAppEntry()
    }
}