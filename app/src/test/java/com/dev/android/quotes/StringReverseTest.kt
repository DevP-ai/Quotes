package com.dev.android.quotes.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class StringReverseTest {

    @Test
    fun testStringReverse_emptyString_expectedEmptyString(){
        val sut = Utils()
        val result = sut.reverseString("")
        assertEquals("",result)
    }

    @Test
    fun testStringReverse_singleChar_expectedSingleChar(){
        val sut = Utils()
        val result = sut.reverseString("a")
        assertEquals("a",result)
    }

    @Test
    fun testStringReverse_validInput_expectedReverseString(){
        val sut = Utils()
        val result = sut.reverseString("abc")
        assertEquals("cba",result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReverse_nullInput_expectedIllegalException(){
        val sut = Utils()
        val result = sut.reverseString(null)
    }

}