package com.tamimattafi.newshub.app.di.modules.global

import android.content.Context
import androidx.room.Room
import com.tamimattafi.newshub.model.database.Database
import com.tamimattafi.newshub.model.database.DatabaseValues.Info.DATABASE_NAME
import com.tamimattafi.newshub.model.database.NewsDao
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
object DatabaseModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()


    @JvmStatic
    @Reusable
    @Provides
    fun provideNewsDao(database: Database): NewsDao = database.newsDao()


}