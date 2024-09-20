package com.developer.storefront.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.developer.storefront.model.Product


@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = false
)

abstract class StoreFrontDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao //gives access to ProductDao
}