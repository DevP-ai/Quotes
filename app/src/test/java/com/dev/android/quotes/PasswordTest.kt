package com.dev.android.quotes.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PasswordTest {

    @Test
    fun validatePassword_blankInput_expectedRequiredFiled(){
        val sut = Utils()
        val result = sut.validPassword("    ")
        assertEquals("Password is required",result)
    }

    @Test
    fun validatePassword_2CharInput_expectedValidateMsg(){
        val sut = Utils()
        val result = sut.validPassword("ab")
        assertEquals("Length of the password should be greater than 6",result)
    }

    @Test
    fun validatePassword_16CharInput_expectedValidateMsg(){
        val sut = Utils()
        val result = sut.validPassword("1234567890123456")
        assertEquals("Length of the password should be less than 15",result)
    }

    @Test
    fun validatePassword_2CharInput_expectedValidatePassword(){
        val sut = Utils()
        val result = sut.validPassword("Pass1234")
        assertEquals("Valid",result)
    }

}