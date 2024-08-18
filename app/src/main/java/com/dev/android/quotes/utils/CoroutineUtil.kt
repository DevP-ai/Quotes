package com.dev.android.quotes.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineUtil(val dispatcher: CoroutineDispatcher) {
    suspend fun getUserName():String{
        delay(10000)
        return "Devajit"
    }

    suspend fun getUser():String{
        CoroutineScope(dispatcher).launch {
            delay(2000)
        }
        return "User-Devajit"
    }

    suspend fun getAddress():String{
        CoroutineScope(dispatcher).launch {
            delay(5000)
        }
        return "Address"
    }

    var globalArg = false
    fun getAddressDetails(){
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
    }
}