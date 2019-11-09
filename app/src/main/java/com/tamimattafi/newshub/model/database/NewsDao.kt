package com.tamimattafi.newshub.model.database

import androidx.room.Dao
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.tamimattafi.mvp.repositories.database.BaseDao
import com.tamimattafi.newshub.model.entities.News
import dagger.Reusable
import io.reactivex.Flowable

@Reusable
@Dao
interface NewsDao: BaseDao<News> {

    @RawQuery(observedEntities = [News::class])
    override fun getRxList(query: SupportSQLiteQuery): Flowable<List<News>>

    @RawQuery(observedEntities = [News::class])
    override fun getRxItem(query: SupportSQLiteQuery): Flowable<News>

}
