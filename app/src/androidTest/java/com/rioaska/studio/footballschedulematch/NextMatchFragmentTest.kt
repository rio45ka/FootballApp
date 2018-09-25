package com.rioaska.studio.footballschedulematch

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeLeft
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.rioaska.studio.footballschedulematch.R.id.*
import com.rioaska.studio.footballschedulematch.view.home.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 *
 * Created by Rio on 12/09/18.
 * Email rio.aska35@gmail.com
 *
 */
@RunWith(AndroidJUnit4::class)
class NextMatchFragmentTest {

    @Rule
    @JvmField
    val mainRule = IntentsTestRule(HomeActivity::class.java)

    @Test
    fun testRvBehaviour() {
        onView(withId(action_b_prev)).perform(click())
        onView(withId(R.id.vp_fragment)).perform(swipeLeft())
        onView(withId(ll_next_container))
                .check(matches(isDisplayed()))
        onView(withId(rvNext))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        val rand = Random()
        val itemPos = rand.nextInt(12)

        onView(withId(rvNext)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemPos))
    }
}