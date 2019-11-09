package com.tamimattafi.newshub.model.repository

import androidx.sqlite.db.SupportSQLiteQuery
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.repositories.database.DatabaseRepository
import com.tamimattafi.mvp.repositories.database.QueryBuilder
import com.tamimattafi.newshub.model.entities.News
import com.tamimattafi.mvp.repositories.database.QueryBuilder.Direction.DESCENDING
import com.tamimattafi.newshub.model.entities.News.Sortables.PUBLISH_DATE
import com.tamimattafi.newshub.model.client.ApiValues.Query.Values.PAGE_SIZE
import com.tamimattafi.newshub.model.database.DatabaseValues.Tables.NEWS_TABLE
import com.tamimattafi.newshub.model.database.NewsDao


import com.tamimattafi.newshub.model.repository.global.RepositoryContract.*
import dagger.Reusable
import javax.inject.Inject

@Reusable
class NewsDatabaseRepository @Inject constructor(dao: NewsDao) : DatabaseRepository<News>(dao), NewsDatabase {

    private val baseQuery = QueryBuilder().selectFrom(NEWS_TABLE)
        .orderBy(PUBLISH_DATE, DESCENDING).rawQuery

    override fun getDataList(page: Int): MvpBaseContract.Callback<ArrayList<News>>
        = super.getList(page.buildQuery())

    private fun Int.buildQuery(): SupportSQLiteQuery
        = QueryBuilder(baseQuery).limit(PAGE_SIZE, getOffset()).build()

    private fun Int.getOffset(): Int = (this - 1) * PAGE_SIZE

}

