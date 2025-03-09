package org.wikipedia.homeworks.homework08.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.pages.OnboardingScreen
import org.wikipedia.homeworks.homework08.pages.items.DataAndPrivacyPagerItem
import org.wikipedia.homeworks.homework08.pages.items.FreeEncyclopediaPagerItem
import org.wikipedia.homeworks.homework08.pages.items.NewWaysToExplorePagerItem
import org.wikipedia.homeworks.homework08.pages.items.languages.LanguageItem
import org.wikipedia.main.MainActivity

class OnboardingScreenTest : TestCase() {
  @get:Rule
  val activityScenarioRule: ActivityScenarioRule<MainActivity> =
    ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun verifyOnboardingSkipButton() {
    val skipButtonText = "Skip"
    run {
      OnboardingScreen.skipButton {
        step("Verify Onboarding Skip button is displayed") { isDisplayed() }
        step("Verify Onboarding Skip button has text [$skipButtonText]") { hasText(skipButtonText) }
        step("Verify Onboarding Skip button is clickable") { isClickable() }
      }
    }
  }

  @Test
  fun verifyContinueButtonChangeTextAtDataAndPrivacyItem() {
    val continueButtonText = "Continue"
    val getStartedButtonText = "Get started"
    run {
      OnboardingScreen.onboardingItems {
        step("Verify Continue button has text [$continueButtonText] at 'Free Encyclopedia' pager item") {
          childAt<FreeEncyclopediaPagerItem>(0) {
            continueButton {
              isVisible()
              hasText(continueButtonText)
            }
          }
        }
        step("Verify Continue button changed text to [$getStartedButtonText] at 'Free Encyclopedia' pager item") {
          childAt<DataAndPrivacyPagerItem>(3) {
            getStartedButton {
              isVisible()
              hasText(getStartedButtonText)
            }
          }
        }
      }
    }
  }

  @Test
  fun verifyFreeEncyclopediaOnboardingScreenIsOpened() {
    val primaryHeaderText = "The Free Encyclopedia"
    run {
      OnboardingScreen.onboardingItems.childAt<FreeEncyclopediaPagerItem>(0) {
        step("Verify logo image is displayed") { logoImageLocator.isDisplayed() }
        step("Verify primary header is visible") { primaryHeader.isVisible() }
        step("Verify primary header text is [$primaryHeaderText]") { primaryHeader.containsText(primaryHeaderText) }
      }
    }
  }

  @Test
  fun verifyNewWaysToExploreOnboardingScreenIsOpened() {
    val primaryHeaderText = "New ways to explore"
    run {
      OnboardingScreen.onboardingItems {
        step("Verify logo image is displayed") {
          childAt<NewWaysToExplorePagerItem>(1) { logoImageLocator.isDisplayed() }
        }
        step("Verify primary header is visible") {
          childAt<NewWaysToExplorePagerItem>(1) { primaryHeader.isVisible() }
        }
        step("Verify primary header text is [$primaryHeaderText]") {
          childAt<FreeEncyclopediaPagerItem>(1) { primaryHeader.containsText(primaryHeaderText) }
        }
      }
    }
  }

  @Test
  fun verifyDefaultLanguageInList() {
    run {
      step("Verify default language in list") {
        OnboardingScreen.onboardingItems.childAt<FreeEncyclopediaPagerItem>(0) {
          languagesListItems.childAt<LanguageItem>(0) {
            languageLocator {
              isVisible()
              containsText("English")
            }
          }
        }
      }
    }
  }
}