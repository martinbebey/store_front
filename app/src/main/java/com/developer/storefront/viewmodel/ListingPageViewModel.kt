package com.developer.storefront.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.storefront.model.ListingViewState
import com.developer.storefront.model.Product
import com.developer.storefront.services.KtorApiClient
import com.developer.storefront.services.ProductRepository
import com.developer.storefront.services.fetchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListingPageViewModel(
//    private val repository: ProductRepository = ProductRepository(apiClient = KtorApiClient())
): ViewModel() {
    private val _productsList = MutableStateFlow<List<Product>>(emptyList())
    private val _listingViewState: MutableState<ListingViewState> = mutableStateOf(ListingViewState.Loading)
    val listingViewState: State<ListingViewState> = _listingViewState
    val productList: StateFlow<List<Product>> = _productsList

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //Ktor
//                val fetchedProducts = repository.getProducts()
//                _productsList.emit(fetchedProducts)

                //Retrofit
                val fetchedProducts = fetchService.getProductItems()
                println("shit" + fetchedProducts)

                _listingViewState.value = ListingViewState.Success(fetchedProducts)
            }
            catch (exception: Exception){
                _listingViewState.value = ListingViewState.Error("Error loading products")
                exception.printStackTrace()
            }
        }
    }
}