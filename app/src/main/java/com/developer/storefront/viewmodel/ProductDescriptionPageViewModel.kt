package com.developer.storefront.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.storefront.model.Product
import com.developer.storefront.room.Graph
import com.developer.storefront.room.ProductRepository
import kotlinx.coroutines.launch

class ProductDescriptionPageViewModel(
    private val productRepository: ProductRepository = Graph.productRepository
): ViewModel() {

    fun addAProduct(product: Product){
        viewModelScope.launch {
            productRepository.addAProduct(product = product)
        }
    }

}