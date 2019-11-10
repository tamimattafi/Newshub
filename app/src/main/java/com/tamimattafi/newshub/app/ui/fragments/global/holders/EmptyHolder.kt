package com.tamimattafi.newshub.app.ui.fragments.global.holders

import android.view.View
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.mvp.adapters.holders.RecyclerHolder
import com.tamimattafi.newshub.app.ui.fragments.global.PlaceholderData
import kotlinx.android.synthetic.main.holder_empty.view.*

class EmptyHolder(itemView: View, placeholderData: PlaceholderData) : ListenerRecyclerHolder(itemView), MvpBaseContract.ListenerHolder {

    init {
        placeholderData.apply {
            itemView.label.text = label
            itemView.description.text = description
            drawableRes?.let { itemView.placeholder.setImageResource(it) }
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