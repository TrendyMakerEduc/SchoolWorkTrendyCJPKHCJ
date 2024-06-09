package com.example.assignment1_danny_trenholm

import android.app.Application

class ToDoApplication: Application() {
    private val database by lazy { IceCreamItemDatabase.getDatabase(this)}
    val repository by lazy{ IceCreamRepository(database.iceCreamItemDao())}
}