package com.example.assignment1_danny_trenholm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [IceCreamItem::class], version = 1, exportSchema = false)
abstract class IceCreamItemDatabase: RoomDatabase(){
abstract fun iceCreamItemDao(): IceCreamDao

companion object
{
    @Volatile
    private var INSTANCE: IceCreamItemDatabase? = null

    fun getDatabase(context: Context): IceCreamItemDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                IceCreamItemDatabase::class.java,
                "ice_cream_items" // Move the name parameter here
            ).build()
            INSTANCE = instance
            return instance
        }
    }

}
}