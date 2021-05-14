package com.namespacermcw.shoppinglist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data keyword signals to the compiler that the main purpose of this class is to hold data
@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_quantity")
    var quantity: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}