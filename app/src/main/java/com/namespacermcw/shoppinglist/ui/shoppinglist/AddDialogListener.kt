package com.namespacermcw.shoppinglist.ui.shoppinglist

import com.namespacermcw.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}