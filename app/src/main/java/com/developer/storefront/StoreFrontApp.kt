package com.developer.storefront

import android.app.Application
import com.developer.storefront.room.Graph

class StoreFrontApp: Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}