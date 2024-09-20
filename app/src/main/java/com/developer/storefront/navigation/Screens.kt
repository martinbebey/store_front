package com.developer.storefront.navigation

sealed class Screen(val route: String) {
    object HomePage: Screen("home_page_screen")

    object ListingPage: Screen("listing_page_screen")

    object ProductDescriptionPage: Screen("product_description_screen")
}