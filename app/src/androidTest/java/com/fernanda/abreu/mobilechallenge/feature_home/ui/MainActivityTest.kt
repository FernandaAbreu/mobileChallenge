package com.fernanda.abreu.mobilechallenge.feature_home.ui


import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4;
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.fernanda.abreu.mobilechallenge.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cash_cardview.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField
    var mMainActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkIfProgressBarIsDisplayedFirstAndMainLinearLayoutIsNotDisplayed() {
        onView(withId(R.id.progress_main)).check(matches(isDisplayed()))
        onView(withId(R.id.llcontainer_main)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
    }

    @Test
    fun checkIftheProductsCashAndSpotlightAreDisplayed(){
        val mainActivityIdlingResource = mMainActivityTestRule.activity.countingIdlingResource
        IdlingRegistry.getInstance().register(mainActivityIdlingResource)
        onView(withId(R.id.llcontainer_main)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.recycler_view_spotlight)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.recycler_view_products)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.title_products)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.cl_cash)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        IdlingRegistry.getInstance().unregister(mainActivityIdlingResource)

    }



}