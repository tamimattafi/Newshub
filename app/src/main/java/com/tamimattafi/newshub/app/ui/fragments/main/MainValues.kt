package com.tamimattafi.newshub.app.ui.fragments.main

import android.content.res.Resources
import com.tamimattafi.newshub.R
import com.tamimattafi.newshub.app.ui.fragments.global.ActionData
import com.tamimattafi.newshub.app.ui.fragments.global.PlaceholderData
import com.tamimattafi.newshub.app.ui.fragments.main.MainValues.Actions.TRY_AGAIN
import com.tamimattafi.newshub.app.ui.fragments.main.MainValues.Actions.getActionData
import java.lang.IllegalArgumentException

object MainValues {

    object Actions {

        const val TRY_AGAIN = 0

        fun Resources.getActionData(action: Int) : ActionData
            = when(action) {
                TRY_AGAIN -> ActionData(
                    getString(R.string.try_again),
                    R.drawable.ic_refresh,
                    action
                )
                else -> throw IllegalArgumentException("Unknown action")
            }

    }


    object Placeholders {

        const val EMPTY_LIST = 0
        const val LOADING_MORE_ERROR = 1

        fun Resources.getPlaceholderData(placeholder: Int): PlaceholderData
            = when (placeholder) {
                EMPTY_LIST -> getEmptyListPlaceholder()
                LOADING_MORE_ERROR -> getLoadingMoreErrorPlaceholder()
                else -> throw IllegalArgumentException("Unknown placeholder")
            }

        private fun Resources.getEmptyListPlaceholder(): PlaceholderData
            = PlaceholderData(
            getString(R.string.error_loading_data),
            getString(R.string.error_loading_data_description),
            getActionData(TRY_AGAIN)
        )

        private fun Resources.getLoadingMoreErrorPlaceholder(): PlaceholderData
                = PlaceholderData(
            getString(R.string.loading_more_error),
            action = getActionData(TRY_AGAIN)
        )
    }
}