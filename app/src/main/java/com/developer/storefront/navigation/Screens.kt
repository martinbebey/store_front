package com.developer.storefront.navigation

sealed class Screen(val route: String) {
    object HomePage: Screen("home_page_screen")
}