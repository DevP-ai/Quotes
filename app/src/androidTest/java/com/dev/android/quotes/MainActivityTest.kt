package com.dev.android.quotes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


class MainActivityTest{

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testNextButton_expectedCorrectQuote(){
        onView(withId(R.id.txtNext)).perform(click())
        onView(withId(R.id.txtNext)).perform(click())
        onView(withId(R.id.txtNext)).perform(click())
        onView(withId(R.id.txtQuotes)).check(matches(withText("Difficulties increase the nearer we get to the goal.")))
    }
}