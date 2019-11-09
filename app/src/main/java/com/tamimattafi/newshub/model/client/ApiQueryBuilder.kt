package com.tamimattafi.newshub.model.client

import com.tamimattafi.mvp.repositories.api.repository.QueryBuilder
import com.tamimattafi.newshub.model.client.ApiValues.Query.Parameters.API_KEY
import com.tamimattafi.newshub.model.client.ApiValues.Query.Parameters.FROM
import com.tamimattafi.newshub.model.client.ApiValues.Query.Parameters.PAGE
import com.tamimattafi.newshub.model.client.ApiValues.Query.Parameters.PAGE_SIZE
import com.tamimattafi.newshub.model.client.ApiValues.Query.Parameters.PLATFORM
import com.tamimattafi.newshub.model.client.ApiValues.Query.Parameters.SORT_BY

class ApiQueryBuilder(raw: HashMap<String, String> = HashMap()) : QueryBuilder(raw) {

    fun setPlatform(platform: String): ApiQueryBuilder
        = this.also { custom(PLATFORM, platform) }

    fun setApiKey(key: String): ApiQueryBuilder
        = this.also { custom(API_KEY, key) }

    fun startFrom(date: String): ApiQueryBuilder
        = this.also { custom(FROM, date) }

    fun sortBy(field: String): ApiQueryBuilder
        = this.also { custom(SORT_BY, field) }

    fun setPageSize(size: Any): ApiQueryBuilder
        = this.also { custom(PAGE_SIZE, size) }

    fun setPage(page: Any): ApiQueryBuilder
        = this.also { custom(PAGE, page) }

}