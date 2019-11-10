package com.tamimattafi.newshub.app.ui.fragments.main

import android.view.View
import com.squareup.picasso.Picasso
import com.tamimattafi.mvp.adapters.holders.RecyclerHolder
import com.tamimattafi.newshub.R
import kotlinx.android.synthetic.main.holder_news.view.*

class NewsViewHolder(itemView: View) : RecyclerHolder(itemView), MainContract.NewsHolder {

    override fun setTitle(title: String?) {
        itemView.title.text = title
    }

    override fun setDescription(description: String?) {
        itemView.description.text = description
    }

    override fun setDate(date: String?) {
        itemView.date.text = date
    }

    override fun setImage(link: String) {
        Picasso.get().load(link)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.placeholder_error)
            .into(itemView.image)
    }

    override fun setImageError() {
        itemView.image.setImageResource(R.drawable.placeholder_error)
    }
}