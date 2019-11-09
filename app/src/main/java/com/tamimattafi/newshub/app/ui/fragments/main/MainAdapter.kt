package com.tamimattafi.newshub.app.ui.fragments.main
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.mvp.adapters.holders.empty.UnbindableHolder
import com.tamimattafi.newshub.R
import com.tamimattafi.newshub.app.ui.fragments.global.holders.EmptyHolder
import com.tamimattafi.newshub.app.ui.fragments.global.holders.LoadingErrorHolder
import com.tamimattafi.newshub.app.ui.fragments.main.MainContract.*
import com.tamimattafi.newshub.app.ui.fragments.main.MainValues.Placeholders.getPlaceholderData
import com.tamimattafi.newshub.app.ui.fragments.main.MainValues.Placeholders.EMPTY_LIST
import com.tamimattafi.newshub.app.ui.fragments.main.MainValues.Placeholders.LOADING_MORE_ERROR
import javax.inject.Inject

class MainAdapter @Inject constructor(view: View) : Adapter(view) {

    override fun getEmptyHolder(parent: ViewGroup): RecyclerView.ViewHolder
        = with(parent.context) {
                EmptyHolder(LayoutInflater.from(this).inflate(
                    R.layout.holder_empty,
                    parent,
                    false
                ), resources.getPlaceholderData(EMPTY_LIST)
            )
        }

    override fun getItemHolder(parent: ViewGroup): RecyclerView.ViewHolder
            = NewsViewHolder(LayoutInflater.from(parent.context).inflate(
                        R.layout.holder_news,
                        parent,
                        false
                    )
                )

    override fun getLoadingErrorHolder(parent: ViewGroup): RecyclerView.ViewHolder
            = with(parent.context) {
                    LoadingErrorHolder(LayoutInflater.from(this).inflate(
                        R.layout.holder_loading_more_error,
                        parent,
                        false
                    ), resources.getPlaceholderData(LOADING_MORE_ERROR)
                )
            }

    override fun getLoadingHolder(parent: ViewGroup): RecyclerView.ViewHolder
            = UnbindableHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.holder_loading,
                parent,
                false
            ))

    override fun getLoadingMoreHolder(parent: ViewGroup): RecyclerView.ViewHolder
            = UnbindableHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.holder_loading_more,
                parent,
                false
            ))


}