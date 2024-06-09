package com.example.assignment1_danny_trenholm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class IceCreamViewModel(private val repository: IceCreamRepository): ViewModel() {



    var iceCreams: LiveData<List<IceCreamItem>> = repository.allIceCreamItem.asLiveData()

    // New function to get items in the shopping cart
    val shoppingCartItems: LiveData<List<IceCreamItem>> = repository.getShoppingCart()


    fun addIceCream(newTask: IceCreamItem) = viewModelScope.launch{
      val newItem = newTask.copy(isInCart = true)
        repository.insertIceCreamItems(newItem)
    }

    fun updateIceCream(taskItem: IceCreamItem) = viewModelScope.launch {
        repository.updateIceCreamItem(taskItem)
    }

    fun removeIceCream(taskItem: IceCreamItem) = viewModelScope.launch {
        repository.deleteIceCreamItem(taskItem)
    }

    fun setCompleted(taskItem: IceCreamItem) = viewModelScope.launch {


        repository.updateIceCreamItem(taskItem)
    }

}

class IceCreamItemModelFactory(private val repository: IceCreamRepository): ViewModelProvider.Factory{
    override fun<T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(IceCreamViewModel::class.java))
            return IceCreamViewModel(repository) as T

        throw IllegalArgumentException("Unknown class")
    }
}