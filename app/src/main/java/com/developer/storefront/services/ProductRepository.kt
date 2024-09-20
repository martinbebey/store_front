package com.developer.storefront.services

import com.developer.storefront.model.Product

class ProductRepository(
    private val apiClient: KtorApiClient
) {
    suspend fun getProducts(): List<Product> {
        return apiClient.getProducts()
    }
}