package com.dev.android.quotes.mock

class UserService(private val userRepository: UserRepository) {

    fun loginUser(email:String,password:String):String{
        val status = userRepository.loginUser(email,password)
        return when(status){
            LOGIN_STATUS.INVALID_USER -> "User does not exits"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is invalid"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error occurred"
            LOGIN_STATUS.SUCCESS -> "Logged in successfully"
        }
    }
}