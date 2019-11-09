package com.tamimattafi.newshub.app.di.modules.ui

import com.tamimattafi.newshub.app.di.modules.ui.fragments.MainModule
import com.tamimattafi.newshub.app.ui.fragments.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainFragment(): MainFragment

}