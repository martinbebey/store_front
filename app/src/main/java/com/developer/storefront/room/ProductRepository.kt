package com.developer.storefront.room

import com.developer.storefront.model.Product
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val productDao: ProductDao
) {

    suspend fun addAProduct(product: Product){
        productDao.addProduct(product)
    }

    fun getAllCartItems(): Flow<List<Product>> = productDao.getAllCartItems()

    fun getAProduct(id: Int): Flow<Product> {
        return productDao.getACartItem(id)
    }

    suspend fun updateACartItem(product: Product){
        productDao.updateACartItem(product)
    }

    suspend fun deleteACartItem(product: Product){
        productDao.deleteACartItem(product)
    }

}