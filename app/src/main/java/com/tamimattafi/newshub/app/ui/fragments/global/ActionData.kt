package com.tamimattafi.newshub.app.ui.fragments.global

import androidx.annotation.DrawableRes

data class ActionData(
    val label: String,
    @DrawableRes val drawableRes: Int,
    val action: Int
)
