package com.tamimattafi.newshub.app.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerApplication

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(daggerApplication: DaggerApplication): Context
}