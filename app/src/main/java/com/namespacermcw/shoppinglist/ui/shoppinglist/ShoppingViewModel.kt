package com.namespacermcw.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.namespacermcw.shoppinglist.data.db.entities.ShoppingItem
import com.namespacermcw.shoppinglist.data.repo.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(private val repository: ShoppingRepository) : ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    // Room allows for thread safety in the Main thread
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    // Does not need to be executed in a coroutine because it is a read
    fun getAllShoppingItems() = repository.getAllShoppingItems()
}