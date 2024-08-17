package com.dev.android.quotes.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.dev.android.quotes.model.Quote
import com.google.gson.Gson

class MainViewModel(private val context: Context):ViewModel(){
    private var quoteList:Array<Quote> = emptyArray()
    private var index=0

    init {
        quoteList=loadQuoteFromAssets()
    }


    private fun loadQuoteFromAssets(): Array<Quote> {
        val inputStream=context.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer,Charsets.UTF_8)
        val gson=Gson()
        return gson.fromJson(json,Array<Quote>::class.java)
    }

    fun getQuote()=quoteList[index]

//    fun nextQuote()=quoteList[++index]
//
//    fun previousQuote()=quoteList[--index]

    fun nextQuote(): Quote {
        index = (index + 1) % quoteList.size
        return quoteList[index]
    }

    fun previousQuote(): Quote {
        index = if (index == 0) quoteList.size - 1 else index - 1
        return quoteList[index]
    }


}