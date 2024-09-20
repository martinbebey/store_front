package com.developer.storefront.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.storefront.model.Product
import com.developer.storefront.room.Graph
import com.developer.storefront.room.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CartPageViewModel(
    private val productRepository: ProductRepository = Graph.productRepository
): ViewModel() {

    lateinit var getAllCartItems: Flow<List<Product>>
    init{
        viewModelScope.launch(Dispatchers.IO) {
            getAllCartItems = productRepository.getAllCartItems()
        }
    }

    fun deleteACartItem(product: Product){
        viewModelScope.launch {
            productRepository.deleteACartItem(product = product)
        }
    }
}