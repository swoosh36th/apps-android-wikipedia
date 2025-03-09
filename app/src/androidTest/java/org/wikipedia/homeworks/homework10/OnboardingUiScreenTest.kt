package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiScreenTest : TestCase() {
  @get:Rule
  val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun firstOnboardingScreenTest() {
    run {
      step("Onboarding - First screen - Verify elements") {
        OnboardingUiScreen {
          step("Verify logo is displayed") { logoImageLocator.isDisplayed() }
          step("Verify primary header text") {
            primaryHeader.containsText("The Free Encyclopedia")
          }
          step("Verify secondary header text") {
            secondaryHeader.containsText("We’ve found the following on your device")
          }
          addOrEditLanguageButton {
            step("Verify 'Add or edit language' button is enabled") { isEnabled() }
            step("Verify 'Add or edit language' button is clickable") { isClickable() }
            step("Verify 'Add or edit language' button text") { hasText("Add or edit languages") }
          }
          step("Verify English language added") {
            englishLanguageLocator.containsText("English")
          }
          continueButton {
            step("Verify 'Continue' button is enabled") { isEnabled() }
            step("Verify 'Continue' button is clickable") { isClickable() }
            step("Verify 'Continue' button text") { hasText("Continue") }
          }
          skipButton {
            step("Verify 'Skip' button is enabled") { isEnabled() }
            step("Verify 'Skip' button is clickable") { isClickable() }
            step("Verify 'Skip' button text") { hasText("Skip") }
          }
        }
      }
    }
  }

  @Test
  fun secondOnboardingScreenTest() {
    run {
      step("Onboarding - Second screen - Verify elements") {
        OnboardingUiScreen {
          step("Navigate to second screen") { pageIndicatorLocator.setSelectedItemWithIndex(1) }
          step("Verify primary header text") {
            primaryHeader.containsText("New ways to explore")
          }
          step("Verify secondary header text") {
            secondaryHeader.containsText("Dive down the Wikipedia")
          }
          step("Verify 'Continue' button is displayed") { continueButton.isDisplayed() }
          step("Verify 'Skip' button is displayed") { skipButton.isDisplayed() }
        }
      }
    }
  }

  @Test
  fun thirdOnboardingScreenTest() {
    run {
      step("Onboarding - Third screen - Verify elements") {
        OnboardingUiScreen {
          step("Navigate to third screen") { pageIndicatorLocator.setSelectedItemWithIndex(2) }
          step("Verify primary header text") {
            primaryHeader.containsText("Reading lists with sync")
          }
          step("Verify secondary header text") {
            secondaryHeader.containsText("Yoy can make reading")
          }
          step("Verify 'Continue' button is displayed") { continueButton.isDisplayed() }
          step("Verify 'Skip' button is displayed") { skipButton.isDisplayed() }
        }
      }
    }
  }

  @Test
  fun fourthOnboardingScreenTest() {
    run {
      step("Onboarding - Fourth screen - Verify elements") {
        OnboardingUiScreen {
          step("Navigate to fourth screen") { pageIndicatorLocator.setSelectedItemWithIndex(3) }
          step("Verify primary header text") {
            primaryHeader.containsText("Data & Privacy")
          }
          step("Verify secondary header text") {
            secondaryHeader.containsText("We believe that you should")
          }
          continueButton {
            step("Verify 'Continue' button isn't displayed") { isNotDisplayed() }
            step("Verify 'Continue' button text") { hasText("Get started") }
          }
          step("Verify 'Skip' button isn't displayed") { skipButton.isNotDisplayed() }
        }
      }
    }
  }
}