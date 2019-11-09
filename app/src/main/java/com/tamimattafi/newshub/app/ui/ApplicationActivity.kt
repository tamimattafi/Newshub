package com.tamimattafi.newshub.app.ui

import android.os.Bundle
import com.tamimattafi.navigationmanager.navigation.NavigationActivity
import com.tamimattafi.newshub.R
import com.tamimattafi.newshub.app.ui.fragments.main.MainFragment

class ApplicationActivity : NavigationActivity() {

    override val layoutId: Int = R.layout.activity_application
    override var rootId: Int = R.id.root

    override fun onActivityCreated() {
        super.onActivityCreated()
        theme.applyStyle(R.style.AppTheme, true)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        requestAttachBaseScreen(MainFragment())
    }

}
