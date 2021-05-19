package com.namespacermcw.shoppinglist.modules

import android.content.Context
import com.namespacermcw.shoppinglist.ShoppingApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApplication(@ApplicationContext context: Context) : ShoppingApplication {
        return context as ShoppingApplication
    }
}