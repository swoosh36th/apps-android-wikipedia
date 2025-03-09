package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework09.pages.explore.ExploreScreen
import org.wikipedia.homeworks.homework09.pages.explore.items.NewsCardViewItem
import org.wikipedia.homeworks.homework09.pages.onboarding.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale
import java.util.Locale.ENGLISH
import java.util.Locale.FRENCH

class DeviceTest : TestCase() {
  @get:Rule
  val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun rotateScreenTest() {
    before {
      device.uiDevice.setOrientationLeft()
    }.after {
      device.uiDevice.setOrientationNatural()
    }.run {
      step("Verify device orientation isn't natural") {
        Assert.assertFalse(
          "Device has natural orientation",
          device.uiDevice.isNaturalOrientation
        )
      }
    }
  }

  @Test
  fun deviceScreenTurnsOffAndOnTest() {
    before {
      Assert.assertTrue(
        "Device screen is off",
        device.uiDevice.isScreenOn
      )
    }.after {
    }.run {
      step("Turn off device screen") { device.uiDevice.sleep() }
      step("Verify device screen is off") {
        Assert.assertFalse(
          "Device screen is on",
          device.uiDevice.isScreenOn
        )
      }
      step("Turn on device screen") { device.uiDevice.wakeUp() }
      OnboardingScreen {
        step("Verify 'Onboarding' screen is opened") { onboardingScreenHeader.isDisplayed() }
        step("Verify 'Skip' button is displayed") { skipButton.isDisplayed() }
      }
    }
  }

  @Test
  fun applicationCollapseAndExpansionTest() {
    run {
      step("Collapse application") {
        val currentPackageName: String = device.uiDevice.currentPackageName
        device.uiDevice.pressHome()
        Assert.assertTrue(
          "Application is not collapsed",
          currentPackageName != device.uiDevice.currentPackageName
        )
      }
      step("Expand application") {
        repeat(2) { device.uiDevice.pressRecentApps() }
      }
      OnboardingScreen {
        step("Verify 'Onboarding' screen is opened") { onboardingScreenHeader.isDisplayed() }
        step("Verify 'Skip' button is displayed") { skipButton.isDisplayed() }
      }
    }
  }

  @Test
  fun deviceNetworkTurnsOffAndOnTest() {
    before {
    }.after {
      device.network.enable()
    }.run {
      OnboardingScreen {
        step("Verify Onboarding header is displayed") { onboardingScreenHeader.isDisplayed() }
        step("Click skip button") { skipButton.click() }
      }
      step("Turn off network") { device.network.disable() }
      step("Open article") {
        ExploreScreen.items.childAt<NewsCardViewItem>(1) { newsHeader.click() }
      }
      step("Verify network turn off header is displayed") {}
      step("Turn on network") { device.network.enable() }
      step("Click Retry button") {}
      step("Verify article header is displayed") {}
    }
  }

  @Test
  fun changingApplicationLanguageTest() {
    val defaultLanguage: Locale = ENGLISH
    val languageToChange: Locale = FRENCH
    OnboardingScreen {
      before {
        onboardingScreenHeader.containsText("The Free Encyclopedia")
      }.after {
        device.language.switchInApp(defaultLanguage)
      }.run {
        step("Change application language to [$languageToChange]") {
          device.language.switchInApp(languageToChange)
        }
        step("Verify header contains text in [$languageToChange] language") {
          onboardingScreenHeader.containsText("L’encyclopédie libre")
        }
      }
    }
  }

  @Test
  fun mainActivityTest() {
    run {
      step("Verify activity class name") {
        val expectedActivityClassName: String = MainActivity::class.java.name
        val actualActivityClassName: String =
          device.activities.getResumed()?.callingActivity?.className
            ?: error("Activity class name isn't provided")
        Assert.assertEquals(expectedActivityClassName, actualActivityClassName)
      }
    }
  }
}