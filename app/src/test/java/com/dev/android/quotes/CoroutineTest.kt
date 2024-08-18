package com.dev.android.quotes.utils


import com.dev.android.quotes.MainCoroutineRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CoroutineTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testGetUserName(){
        val sut = CoroutineUtil(mainCoroutineRule.testDispatcher)
        runTest{
            sut.getUserName()
        }
    }


    @Test
    fun testGetUser(){
        val sut = CoroutineUtil(mainCoroutineRule.testDispatcher)
        runTest{
            sut.getUser()
        }
    }

    @Test
    fun testGetAddress(){
        val sut = CoroutineUtil(mainCoroutineRule.testDispatcher)
        runTest{
            sut.getAddress()
        }
    }

    @Test
    fun testGetAddressDetails(){
        val sut = CoroutineUtil(mainCoroutineRule.testDispatcher)
        runTest{
            sut.getAddressDetails()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals(true,sut.globalArg)
        }
    }

}