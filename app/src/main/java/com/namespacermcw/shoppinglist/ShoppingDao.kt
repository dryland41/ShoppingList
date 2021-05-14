package com.namespacermcw.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * The Dao tells room how the application will need to access the database
* */
@Dao
interface ShoppingDao {
    // The suspend keyword notifies the compiler that these functions can be
    // executed asynchronously. This is necessary because database calls cannot
    // be executed in the main thread.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}