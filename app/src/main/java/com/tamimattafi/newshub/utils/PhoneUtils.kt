package com.tamimattafi.newshub.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object PhoneUtils {

    fun Context.isConnected() : Boolean
        = with(getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                getNetworkCapabilities(activeNetwork)?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
            } else @Suppress("DEPRECATION") {
                activeNetworkInfo?.isConnectedOrConnecting ?: false
            }
        }

}