package com.developer.storefront.model

sealed interface ListingViewState {
    data object Loading: ListingViewState

    data class Error(
        val error: String
    ): ListingViewState

    data class Success(
        val productList: List<Product>
    ): ListingViewState
}