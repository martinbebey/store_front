package com.developer.storefront.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.developer.storefront.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //assuming all IDs are different
    abstract suspend fun addProduct(product: Product)

    @Query("Select * from `cart-items-table`")
    abstract fun getAllCartItems(): Flow<List<Product>> //flow reactive live stream

    @Update
    abstract suspend fun updateACartItem(product: Product)

    @Delete
    abstract suspend fun deleteACartItem(product: Product)

    @Query("Select * from `cart-items-table` where id=:id")
    abstract fun getACartItem(id: Int): Flow<Product>
}