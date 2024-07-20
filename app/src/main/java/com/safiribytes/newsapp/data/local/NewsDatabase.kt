package com.safiribytes.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.safiribytes.newsapp.domain.model.Article

@Database(entities = [Article::class], version = 2 )
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase: RoomDatabase() {
    abstract val newsDao: NewsDao
}