package com.safiribytes.newsapp.domain.usecases.app_entry

import com.safiribytes.newsapp.domain.manager.LocalUserManager

class SaveAppEntry (
    private val localManager: LocalUserManager
    ) {
    suspend operator fun invoke() {
        localManager.saveAppEntry()
    }
}