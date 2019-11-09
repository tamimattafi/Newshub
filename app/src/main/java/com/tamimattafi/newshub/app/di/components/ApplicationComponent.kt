package com.tamimattafi.newshub.app.di.components

import com.tamimattafi.newshub.app.di.modules.ApplicationModule
import com.tamimattafi.newshub.app.di.modules.ui.ActivitiesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivitiesModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(daggerApplication: DaggerApplication): Builder

        fun build(): ApplicationComponent
    }

}
