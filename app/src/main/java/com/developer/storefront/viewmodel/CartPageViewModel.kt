package com.developer.storefront.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.storefront.model.Product
import com.developer.storefront.room.Graph
import com.developer.storefront.room.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class CartPageViewModel(
    private val productRepository: ProductRepository = Graph.productRepository
): ViewModel() {

    lateinit var getAllCartItems: Flow<List<Product>>
    var itemsCount by Delegates.notNull<Int>()


    init{
        viewModelScope.launch(Dispatchers.IO) {
            getAllCartItems = productRepository.getAllCartItems()
            itemsCount = productRepository.getCartItemsCount()
        }
    }

    fun deleteACartItem(product: Product){
        viewModelScope.launch {
            productRepository.deleteACartItem(product = product)
        }
    }

    fun updateACartItemMinus(product: Product){
        product.quantity -= 1

        viewModelScope.launch {
            productRepository.updateACartItem(product = product)
        }
    }

    fun updateACartItemPlus(product: Product){
        product.quantity += 1

        viewModelScope.launch {
            productRepository.updateACartItem(product = product)
        }
    }
}