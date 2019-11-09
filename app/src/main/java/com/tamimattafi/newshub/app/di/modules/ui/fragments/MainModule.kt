package com.tamimattafi.newshub.app.di.modules.ui.fragments

import com.tamimattafi.newshub.app.ui.fragments.main.MainAdapter
import com.tamimattafi.newshub.app.ui.fragments.main.MainContract.*
import com.tamimattafi.newshub.app.ui.fragments.main.MainFragment
import com.tamimattafi.newshub.app.ui.fragments.main.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun bindView(view: MainFragment): View

    @Binds
    abstract fun bindPresenter(presenter: MainPresenter): Presenter

    @Binds
    abstract fun bindAdapter(adapter: MainAdapter): Adapter


}