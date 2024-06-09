package com.example.assignment1_danny_trenholm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface IceCreamDao {
@Query("SELECT * FROM ice_cream_items ORDER BY name ASC")
fun allIceCreams(): Flow<List<IceCreamItem>>

@Query("SELECT * FROM ice_cream_items WHERE isInCart = 1")
fun getShoppingCart(): LiveData<List<IceCreamItem>>



@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertIceCreamItem(iceCreamItem: IceCreamItem)

@Update
suspend fun updateIceCreamItem(iceCreamItem: IceCreamItem)

@Delete
suspend fun deleteIceCreamItem(iceCreamItem: IceCreamItem)
}

