package com.namespacermcw.shoppinglist.modules

import com.namespacermcw.shoppinglist.ShoppingApplication
import com.namespacermcw.shoppinglist.data.db.ShoppingDatabase
import com.namespacermcw.shoppinglist.data.repo.ShoppingRepository
import com.namespacermcw.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(shoppingApplication: ShoppingApplication) : ShoppingDatabase {
        return ShoppingDatabase(shoppingApplication.applicationContext)
    }

    @Provides
    @Singleton
    fun providesRepository(shoppingDatabase: ShoppingDatabase) : ShoppingRepository {
        return ShoppingRepository(shoppingDatabase)
    }

    @Provides
    @Singleton
    fun providesFactory(shoppingRepository: ShoppingRepository) : ShoppingViewModelFactory {
        return ShoppingViewModelFactory(shoppingRepository)
    }
}