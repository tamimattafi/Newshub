package com.tamimattafi.newshub.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tamimattafi.newshub.model.entities.News
import com.tamimattafi.newshub.model.database.DatabaseValues.Info.DATABASE_VERSION
import javax.inject.Singleton

@Singleton
@Database(entities = [News::class], version = DATABASE_VERSION, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}