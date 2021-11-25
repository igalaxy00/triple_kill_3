package com.example.triple_kill_5


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import org.junit.Test
import org.junit.runner.RunWith
import android.content.pm.ActivityInfo
import android.view.Gravity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions
import org.junit.Assert

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class Test {

    @Test
    fun testAbout() {
        launchActivity<Activity1>()
    }

    fun firstExist() {

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(doesNotExist())
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(doesNotExist())
    }

    fun secondExist() {
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(doesNotExist())
        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))
    }

    fun thirdExist() {
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(doesNotExist())
    }

    fun aboutExist() {
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.txtInfo)).check(matches(isDisplayed()))
    }


    @get:Rule
    val activityRule = ActivityScenarioRule(Activity1::class.java)

    @Test
    fun firstFragmentTest() {//my test
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))

        firstExist()

        //1f - 2f - 1f
        onView(withId(R.id.bnToSecond)).perform(click())

        secondExist()

        pressBack()

        firstExist()

        //1f - about - 1f
        openAbout()

        aboutExist()

        pressBack()

        firstExist()
    }

    @Test
    fun secondFragmentTest() {
        //imitating user activity: getting to the 2nd fragment
        onView(withId(R.id.bnToSecond)).perform(click())

        secondExist()

        //2f - 1f - 2f
        onView(withId(R.id.bnToFirst)).perform(click())

        firstExist()

        onView(withId(R.id.bnToSecond)).perform(click())

        secondExist()


        //2f - 3f - 2f
        onView(withId(R.id.bnToThird)).perform(click())

        thirdExist()

        pressBack()

        secondExist()

        //2f - about - 2f
        openAbout()

        aboutExist()

        pressBack()

        secondExist()
    }

    @Test
    fun thirdFragmentTest() {
        //imitating user activity: getting to the 3rd fragment
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        thirdExist()

        //3f - 1f - 3f
        onView(withId(R.id.bnToFirst)).perform(click())

        firstExist()

        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        thirdExist()

        //3f - 2f - 3f
        onView(withId(R.id.bnToSecond)).perform(click())

        secondExist()


        onView(withId(R.id.bnToThird)).perform(click())

        thirdExist()

        //3f - about - 3f
        openAbout()

        aboutExist()

        pressBack()

        thirdExist()
    }


    @Test
    fun testNavigation() {

        firstExist()

        openAbout()

        aboutExist()

        pressBack()
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close())

        onView(withId(R.id.bnToSecond)).perform(click())
        secondExist()

        openAbout()

        aboutExist()

        pressBack()
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close())


        onView(withId(R.id.bnToThird)).perform(click())

        thirdExist()


        openAbout()

        aboutExist()

    }


    @Test
    fun testBackStack() {
        // fill backstack
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        openAbout()
        aboutExist()

        pressBack()
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close())

        thirdExist()

        openAbout()
        aboutExist()
        pressBack()
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close())


        pressBack()
        secondExist()

        openAbout()
        aboutExist()
        pressBack()
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close())


        pressBack()
        firstExist()

        openAbout()
        aboutExist()
        pressBack()
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close())


        pressBackUnconditionally()
        Assert.assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }


    @Test
    fun checkRotationScreen() {

        // first fragment
        firstExist()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)

        firstExist()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)


        onView(withId(R.id.bnToSecond)).perform(click())

        // second fragment
        secondExist()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)


        secondExist()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)


        onView(withId(R.id.bnToThird)).perform(click())

        // third fragment
        thirdExist()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)


        thirdExist()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)


        openAbout()

        aboutExist()

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)


        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.txtInfo)).check(matches(isDisplayed()))

        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)


    }


    private fun openAbout() {
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
            .perform(DrawerActions.open()) // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.activityAbout))
    }

}


