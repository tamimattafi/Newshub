package com.tamimattafi.newshub.app.ui.fragments.global

import androidx.annotation.DrawableRes

data class PlaceholderData(
    val label: String,
    val description: String? = null,
    @DrawableRes val drawableRes: Int? = null,
    val action: ActionData
)
