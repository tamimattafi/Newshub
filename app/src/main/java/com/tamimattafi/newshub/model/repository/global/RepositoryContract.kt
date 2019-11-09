package com.tamimattafi.newshub.model.repository.global

import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.newshub.model.entities.News

interface RepositoryContract {

    interface NewsApi: MvpBaseContract.PagerListRepository<News>

    interface NewsDatabase : MvpBaseContract.Database<News>, MvpBaseContract.PagerListRepository<News>

}