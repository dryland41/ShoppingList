package com.namespacermcw.shoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.namespacermcw.shoppinglist.R
import com.namespacermcw.shoppinglist.adapters.ShoppingItemAdapter
import com.namespacermcw.shoppinglist.data.db.entities.ShoppingItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_shopping.*
import javax.inject.Inject

@AndroidEntryPoint
class ShoppingActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ShoppingViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        // Instantiating singletons here makes their existence depend on the ShoppingActivity.
        // REPLACED WITH DI
        //val database = ShoppingDatabase(this)
        //val repository = ShoppingRepository(database)
        //val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }
            ).show()
        }
    }
}