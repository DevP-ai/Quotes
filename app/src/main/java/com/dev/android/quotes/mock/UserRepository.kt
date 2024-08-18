package com.dev.android.quotes.mock

class UserRepository {

    val users = listOf<User>(
        User(1,"John","j@gmail.com","1234567"),
        User(2,"Wein","w@gmail.com","1234567"),
        User(3,"Emily","e@gmail.com","1234567")
    )

    fun loginUser(email:String,password:String):LOGIN_STATUS{
        //Fetch User from DB
        val users = users.filter{user: User -> user.email == email }

        return if(users.size == 1){
            if(users[0].password == password){
                LOGIN_STATUS.SUCCESS
            }else{
                LOGIN_STATUS.INVALID_PASSWORD
            }
        }else{
            LOGIN_STATUS.INVALID_USER
        }
    }
}