package com.dev.android.quotes.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Utils {

    fun validPassword(password:String) = when{
        password.isBlank()->{
            "Password is required"
        }
         password.length<6 ->{
             "Length of the password should be greater than 6"
         }
        password.length>15->{
            "Length of the password should be less than 15"
        }
         else -> {
             "Valid"
         }
    }

    fun reverseString(input:String?):String{
        if (input == null){
            throw IllegalArgumentException("Input String is Required")
        }

        val chars = input.toCharArray()
        var i =0
        var j = input.length-1

        while (i<j){
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
        return chars.joinToString("")
    }
}