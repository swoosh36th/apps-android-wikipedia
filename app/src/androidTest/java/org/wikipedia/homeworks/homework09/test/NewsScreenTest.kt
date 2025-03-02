package org.wikipedia.homeworks.homework09.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework09.pages.explore.ExploreScreen
import org.wikipedia.homeworks.homework09.pages.explore.items.NewsCardViewItem
import org.wikipedia.homeworks.homework09.pages.explore.items.NewsViewItem
import org.wikipedia.homeworks.homework09.pages.fragment.FragmentNewsScreen
import org.wikipedia.homeworks.homework09.pages.fragment.items.CardViewItem
import org.wikipedia.homeworks.homework09.pages.news.NewsScreen
import org.wikipedia.homeworks.homework09.pages.onboarding.OnboardingScreen
import org.wikipedia.main.MainActivity

class NewsScreenTest : TestCase() {
  @get:Rule
  val activityScenarioRule: ActivityScenarioRule<MainActivity> =
    ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun verifyNewsIsDisplayed() {
    run {
      OnboardingScreen {
        step("Verify 'Onboarding' screen is opened") { onboardingScreenHeader.isDisplayed() }
        step("Pass 'Onboarding' screen") {
          skipButton {
            step("Verify 'Skip' button is displayed") { isDisplayed() }
            step("Tap 'Skip' button") { click() }
          }
        }
      }
      ExploreScreen {
        step("Verify 'Explore' screen is opened") { exploreScreenHeader.isDisplayed() }
        step("Navigate to 'In the news' block") {
          items.childAt<NewsCardViewItem>(7) {
            step("Verify 'In the news' header is displayed") { newsHeader.isDisplayed() }
            step("Navigate to 3rd news in 'In the news' block") {
              items.childAt<NewsViewItem>(2) {
                newsTextLocator {
                  step("Verify 3rd news text") { containsText("Wadi C-4") }
                  step("Open 'Fragment news' screen") { click() }
                }
              }
            }
            FragmentNewsScreen {
              step("Verify 'Fragment news' screen is opened") { fragmentNewsHeader.isDisplayed() }
              items.childAt<CardViewItem>(1) {
                cardSubtitleLocator {
                  step("Verify 2nd news text") { containsText("City in") }
                  step("Open 'News' screen") { click() }
                }
              }
              NewsScreen {
                step("Verify 'News' screen is opened") { webContentLocator.isDisplayed() }
              }
            }
          }
        }
      }
    }
  }
}