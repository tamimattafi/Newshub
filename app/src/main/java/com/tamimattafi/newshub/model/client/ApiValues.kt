package com.tamimattafi.newshub.model.client

object ApiValues {

    object Paths {
        const val BASE_LINK = "https://newsapi.org/v2/"
        const val NEWS_PATH = "everything"
    }

    object Query {

        object Parameters {
            const val PLATFORM = "q"
            const val API_KEY = "apiKey"
            const val FROM = "from"
            const val SORT_BY = "sortBy"
            const val PAGE_SIZE = "pageSize"
            const val PAGE = "page"
        }

        object Values {
            const val START_DATE = "2019-04-00"
            const val CURRENT_PLATFORM = "android"
            const val API_KEY = "26eddb253e7840f988aec61f2ece2907"
            const val PAGE_SIZE = 5
            const val MAX_PAGE = 5
            const val MIN_PAGE = 1
        }

    }

}