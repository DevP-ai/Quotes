package com.dev.android.quotes.mock

import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.SUCCESS)
    }


    @Test
    fun testUserService(){
        //sut: System Under Test
        val sut = UserService(userRepository)
        val status = sut.loginUser("abc@gmail.com","123445677")
        Assert.assertEquals("Logged in successfully",status)
    }

}