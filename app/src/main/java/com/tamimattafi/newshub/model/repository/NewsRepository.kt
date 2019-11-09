package com.tamimattafi.newshub.model.repository

import com.tamimattafi.newshub.model.entities.News
import com.tamimattafi.newshub.model.entities.News.Sortables.PUBLISH_DATE
import com.tamimattafi.newshub.model.client.ApiQueryBuilder
import com.tamimattafi.newshub.model.client.ApiValues.Query.Values.API_KEY
import com.tamimattafi.newshub.model.client.ApiValues.Query.Values.CURRENT_PLATFORM
import com.tamimattafi.newshub.model.client.ApiValues.Query.Values.PAGE_SIZE
import com.tamimattafi.newshub.model.client.ApiValues.Query.Values.START_DATE
import com.tamimattafi.newshub.model.client.NewsClient
import com.tamimattafi.newshub.model.repository.global.RepositoryContract.*
import com.tamimattafi.mvp.MvpBaseContract.Callback
import com.tamimattafi.mvp.repositories.api.repository.BaseApiRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class NewsRepository @Inject constructor(private val interactor: NewsClient,
                                         private val newsDatabase: NewsDatabase) : BaseApiRepository(), NewsApi {


    private val baseQuery
            = ApiQueryBuilder().startFrom(START_DATE)
                .setApiKey(API_KEY)
                .setPlatform(CURRENT_PLATFORM)
                .sortBy(PUBLISH_DATE)
                .setPageSize(PAGE_SIZE)
                .getRaw()

    override fun getDataList(page: Int): Callback<ArrayList<News>>
        = handleCustomBodyCall(interactor.getNews(page.buildQuery())) { notification, data ->
            newsDatabase.insertAll(data.articles).addCompleteListener {
                notification.notifySuccess(data.articles)
            }.start()
         }

    private fun Int.buildQuery() : Map<String, String>
        = ApiQueryBuilder(baseQuery).setPage(this).build()

    override fun stopListening() {
        super.stopListening()
        newsDatabase.stopListening()
    }


}