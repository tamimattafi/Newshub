package com.tamimattafi.newshub.app.di.modules.global

import android.content.Context
import android.widget.Toast
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.newshub.R
import com.tamimattafi.newshub.model.entities.News
import com.tamimattafi.newshub.model.repository.NewsDatabaseRepository
import com.tamimattafi.newshub.model.repository.NewsRepository
import com.tamimattafi.newshub.model.repository.global.RepositoryContract.*
import com.tamimattafi.newshub.utils.PhoneUtils.isConnected
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindNewsApi(newsRepository: NewsRepository): NewsApi

    @Binds
    abstract fun bindNewsDatabase(newsDatabaseRepository: NewsDatabaseRepository): NewsDatabase

    @Module
    companion object {
        @JvmStatic
        @Reusable
        @Provides
        fun provideListRepository(context: Context, newsApi: NewsApi, newsDatabase: NewsDatabase): MvpBaseContract.PagerListRepository<News>
            = if (context.isConnected()) newsApi else {
                Toast.makeText(context, context.resources.getText(R.string.offline_message), Toast.LENGTH_LONG).show()
                newsDatabase
            }

    }
}