package com.developer.storefront.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cart-items-table")
data class Product(
    @PrimaryKey(autoGenerate = false)
    var id: String,

    @ColumnInfo(name="title")
    var title: String,

    @ColumnInfo(name="price")
    var price: String,

    @ColumnInfo(name="category")
    var category: String,


    var description: String,

    @ColumnInfo(name="image")
    var image: String,

    @ColumnInfo(name="quantity")
    var quantity: Int = 0
): Parcelable
