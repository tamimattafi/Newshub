package com.tamimattafi.newshub.app.ui.fragments.global.holders

import android.view.View
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.newshub.app.ui.fragments.global.PlaceholderData
import kotlinx.android.synthetic.main.holder_loading_more_error.view.*

class LoadingErrorHolder(itemView: View, placeholderData: PlaceholderData) : ListenerRecyclerHolder(itemView), MvpBaseContract.ListenerHolder {

    init {
        placeholderData.apply {
            itemView.label.text = label
            with(itemView.button) {
                action.apply {
                    text = label
                    setIconResource(drawableRes)
                    setOnClickListener {
                        onAction?.invoke(action)
                    }
                }
            }
        }
    }
}