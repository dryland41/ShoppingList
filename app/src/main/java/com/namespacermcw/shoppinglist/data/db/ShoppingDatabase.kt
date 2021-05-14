package com.namespacermcw.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.namespacermcw.shoppinglist.data.db.entities.ShoppingItem

// Specify which entities belong to the database and set the version number.
@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {
    // Provide access to database functions inside the database.
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile // Writes to instance will immediately be made available to other threads
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        // Invoke function is executed whenever an instance of the class in made.
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // If instance is null make a new database.
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}