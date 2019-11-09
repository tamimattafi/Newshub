package com.tamimattafi.newshub.app.ui.fragments.main

import com.tamimattafi.mvp.MvpBaseContract.PagerListRepository
import com.tamimattafi.mvp.presenters.recycler.PagerRecyclerPresenter
import com.tamimattafi.newshub.app.ui.fragments.main.MainContract.*
import com.tamimattafi.newshub.model.client.ApiValues.Query.Values.MAX_PAGE
import com.tamimattafi.newshub.model.entities.News
import javax.inject.Inject

class MainPresenter @Inject constructor(view: View, repository: PagerListRepository<News>)
    : PagerRecyclerPresenter<News, NewsHolder, View, PagerListRepository<News>>(view, repository), Presenter {

    override fun loadData() {
        if (page <= MAX_PAGE) super.loadData()
    }

    override fun bindHolder(holder: NewsHolder) {
        with(holder) {
            data[listPosition].apply {
                setTitle(title)
                setDate(publishedAt)
                setDescription(description)
                if (!urlToImage.isNullOrEmpty()) setImage(urlToImage)
                else setImageError()
            }
        }
    }

    override fun onNewsClicked(holder: NewsHolder) {
        view.openWebView(data[holder.listPosition].url)
    }

}