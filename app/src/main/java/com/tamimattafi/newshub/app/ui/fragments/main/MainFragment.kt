package com.tamimattafi.newshub.app.ui.fragments.main

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.mvp.MvpBaseContract
import com.tamimattafi.navigationmanager.navigation.NavigationContract
import com.tamimattafi.newshub.R
import com.tamimattafi.newshub.app.ui.fragments.main.MainContract.*
import kotlinx.android.synthetic.main.fragment_main.*
import  com.tamimattafi.newshub.app.ui.fragments.main.MainValues.Actions.TRY_AGAIN
import javax.inject.Inject

class MainFragment : NavigationContract.NavigationFragment(), View {

    @Inject
    lateinit var presenter: Presenter

    @Inject
    lateinit var adapter: Adapter

    override var fragmentName: String = "fragment-main"
    override val layoutId: Int = R.layout.fragment_main

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.prepare()

        with(refresher) {
            setOnRefreshListener {
                presenter.refresh()
                isRefreshing = false
            }
        }

        presenter.loadData()
    }

    override fun onHolderAction(holder: NewsHolder?, action: Int) {
        if (action == TRY_AGAIN) presenter.loadData()
    }

    override fun onHolderClick(holder: NewsHolder) {
        presenter.onNewsClicked(holder)
    }

    override fun bindHolder(holder: NewsHolder) {
        presenter.bindHolder(holder)
    }

    override fun getAdapter(): MvpBaseContract.Adapter = adapter

    override fun showMessage(message: String) {
        Toast.makeText(appActivity, message, Toast.LENGTH_LONG).show()
    }

    override fun openWebView(link: String) {

    }

    private fun RecyclerView.prepare() {
        layoutManager = LinearLayoutManager(appActivity)
        itemAnimator = DefaultItemAnimator()
        this.prepareScrollListener()
        adapter = this@MainFragment.adapter
    }

    private fun RecyclerView.prepareScrollListener() {
        addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) tryLoadMoreData(recyclerView)
                }
            }
        )
    }

    private fun tryLoadMoreData(recycler: RecyclerView) {
        (recycler.layoutManager as? LinearLayoutManager)?.apply {
            if (findLastVisibleItemPosition() >= itemCount * 90 / 100) {
                presenter.loadData()
            }
        }
    }

}