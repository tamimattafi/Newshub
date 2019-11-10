package com.tamimattafi.newshub.app.ui.fragments.web

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.tamimattafi.navigationmanager.navigation.NavigationContract
import com.tamimattafi.newshub.R
import kotlinx.android.synthetic.main.fragment_web.*
import kotlinx.android.synthetic.main.toolbar_web.*


class WebFragment(private val url: String) : NavigationContract.NavigationFragment() {

    override var fragmentName: String = "fragment-web"
    override val layoutId: Int = R.layout.fragment_web

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareViews()
    }

    private fun prepareViews() {
        with(refresher) {
            isRefreshing = true
            setOnRefreshListener {
                webView.reload()
            }
        }

        back.setOnClickListener {
            navigationManager.requestBackPress()
        }

        searchBar.text = url

        webView.prepare()
    }


    private fun WebView.prepare() {
        @SuppressLint("SetJavaScriptEnabled")
        settings.javaScriptEnabled = true

        webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                this@WebFragment.searchBar.text = url
                refresher.isRefreshing = false
            }
        }

        loadUrl(this@WebFragment.url)
    }

}