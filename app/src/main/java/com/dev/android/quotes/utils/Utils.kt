package com.dev.android.quotes.utils

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
}