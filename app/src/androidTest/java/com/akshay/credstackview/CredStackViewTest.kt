package com.akshay.credstackview

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.akshay.credstackview.home.HomeActivity
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CredStackViewTest {

  @get:Rule
  var activityRule: ActivityScenarioRule<HomeActivity> =
    ActivityScenarioRule(HomeActivity::class.java)

  @Test
  fun testCreditAmount_nameIsVisible() {
    onView(withId(R.id.credit_amount_question))
      .check(matches(withText(containsString("Nikunj"))))
  }

  @Test
  fun testCreditAmount_clickProceedForEmi_plansAreDisplayed() {
    onView(withId(R.id.button)).perform(click())
    onView(withId(R.id.plans_recycler_view)).check(matches(isDisplayed()))
  }

  @Test
  fun testCreditAmount_clickSelectBank_transactionDetailIsDisplayed() {
    onView(withId(R.id.button)).perform(click())
    onView(withId(R.id.button2)).perform(click())
    onView(withId(R.id.transaction_detail_recycler_view)).check(matches(isDisplayed()))
  }

  @Test
  fun testCreditAmount_clickNextTwoTimes_pressCollapse_plansAreDisplayed() {
    onView(withId(R.id.button)).perform(click())
    onView(withId(R.id.button2)).perform(click())
    onView(withId(R.id.plans_view_expand)).perform(click())
    onView(withId(R.id.plans_recycler_view)).check(matches(isDisplayed()))
  }
}