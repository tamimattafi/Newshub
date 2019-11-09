package com.tamimattafi.newshub.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.newshub.model.database.DatabaseValues.Tables.NEWS_TABLE

@Entity(tableName = NEWS_TABLE)
data class News(
    @PrimaryKey val url: String,
    val title: String,
    val description: String,
    val urlToImage: String?,
    val publishedAt: String
) {

    object Sortables {
        const val PUBLISH_DATE = "publishedAt"
    }

}
