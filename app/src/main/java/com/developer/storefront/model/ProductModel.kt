package com.developer.storefront.model

import android.os.Parcelable
import kotlinx.serialization.Serializable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    var id: String,
    var title: String,
    var price: String,
    var category: String,
    var description: String,
    var image: String
): Parcelable
