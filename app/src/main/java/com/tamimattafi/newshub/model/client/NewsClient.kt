package com.tamimattafi.newshub.model.client

import com.tamimattafi.newshub.model.entities.News
import retrofit2.http.GET
import com.tamimattafi.newshub.model.client.ApiValues.Paths.NEWS_PATH
import com.tamimattafi.newshub.model.entities.NewsPage
import retrofit2.Call
import retrofit2.http.QueryMap
import javax.inject.Singleton

@Singleton
interface NewsClient {

    @GET(NEWS_PATH)
    fun getNews(@QueryMap query: Map<String, String>): Call<NewsPage>
}