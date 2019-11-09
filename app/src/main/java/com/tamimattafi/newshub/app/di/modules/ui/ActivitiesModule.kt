package com.tamimattafi.newshub.app.di.modules.ui

import com.tamimattafi.newshub.app.di.modules.global.ClientModule
import com.tamimattafi.newshub.app.di.modules.global.DatabaseModule
import com.tamimattafi.newshub.app.di.modules.global.RepositoryModule
import com.tamimattafi.newshub.app.ui.ApplicationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivitiesModule {

    @Singleton
    @ContributesAndroidInjector(modules = [
        ApplicationActivityModule::class,
        FragmentsModule::class,
        ClientModule::class,
        DatabaseModule::class,
        RepositoryModule::class])
    abstract fun applicationActivity(): ApplicationActivity


}