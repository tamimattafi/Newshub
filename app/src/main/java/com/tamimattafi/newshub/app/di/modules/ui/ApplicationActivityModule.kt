package com.tamimattafi.newshub.app.di.modules.ui

import android.app.Activity
import com.tamimattafi.navigationmanager.navigation.NavigationContract.NavigationManager
import com.tamimattafi.newshub.app.di.modules.global.ClientModule
import com.tamimattafi.newshub.app.di.modules.global.DatabaseModule
import com.tamimattafi.newshub.app.di.modules.global.RepositoryModule
import com.tamimattafi.newshub.app.ui.ApplicationActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ApplicationActivityModule {

    @Binds
    abstract fun bindActivity(applicationActivity: ApplicationActivity): Activity

    @Binds
    abstract fun bindNavigationManager(applicationActivity: ApplicationActivity): NavigationManager


}