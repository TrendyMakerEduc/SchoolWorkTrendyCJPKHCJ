package com.example.assignment1_danny_trenholm

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class IceCreamRepository(private val iceCreamItemDao: IceCreamDao)
{



    val allIceCreamItem: Flow<List<IceCreamItem>> = iceCreamItemDao.allIceCreams()

    @WorkerThread
    suspend fun insertIceCreamItems(iceCreamItem: IceCreamItem){
        iceCreamItemDao.insertIceCreamItem(iceCreamItem)
    }

    @WorkerThread
    suspend fun updateIceCreamItem(iceCreamItem: IceCreamItem){
        iceCreamItemDao.updateIceCreamItem(iceCreamItem)
    }

    @WorkerThread
    suspend fun deleteIceCreamItem(iceCreamItem: IceCreamItem){
        iceCreamItemDao.deleteIceCreamItem(iceCreamItem)
    }

    @WorkerThread
    fun getShoppingCart(): LiveData<List<IceCreamItem>> {
        return iceCreamItemDao.getShoppingCart()
    }
}