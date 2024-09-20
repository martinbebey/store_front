package com.developer.storefront.room

import android.content.Context
import androidx.room.Room

object Graph {
    private lateinit var database: StoreFrontDatabase

    val productRepository by lazy {
        ProductRepository(productDao = database.productDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, StoreFrontDatabase::class.java, "storefront.db").build()
    }
}