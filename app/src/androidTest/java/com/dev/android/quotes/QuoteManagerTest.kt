package com.dev.android.quotes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.dev.android.quotes.model.Quote
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

//    @Before
//    fun setUp() {
//    }
//
//    @After
//    fun tearDown() {
//    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets_EmptyFile_expected_Exception() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context,"")
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateQuoteFromAssets_InvalidJson_expected_Exception() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context,"malformed.json")
    }

    @Test
    fun populateQuoteFromAssets_ValidJson_expected_Count() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context,"quotes.json")
        assertEquals(16,quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote(){
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("This is first quote","1"),
            Quote("This is second quote","2"),
            Quote("This is third quote","3")
        ))

        //Act
        val quote = quoteManager.getPreviousQuote()

        // Assert
        assertEquals("1",quote.author)
    }

    @Test
    fun testNextQuote(){
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("This is first quote","1"),
            Quote("This is second quote","2"),
            Quote("This is third quote","3")
        ))

        //Act
        val quote = quoteManager.getNextQuote()

        // Assert
        assertEquals("2",quote.author)
    }
}