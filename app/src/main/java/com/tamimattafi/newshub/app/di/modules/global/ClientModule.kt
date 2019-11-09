package com.tamimattafi.newshub.app.di.modules.global

import com.tamimattafi.mvp.repositories.api.interactor.InteractorBuilder
import com.tamimattafi.newshub.model.client.NewsClient
import com.tamimattafi.newshub.model.client.ApiValues.Paths.BASE_LINK
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ClientModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideNewsClient(): NewsClient = InteractorBuilder.createInteractor(BASE_LINK, NewsClient::class.java)

}