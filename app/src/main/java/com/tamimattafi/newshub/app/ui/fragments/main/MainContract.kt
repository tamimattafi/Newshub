package com.tamimattafi.newshub.app.ui.fragments.main

import com.tamimattafi.mvp.MvpBaseContract.*
import com.tamimattafi.mvp.adapters.PagerRecyclerAdapter

interface MainContract {

    interface NewsHolder : Holder {
        fun setTitle(title: String)
        fun setDescription(description: String)
        fun setDate(date: String)
        fun setImage(link: String)
        fun setImageError()
    }

    interface View : ListenerView<NewsHolder> {
        fun openWebView(link: String)
    }

    interface Presenter : RecyclerPresenter<NewsHolder> {
        fun onNewsClicked(holder: NewsHolder)
    }

    abstract class Adapter(view: View) : PagerRecyclerAdapter<NewsHolder>(view)
}